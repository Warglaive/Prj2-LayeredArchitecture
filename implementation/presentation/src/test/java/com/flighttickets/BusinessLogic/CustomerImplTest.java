package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerImplTest {
    @Test
    void customerConstructorTest() {
        int id = 999;
        String firstName = "Tester";
        String lastName = "Tester";
        String email = "user@domain.com";
        String password = "J@vaC0deG##ks";
        String address = "caselstraat 99";
        String role = "Customer";
        Customer customer = new Customer(id, firstName, lastName, email, password, address, role);
        assertThat(customer).as("customer object created properly").isExactlyInstanceOf(Customer.class);
    }
}
