package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Booking;
import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Persistance.BookingStorageService;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is used for Business logic and NO Sql is written here.
 */
public class BookingManagerImpl implements BookingManager {


    /**
     * Tuesday and Thursday are to be expensive days
     */
    double expensiveDayMultiplier = 1.56;

    /**
     * Monday and Wednesday are to be cheap days
     */
    double cheapDayMultiplier = 0.5;

    /**
     * Friday, Saturday and Sunday are to be normal days
     */
    int normalDayMultiplier = 1;

    double riskyNationMultiplier = 2.12;


    /**
     * hardcoded ticket price for the sake of my useCase
     */
    private double ticketPrice = 100;


    private List<String> riskyDestinationsList;

    private BookingStorageService bookingStorageService;
    private BookingRequest toBeFinalized;

    /**
     * used by GUIApp
     */
    public BookingManagerImpl() {
    }


    public BookingManagerImpl(BookingRequest toBeFinalized) {
        this.toBeFinalized = toBeFinalized;
        this.riskyDestinationsList = new ArrayList<>() {{
            add("Libya");
            add("Syria");
            add("Iraq");
            add("Yemen");
            add("Somalia");
            add("South Sudan");
            add("Central African Republic");
            add("Part of the Congo");
            add("Mali");
            add("Afghanistan");
        }};
    }

    @Override
    public Booking createBooking(int bookingId, int salesOfficerId, int customerId, LocalDate bookingDate) {
        return new Booking(bookingId, customerId, salesOfficerId, bookingDate);
    }

    @Override
    public void setBookingStorageService(BookingStorageService bookingStorageService) {
        this.bookingStorageService = bookingStorageService;
    }

    @Override
    public int add(Booking booking) throws SQLException, ClassNotFoundException {
        return this.bookingStorageService.insert(booking);
    }

    /**
     * @return calculated price based on several factors (age, day of week, destination, discount coupon)
     */
    @Override
    public double calculatePrice() {
        //Multiply ticket price regarding to the day
        if (this.toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.TUESDAY)
                || this.toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
            this.ticketPrice *= this.expensiveDayMultiplier;
        } else if (toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.MONDAY)
                || toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
            this.ticketPrice *= cheapDayMultiplier;
        } else {
            this.ticketPrice *= normalDayMultiplier;
        }
        //Multiply by risky nation
        //TODO: Make case insensitive
        if (this.riskyDestinationsList.contains(this.toBeFinalized.getArrivalDestination())) {
            this.ticketPrice *= this.riskyNationMultiplier;
        }
        return this.ticketPrice;
    }


    /**
     * Getters and setters for easier testing
     */
    public double getExpensiveDayMultiplier() {
        return expensiveDayMultiplier;
    }

    public double getCheapDayMultiplier() {
        return cheapDayMultiplier;
    }

    public int getNormalDayMultiplier() {
        return normalDayMultiplier;
    }

    public double getRiskyNationMultiplier() {
        return riskyNationMultiplier;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public List<String> getRiskyDestinationsList() {
        return riskyDestinationsList;
    }

    public BookingStorageService getBookingStorageService() {
        return bookingStorageService;
    }

    public BookingRequest getToBeFinalized() {
        return toBeFinalized;
    }
}
