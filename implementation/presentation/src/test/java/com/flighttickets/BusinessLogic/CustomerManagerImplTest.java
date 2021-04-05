package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerManagerImplTest {

    private CustomerStorageService customerStorageService;

    private CustomerManager customerManager;


    @BeforeEach
    void setUp() {
        this.customerManager = new CustomerManagerImpl();
        this.customerStorageService = new CustomerStorageServiceImpl(this.customerManager);
    }

    /**
     * test if setCustomerStorageService sets StorageService properly with the help of getCustomerStorageService helper method.
     */
    @Test
    void setCustomerStorageService() {
        this.customerManager.setCustomerStorageService(this.customerStorageService);
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
        assertThat(this.customerManager.createCustomer(firstName, lastName, email, password, address, level))
                .isExactlyInstanceOf(CustomerImpl.class);
    }
}
