package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
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
     */
    @ParameterizedTest
    @CsvSource({"'03/06/2021'", "'01/06/2021'"})
    void calculatePriceDaysMultipliersTest(String departureDate) {

        // parse input
        this.parsed = formatter.parse(departureDate);


        //DayOfWeek.TUESDAY and DayOfWeek.THURSDAY are considered expensive and multiplied by expensiveDayMultiplier = 1.56
        this.toBeFinalized.setDepartureDate(LocalDate.from(parsed));
        //Ticket price(100) * 1.56 = 156
        double expectedPrice = 156;
        double actualPrice = this.bookingManager.calculatePrice();
        assertThat(actualPrice).as("Calculate price for Tuesday and Thursday").isEqualTo(expectedPrice);

    }
}
