package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.CustomerStorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

/*    @Test
    void getCustomerEmailTest(){
        String firstName = "Jasper";
        String lastName = "Lamers";
        String email = "jasper@test.nl";
        String password = "test";
        String address = "Mook";
        Customer customer = new Customer(firstName, lastName, email, password, address, 1);
        assertThat(customer.getEmail()).as("Customer email received correctly").isEqualTo("jasper@test.nl");
    }

    @Test
    void getCustomerLevelTest(){
        String firstName = "Jasper";
        String lastName = "Lamers";
        String email = "jasper@test.nl";
        String password = "test";
        String address = "Mook";
        Customer customer = new Customer(firstName, lastName, email, password, address, 1);
        assertThat(customer.getLevel()).as("Level Test").isEqualTo(1);
    }*/
/*    @Test
    void loginCustomerTest(){
//        String firstName = "Jasper";
//        String lastName = "Lamers";
//        String email = "jasper@test.nl";
//        String password = "test";
//        String address = "Mook";
//        Customer customer = new CustomerImpl(firstName, lastName, email, password, address, 1);
        LoginImpl login = new LoginImpl();
        assertThat(login.getLoginLevel("Customer", "test")).as("LoginLevelTest").isEqualTo(1);

    }*/

}
