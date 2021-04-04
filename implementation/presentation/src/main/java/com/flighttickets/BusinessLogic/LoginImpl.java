package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;

/**
 *
 * @author JasperLamers jasper.lamers@student.fontys.nl 3375544
 */
public class LoginImpl {

    CustomerManager customerManager;
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
