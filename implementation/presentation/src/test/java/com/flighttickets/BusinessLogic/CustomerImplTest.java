package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
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
        Customer customer = new CustomerImpl(firstName, lastName, email, password, address);
        assertThat(customer).isExactlyInstanceOf(CustomerImpl.class);
    }
}