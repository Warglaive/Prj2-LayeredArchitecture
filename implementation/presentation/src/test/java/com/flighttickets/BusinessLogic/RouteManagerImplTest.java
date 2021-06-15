package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.RouteManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RouteManagerImplTest {

    RouteManager routeManager;

    @Test
    public void addRouteTest(){
        int routeId = 444;
        int airportFirst = 76;
        int airportSecond = 402;
        int plannerId = 324;
        Route route = new Route(routeId, airportFirst, airportSecond, plannerId);
        this.routeManager.add(route);
    }

    
}
