package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.RegisteredUsers;
/**
 *
 * @author JasperLamers jasper.lamers@student.fontys.nl 3375544
 */
public class LoginImpl {


    //TODO Implement actual customers instead of shooting in one blank
//    Customer cust = new CustomerImpl("test", "test", "Customer", "test", "test");
//    Customer salesOfficer = new CustomerImpl("SalesOfficer", "test", "SalesOfficer", "test", "test");
//    Customer admin = new CustomerImpl("Admin", "test", "Admin", "test", "test");
    RegisteredUsers registeredUsers;

    //getloginCredits
    public int getLoginLevel(String email, String passw){
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
