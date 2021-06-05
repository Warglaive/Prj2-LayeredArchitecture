package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.DayOfWeek;
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

    @BeforeEach
    void setUp() {
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
        //
        this.toBeFinalized = new BookingRequest(bookingRequestId, customerId, salesOfficerId, departureDestination, arrivalDestination, departureDate, returnDate, passengersAmount, status);
        this.bookingManager = new BookingManagerImpl(this.toBeFinalized);

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
        assertThat(actualPrice).as("Calculate price for Tuesday and Thursday").isEqualTo(expectedPrice);
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
            "'Afghanistan', 'test'",
    })
    void calculatePriceRiskyCountryTest(String country) {
        //set arrivalDestination
        this.toBeFinalized.setArrivalDestination(country);
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
    void calculatePriceNonRiskyCountryTest(String country) {
        //set arrivalDestination
        this.toBeFinalized.setArrivalDestination(country);
        //NonRisky country multiplier = 1
        double expectedPrice = 100;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for risky country destination").isEqualTo(expectedPrice);
    }
}
