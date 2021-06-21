package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Flight;
import com.flighttickets.Entities.Plane;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {

    @Test
    public void constructorTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        assertThat(flight).as("Flight object is created properly").isExactlyInstanceOf(Flight.class);
    }

    @Test
    public void getIdTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        Assertions.assertEquals(666, flight.getId(), "should be 666");
    }

    @Test
    public void getFlight_dateTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        Assertions.assertEquals(LocalDate.now(), flight.getFlightdate(), "should be LocalDate.now()");
    }

    @Test
    public void getRoute_idTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        Assertions.assertEquals(234, flight.getRouteid(), "should be 234");
    }

    @Test
    public void getPlane_idTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        Assertions.assertEquals(1234, flight.getPlaneid(), "should be 1234");
    }

    @Test
    public void setIdTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        flight.setId(777);
        Assertions.assertEquals(777, flight.getId(), "should be 777");
    }

    @Test
    public void setRoute_idTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        flight.setRouteid(345);
        Assertions.assertEquals(345, flight.getRouteid(), "should be 345");
    }

    @Test
    public void setPlane_idTest(){
        int flightId = 666;
        LocalDate localDate = LocalDate.now();
        int routeId = 234;
        int planeId = 1234;
        Flight flight = new Flight(flightId, localDate, routeId, planeId);
        flight.setPlaneid(9876);
        Assertions.assertEquals(9876, flight.getPlaneid(), "should be 9876");
    }
}
