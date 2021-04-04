package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;

import java.util.List;

/**
 *
 * @author JasperLamers jasper.lamers@student.fontys.nl 3375544
 */
public class LoginImpl {

    CustomerManager customerManager;

    public int getLoginLevel(String email, String passw){

        //System.out.println(customerManager.getUser(email, passw));
        //This implementation should return the customer after looking into persistance
//        Customer admin = new CustomerImpl("Admin", "AlsoAdmin", "Admin@test.nl", "test", "Mook", 3);
//        Customer sales = new CustomerImpl("SalesOfficer", "SalesOfficer", "SalesOfficer@test.nl", "test", "Mook", 2);
//        Customer customer = new CustomerImpl("Customer", "Customer", "Customer@test.nl", "test", "Mook", 1);
//
        if(email.equals("Admin") && passw.equals("test")){
            return 3;
        } else if(email.equals("SalesOfficer") && passw.equals("test")){
            return 2;
        } else if(email.equals("Customer") && passw.equals("test")) {
            return 1;
        }
        return 0;
        //if customer doesnt exist or is blocked return 0
    }

}
