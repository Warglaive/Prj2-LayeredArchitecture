package PersistanceTest;

import com.flighttickets.BusinessLogic.CustomerImpl;
import com.flighttickets.BusinessLogic.CustomerManagerImpl;
import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CustomerStorageServiceImplTest {
    CustomerStorageServiceImpl storageService;

    @BeforeEach
    void setUp() {
        CustomerManager customerManager = new CustomerManagerImpl();
        this.storageService = new CustomerStorageServiceImpl();
    }

    @Test
    void constructorTest() {
        assertThat(this.storageService).isExactlyInstanceOf(CustomerStorageServiceImpl.class);
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
        Customer actual = new CustomerImpl(firstName, lastName, email, password, address, level);
        //add customer to Storage
        this.storageService.add(actual);
        //get customer
        Customer expected = this.storageService.getByEmail(email);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    void getAllTest() {
        //create new customers
        Customer first = new CustomerImpl("1", "1", "1", "1", "1", 1);
        Customer second = new CustomerImpl("2", "2", "2", "2", "2", 2);
        Customer third = new CustomerImpl("3", "3", "3", "3", "3", 3);
        //add customers to Storage
        this.storageService.add(first);
        this.storageService.add(second);
        this.storageService.add(third);
        //Add customers to expected list
        List<Customer> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);
        //get all actual Customers from the storageService
        List<Customer> actual = this.storageService.getAll();
        //Compare expected list getAll result List
        assertThat(actual).hasSameElementsAs(expected);
    }
}
