package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.BookingStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.SystemUserStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingManagerImplTest {

    private BookingManager bookingManager;
    private BookingRequest toBeFinalized;
    private TemporalAccessor parsed;
    private DateTimeFormatter formatter;

    private BookingStorageService bookingStorageService;

    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;

    @BeforeEach
    void setUp() {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(Booking.class, new BookingMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        this.bookingManager = this.businesslogicAPI.getBookingManager();



        //arguments to create BookingRequest with test values
        int bookingRequestId = 1;
        int customerId = 1;
        int salesOfficerId = 1;
        String departureDestination = "Test";
        String arrivalDestination = "Test";
        LocalDate departureDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now().plusDays(1);
        int passengersAmount = 1;
        String status = "Pending";

        //Honestly, this implementation is not what I would have done but I noticed it way after merge.
        this.toBeFinalized = new BookingRequest(bookingRequestId, customerId, salesOfficerId, departureDestination, arrivalDestination, departureDate, returnDate, passengersAmount, status);
        this.bookingManager = new BookingManagerImpl(this.toBeFinalized);

        this.bookingManager.setBookingStorageService(this.persistenceAPI.getBookingStorageService());
        this.bookingStorageService = this.persistenceAPI.getBookingStorageService();

        //SetUpFormatter
        this.formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                // use English Locale to correctly parse month and day of week
                .toFormatter(Locale.ENGLISH);
    }


    /**
     * Using getters and setters to change BookingRequest field values and make proper test.
     * Test if price is calculated correctly for Tuesday and Thursday
     */
    @ParameterizedTest
    @CsvSource({"'03/06/2021'", "'01/06/2021'"})
    void calculatePriceDaysMultipliersExpensiveTest(String departureDate) {
        // parse input
        this.parsed = formatter.parse(departureDate);
        //set days
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        //expensive values = 100 * 1.56
        double expectedPrice = 156;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for Tuesday and Thursday").isEqualTo(expectedPrice);
    }

    /**
     * Test if price is calculated correctly for Monday and Wednesday
     *
     * @param departureDate
     */
    @ParameterizedTest
    @CsvSource({"'31/05/2021'", "'02/06/2021'"})
    void calculatePriceDaysMultipliersCheapTest(String departureDate) {
        // parse input
        this.parsed = formatter.parse(departureDate);
        //set days
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        //cheap values = 100 * 0.50
        double expectedPrice = 50;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for Monday and Wednesday").isEqualTo(expectedPrice);
    }

    /**
     * Test if price is calculated correctly for Friday, Saturday and Sunday
     *
     * @param departureDate
     */

    @ParameterizedTest
    @CsvSource({"'04/06/2021'", "'05/06/2021'", "'06/06/2021'"})
    void calculatePriceDaysMultipliersNormalTest(String departureDate) {
        // parse input
        this.parsed = formatter.parse(departureDate);
        //set days
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        //normal values = 100 * 1
        double expectedPrice = 100;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for Friday, Saturday and Sunday").isEqualTo(expectedPrice);
    }

    /**
     * Test if price is calculated correctly for each of the countries contained in the riskyCountry list
     */
    @ParameterizedTest
    @CsvSource({"'Libya'",
            "'Syria'",
            "'Iraq'",
            "'Yemen'",
            "'Somalia'",
            "'South Sudan'",
            "'Central African Republic'",
            "'Mali'",
            "'Afghanistan'",
    })
    void calculatePriceRiskyCountryNormPriceTest(String country) {
        //set arrivalDestination
        this.toBeFinalized.setArrivalDestination(country);
        // parse input
        this.parsed = formatter.parse("05/06/2021");
        //set days
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        //risky country multiplier = 2.12
        double expectedPrice = 212;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for risky country destination").isEqualTo(expectedPrice);
    }

    /**
     * Test if price is calculated correctly for countries that are NOT contained in the risky list
     */
    @ParameterizedTest
    @CsvSource({"'Japan'",
            "'USA'",
            "'Australia'",
            "'Austria'",
            "'Nigeria'",
            "'Oman'",
            "'Serbia'",
            "'Bulgaria'",
            "'South Africa'",
    })
    void calculatePriceNonRiskyNormDayCountryTest(String country) {
        //set arrivalDestination
        this.toBeFinalized.setArrivalDestination(country);
        //set arrivalDestination
        this.toBeFinalized.setArrivalDestination(country);
        // parse input
        this.parsed = formatter.parse("05/06/2021");
        //set days
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        //NonRisky country multiplier = 1
        double expectedPrice = 100;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for risky country destination").isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @CsvSource({"'03/06/2021', 'Libya'",
            "'27/05/2021', 'Somalia'",
            "'01/06/2021', 'Afghanistan'"})
    void riskyCountryExpensiveMultipliersTest(String departureDate, String country) {
        // parse input
        this.parsed = formatter.parse(departureDate);
        //set days
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        this.toBeFinalized.setArrivalDestination(country);
        //expensive values = 100 * 1.56(day) * 2.12(country) = 330.72
        double expectedPrice = 330.72;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for Tuesday and Thursday").isEqualTo(expectedPrice);
    }
    @Test
    public void constructorNoArgumentsTest(){
        assertThat(new BookingManagerImpl()).as("constructorNoArgs").isInstanceOf(BookingManager.class);
    }
    @Test
    public void createBookingTest(){
        Booking actual = this.bookingManager.createBooking(1, 1, 1, LocalDate.of(2021, 4, 1));
        Booking expected = new Booking(1,1,1,LocalDate.of(2021,4,1));

        assertThat(actual).as("Bookings creation works").usingRecursiveComparison().isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource({"'1', '1', '03/02/2021'",
            "'2', '1', '06/02/2021'",
            "'1', '2', '08/02/2021'",
            "'2', '2', '01/05/2021'",
            "'1', '3', '04/06/2021'"})
    public void addTest(int salesOfficerId, int customerId, String date) throws SQLException, ClassNotFoundException {
        int id = 1;
        Booking booking = this.bookingManager.createBooking(id, salesOfficerId, customerId, LocalDate.from(formatter.parse(date)));
        id = this.bookingManager.add(booking);
        Booking Actual = this.bookingStorageService.get(id);

        assertThat(Actual).isExactlyInstanceOf(Booking.class);

    }
    @Test
    public void getBookingTest(){
        Booking Actual = this.bookingManager.getBooking(1);
        Booking Expected = this.bookingStorageService.get(1);

        assertThat(Actual).usingRecursiveComparison().isEqualTo(Expected);
    }
    @Test
    public void getBookingFailTest(){
        Booking Actual = this.bookingManager.getBooking(1);
        Booking Expected = this.bookingStorageService.get(2);

        assertThat(Actual).usingRecursiveComparison().isNotEqualTo(Expected);
    }

}
