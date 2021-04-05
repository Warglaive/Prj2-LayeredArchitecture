package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import javafx.fxml.FXML;

public class CustomerManagerImpl implements CustomerManager {

    private CustomerStorageService customerStorageService;

    public void setCustomerStorageService(CustomerStorageService customerStorageService) {
        this.customerStorageService = customerStorageService;
    }

    /**
     * Test helper method
     *
     * @return
     */
    public CustomerStorageService getCustomerStorageService() {
        return customerStorageService;
    }

    @Override
    public Customer createCustomer(String firstName, String lastName, String email, String password, String address, int level) {
        return new CustomerImpl(firstName, lastName, email, password, address, level);
    }

    //TODO: Why not void
    @Override
    public Customer add(Customer customer) {
        this.customerStorageService.add(customer);
        return customer;
    }

    public Customer getByEmail(String email) throws ClassNotFoundException {

        Customer c = this.customerStorageService.getByEmail(email);

        //Gets a list of allCustomers -JL
        /*List<Customer> allCust = this.customerStorageService.getAll();*/
        //Cycles through all customers looking for customer with email/pass NOT Done
       /* for (int i = 0; i < allCust.size(); i++) {
            System.out.println(allCust.get(i));
        }*/
        //TODO If i were to change this to something static it still wont work - JL
        return c;
    }

    @FXML
    public Customer login(String email, String password) throws ClassNotFoundException {
        Customer customerToBeLoggedIn = this.getByEmail(email);
        //Check user level and return proper view
        return customerToBeLoggedIn;
    }
}
