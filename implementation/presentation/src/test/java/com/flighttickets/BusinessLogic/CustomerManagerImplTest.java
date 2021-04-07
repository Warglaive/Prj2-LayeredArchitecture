package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerManagerImplTest {

    private CustomerStorageService customerStorageService;

    private CustomerManager customerManager;


    @BeforeEach
    void setUp() {
        this.customerManager = new CustomerManagerImpl();
        this.customerStorageService = new CustomerStorageServiceImpl(this.customerManager);
        this.customerManager.setCustomerStorageService(this.customerStorageService);
    }

    /**
     * test if setCustomerStorageService sets StorageService properly with the help of getCustomerStorageService helper method.
     */
    @Test
    void setCustomerStorageService() {
        // this.customerManager.setCustomerStorageService(this.customerStorageService);
        assertThat(this.customerManager.getCustomerStorageService()).isExactlyInstanceOf(CustomerStorageServiceImpl.class);
    }

    /**
     * test if Customer object is properly created
     */
    @Test
    void createCustomerTest() {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //Check if it is not null rather than .class
        assertThat(this.customerManager.createCustomer(firstName, lastName, email, password, address, level))
                .isExactlyInstanceOf(CustomerImpl.class);
    }


    @Test
    void getByEmailTest() throws ClassNotFoundException {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //create new customer
        Customer actual = this.customerManager.createCustomer(firstName, lastName, email, password, address, level);
        //add customer to Storage
        this.customerManager.add(actual);
        //get customer
        String emailExpected = actual.getEmail();
        Customer expected = this.customerManager.getByEmail(emailExpected);
        //.usingRecursiveComparison()
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }



    @Test
    void addTest() throws ClassNotFoundException {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //create new customer
        Customer actual = this.customerManager.createCustomer(firstName, lastName, email, password, address, level);
        //add customer to Storage
        this.customerManager.add(actual);
        //get customer
        String emailExpected = actual.getEmail();
        Customer expected = this.customerManager.getByEmail(emailExpected);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    void addTestException() throws ClassNotFoundException {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //create new customer
        Customer actual = this.customerManager.createCustomer(firstName, lastName, email, password, address, level);
        //add customer to Storage
        this.customerManager.add(actual);
        ThrowableAssert.ThrowingCallable code = () -> {
            String emailExpected = "nonExistentEmail";
            //get customer
            Customer expected = this.customerManager.getByEmail(emailExpected);

        };
        assertThatThrownBy(code).isExactlyInstanceOf(ClassNotFoundException.class).hasMessage("No customer with such email address");

    }
    //TODO: add test for login method
}
