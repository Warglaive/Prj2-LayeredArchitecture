package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Route;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RouteTest {

    @Test
    public void createConstructorTest(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        assertThat(route).as("Route object is created correctly").isExactlyInstanceOf(Route.class);
    }

    @Test
    public void getIdTest(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        Assertions.assertEquals(444, route.getId(), "Route Id should be 444");
    }

    @Test
    public void getStartAirport(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        Assertions.assertEquals(76, route.getStart_airport(), "Start airport id should be 76");
    }

    @Test
    public void getEndAirport(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        Assertions.assertEquals(402, route.getEnd_airport(), "Start airport id should be 402");
    }

    @Test
    public void getPlannerId(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        Assertions.assertEquals(324, route.getPlannerId(), "Start airport id should be 324");
    }

    @Test
    public void setIdTest(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        route.setId(433);
        Assertions.assertEquals(433, route.getId(), "Start airport id should be 433");
    }

    @Test
    public void setStart_airport(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        route.setStart_airport(67);
        Assertions.assertEquals(67, route.getStart_airport(), "Start airport id should be 67");
    }

    @Test
    public void setEnd_airport(){
        int routeId = 444;
        int startAirport = 76;
        int endAirport = 402;
        int plannerId = 324;
        Route route = new Route(routeId, startAirport, endAirport, plannerId);
        route.setEnd_airport(42);
        Assertions.assertEquals(42, route.getEnd_airport(), "Start airport id should be 42");
    }
}
