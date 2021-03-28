package PersistanceTest;

import com.flighttickets.BusinessLogic.CustomerImpl;
import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.RegisteredUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisteredUsersTest {
    RegisteredUsers users;

    @BeforeEach
    void setUp() {
        this.users = new RegisteredUsers();
    }

    @Test
    void constructorTest() {
        assertThat(users).isExactlyInstanceOf(RegisteredUsers.class);
    }

    @Test
    void addTest() {
        Customer c = new CustomerImpl("test", "test", "test", "test", "test");
        this.users.add(c); //add to list
        List<Customer> getAllList = this.users.getAll(); //get all as List
        //check if properly added
        assertThat(getAllList.contains(c)).as("Customer properly added").isTrue();
    }
}
