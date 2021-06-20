/*
package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Plane;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

*/
/**
 * NOT MY STUFF - Stoyanov
 *//*

public class PlaneTest {

    @Test
    public void constructorTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        assertThat(plane).as("Plane object is created correctly").isExactlyInstanceOf(Plane.class);
    }

    @Test
    public void getIdTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals(555, plane.getId(), "Id should be 555");
    }

    @Test
    public void getRegistrationTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals("ABCDE", plane.getRegistration(), "Registration should be ABCDE");
    }

    @Test
    public void getBrandTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals("Airbus", plane.getBrand(), "Brand should be Airbus");
    }

    @Test
    public void getTypeTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals("Big Plane", plane.getType(), "Type should be Big Plane");
    }

    @Test
    public void getSeats_on_boardTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals(300, plane.getSeats_on_board(), "Seats on board should be 300");
    }

    @Test
    public void getExtra_legroom_seatsTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals(100, plane.getExtra_legroom_seats(), "Extra legroom seats should be 100");
    }

    @Test
    public void getFirst_class_seatsTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        Assertions.assertEquals(50, plane.getFirst_class_seats(), "First class seats should be 50");
    }

    @Test
    public void setIdTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setId(666);
        Assertions.assertEquals(666, plane.getId(), "Id should be 666");
    }

    @Test
    public void setRegistrationTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setRegistration("XYZ12");
        Assertions.assertEquals("XYZ12", plane.getRegistration(), "Brand should be XYZ12");
    }

    @Test
    public void setBrandTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setBrand("Boeing");
        Assertions.assertEquals("Boeing", plane.getBrand(), "Brand should be Boeing");
    }

    @Test
    public void setTypeTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setType("Very big plane");
        Assertions.assertEquals("Very big plane", plane.getType(), "Type should be Very big plane");
    }

    @Test
    public void setSeats_on_boardTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setSeats_on_board(299);
        Assertions.assertEquals(299, plane.getSeats_on_board(), "Seats on board should be 299");
    }

    @Test
    public void setExtra_Legroom_seatsTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setExtra_legroom_seats(99);
        Assertions.assertEquals(99, plane.getExtra_legroom_seats(), "Extra legroom seats should be 99");
    }

    @Test
    public void setFirst_class_seatsTest() {
        int id = 555;
        String registration = "ABCDE";
        String brand = "Airbus";
        String type = "Big Plane";
        int seats_on_board = 300;
        int extra_legroom_seats = 100;
        int first_class_seats = 50;
        Plane plane = new Plane(id, registration, brand, type, seats_on_board, extra_legroom_seats, first_class_seats);
        plane.setFirst_class_seats(49);
        Assertions.assertEquals(49, plane.getFirst_class_seats(), "First class seats should be 49");
    }
}
*/
