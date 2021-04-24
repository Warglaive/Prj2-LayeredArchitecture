package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.SystemUser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SystemUserImplTest {
    @Test
    void customerConstructorTest() {
        int id = 999;
        String firstName = "Tester";
        String lastName = "Tester";
        String email = "user@domain.com";
        String password = "J@vaC0deG##ks";
        String address = "caselstraat 99";
        String role = "Customer";
        SystemUser systemUser = new SystemUser(id, firstName, lastName, email, password, address, role);
        assertThat(systemUser).as("SystemUser object created properly").isExactlyInstanceOf(SystemUser.class);
    }
}
