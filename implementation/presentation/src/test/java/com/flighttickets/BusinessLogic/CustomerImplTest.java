package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerImplTest {
    @Test
    void constructorTest() {
        String firstName = "FName";
        String lastName = "LName";
        String email = "mail";
        String password = "pass";
        String address = "adr";
        Customer customer = new CustomerImpl(firstName, lastName, email, password, address, 1);
        assertThat(customer).as("customer object created properly").isExactlyInstanceOf(CustomerImpl.class);
    }

    @Test
    void getCustomerEmailTest(){
        String firstName = "Jasper";
        String lastName = "Lamers";
        String email = "jasper@test.nl";
        String password = "test";
        String address = "Mook";
        Customer customer = new CustomerImpl(firstName, lastName, email, password, address, 1);
        assertThat(customer.getEmail()).as("Customer email received correctly").isEqualTo("jasper@test.nl");
    }

    @Test
    void getCustomerLevelTest(){
        String firstName = "Jasper";
        String lastName = "Lamers";
        String email = "jasper@test.nl";
        String password = "test";
        String address = "Mook";
        Customer customer = new CustomerImpl(firstName, lastName, email, password, address, 1);
        assertThat(customer.getLevel()).as("Level Test").isEqualTo(1);
    }

    @Test
    void loginCustomerTest(){
//        String firstName = "Jasper";
//        String lastName = "Lamers";
//        String email = "jasper@test.nl";
//        String password = "test";
//        String address = "Mook";
//        Customer customer = new CustomerImpl(firstName, lastName, email, password, address, 1);
        LoginImpl login = new LoginImpl();
        assertThat(login.getLoginLevel("Customer", "test")).as("LoginLevelTest").isEqualTo(1);

    }
}