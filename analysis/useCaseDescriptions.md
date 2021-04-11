## Customer
| Name | Create a new Ticket request |
| --- | --- |
| Actor | Customer |
| Description | Customer Orders a Ticket|
| Precondition |  Customer must be logged in|
| NEW Scenario | 1. Customer selects time/date and destination/return for trip <br> 2. System sends request to sales officer. <br> 3. Sales officer returns offer with price and reserved seats <br>  4. System asks for Passport/Id code(s) together with date of birth <br> 5. Customer fills passport info and dob(s). <br>6. System asks for (fake)payment method <br> 7. System accepts (fake) payment. <br> 8. After acceptance system sends confirmation to customer with tickets/boardingpasses |
| OLD Scenario | 1. Customer selects time/date and destination/return for trip <br> 2. System shows tickets available and pricing. <br> 3. Customer selects tickets and seats <br>  4. System asks for documents <br> 5. Customer fills documents. <br>6. System asks for payment method <br> 7. System accepts (fake) payment. <br> 8. After acceptance system sends confirmation to customer with tickets/boardingpasses |
| Result | Customer request and booked a ticket |
| Exceptions |TBD  |
| Extensions | N/A  |


| Name | Customer accesses Ticket |
| --- | --- |
| Actor | Customer |
| Description | Customer accesses a Ticket|
| Precondition |  Customer must be logged in|
| Scenario | 1. Customer selects bookings in profile <br> 2. System shows bookings <br> 3. Customer selects specific booking <br> 4. System shows selected seats and tickets. <br> 5. Customer choses to download tickets. <br> 6. System shows downloadable tickets |
| Result |Customer accesses a ticket |
| Exceptions |TBD  |
| Extensions | N/A  |
|Booking | A (collection of) ticket(s)|

| Name | Customer requests a ticket change from SalesOfficer |
| --- | --- |
| Actor | Customer |
| Description | Customer changes Ticket|
| Precondition |  Customer must be logged in|
| NewScenario | 1. Customer selects bookings in profile <br> 2. System shows bookings <br> 3. Customer selects specific booking <br> 4. System shows selected seats and tickets. <br> 5. Customer choses to change ticket(s). <br> 6. System shows gives option to change tickets. <br> 7. Customer changes tickets dates/seats/etc <br> 8. System calculates fees/discount for new ticket(s) <br> 9. Customer pays and accepts. <br> 10. System swaps tickets and sends confirmation |
| Result |Customer changed a ticket |
| OLD Scenario | 1. Customer selects bookings in profile <br> 2. System shows bookings <br> 3. Customer selects specific booking <br> 4. System shows selected seats and tickets. <br> 5. Customer choses to change ticket(s). <br> 6. System shows gives option to change tickets. <br> 7. Customer changes tickets dates/seats/etc <br> 8. System calculates fees/discount for new ticket(s) <br> 9. Customer pays and accepts. <br> 10. System swaps tickets and sends confirmation |
| Result |Customer changed a ticket |
| Exceptions |TBD  |
| Extensions | N/A  |

| Name | Customer requests a ticket to be canceled from the SalesOfficer |
| --- | --- |
| Actor | Customer |
| Description | Customer wants to cancel a Ticket|
| Precondition |  Customer must be logged in and must have bought a ticket|
| Scenario | 1.	Actor decides to cancel a booked ticket <br> 2.	Actor opens overview of orders <br> 3. System provides overview of all orders <br> 4. Actor chooses the order which he want to cancel <br> 5. System offers opportunity to cancel ticket <br> 6. Actor chooses option <br> 7. System cancels ticket |
| Result |Customer canceles a ticket successfully |
| Exceptions | 6. Actor is blocked and cannot do it <br> 7. Ticket cannot be cancelled anymore, go back to step 3 |
| Extensions | N/A  |


## Planner
| Name | Create route |
| --- | --- |
| Actor | Planner |
| Description | Planner Creates Route|
| Precondition |  Planner must be logged in|
| Scenario | 1. Planner selects route option <br> 2. System shows current routes. <br> 3. Planner selects create new route <br> 4. System starts new route steps. <br> 5. Planner selects start and ending location. <br> 6. System accepts route returns to mainscreen. |
| Result |Planner created a route |
| Exceptions |TBD  |
| Extensions | N/A  |

| Name | Set plane to route |
| --- | --- |
| Actor | Planner |
| Description | Planner sets plane to Route|
| Precondition |  Planner must be logged in|
| Scenario | 1. Planner selects route option <br> 2. System shows current routes. <br> 3. Planner selects edit route <br> 4. System starts edit route steps. <br> 5. Planner selects set plane to route. <br> 6. System displays plane selection screen. <br> 7. Planner sets plane to route. <br> 8. System accepts edit to route and returns to mainscreen. |
| Result |Planner added plane to route |
| Exceptions |TBD  |
| Extensions | N/A  |

## Sales Officer
| Name | Process Ticket requests |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer sells a ticket |
| Precondition | Sales Officer must be logged in |
| Scenario | 1. Sales Officer goes to the tickets section <br> 2. System shows all ticket request <br> 3. Sales Officer selects handle request <br> 4. System displays options for handeling a ticket request <br> 5. Sales Officer selects the requested ticket options and saves <br> 6. System accepts the request if dates are correct and returns to the tickets section |
| Result | The ticket(s) are sold |
| Exceptions | N/A |
| Extensions | N/A |

| Name | Edit ticket |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer edits a ticket |
| Precondition | Sales Officer must be logged in |
| Scenario | 1. Sales Officer goes to the tickets section <br> 2. System shows all tickets available <br> 3. Sales Officer selects edit ticket <br> 4. System displays options for editing a ticket <br> 5. Sales Officer changed the ticket options <br> 6. System accepts the changes and returns to the tickets section |
| Result | The ticket is edited |
| Exceptions | 5. ticket can not be edited if you have invalid data, gob back to step 4 |
| Extensions | N/A |

| Name | Add discount |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer adds a discount |
| Precondition | Sales Officer must be logged in |
| Scenario | 1. Sales Officer goes to the tickets section <br> 2. System shows all tickets available <br> 3. Sales Officer selects add discount <br> 4. System displays options for adding a discount <br> 5. Sales Officer puts in information for the discount <br> 6. System validates the discount and returns to the tickets section |
| Result | The discount is added |
| Exceptions | 5. The discount can not be added with an invalid price or code, go back to step 4 |
| Extensions | N/A |

| Name | Edit discount |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer edits a discount |
| Precondition | Sales Officer must be logged in |
| Scenario | 1. Sales Officer goes to the tickets section <br> 2. System shows all tickets available <br> 3. Sales Officer selects edit discount <br> 4. System displays options for editing a discount <br> 5. Sales Officer changed the discount options <br> 6. System accepts the changes and returns to the tickets section |
| Result | The discount is edited |
| Exceptions | 5. The discount can not be edited if you have invalid data, go back to step 4 |
| Extensions | N/A |

| Name | Put ticket on sale |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer wants to put a ticket on sale |
| Precondition | Sales Officer must be logged in |
| Scenario | 1.	Actor decides to put a ticket on sale <br> 2. System offers opportunity to put a ticket on sale <br> 3. Actor chooses the option <br> 4. System gives opportunity to enter information about the ticket <br> 5. Actor enters valid information about the ticket <br> 6. System adds the ticket in to system |
| Result | Ticket is put on sale successfully |
| Exceptions | 2. Sales Officer is blocked and cannot do it <br> 5. Information about ticket is invalid, go back to step 4 |
| Extensions | N/A |

| Name | Log in |
| --- | --- |
| Actor | Sales Officer/ Customer |
| Description | Actor wants to log in |
| Precondition | Actor must have an account and valid sign in data |
| Scenario | 1.	Actor opens system <br> 2. Enters valid log in data (correct email address, password with at least one uppercase letter, number, special character)<br> 3. System validates input if requirements are fulfilled <br> 4. System processes log in |
| Result | Actor is loggend in successfully|
| Exceptions | 3. Actor is blocked, go back to step 2 <br> 3. Input is wrong, go back step 2 |
| Extensions | N/A |

| Name | Register |
| --- | --- |
| Actor | Customer |
| Description | Actor wants to register account |
| Precondition | Actor does not have an account yet |
| Scenario | 1.	Actor opens system <br> 2. Actor chooses to register a new account  <br> 3. System shows form to register a new customer <br> 4. System asks for customer data like a name, password and email address <br> 5. Customer enters name, password and email adress and clicks next <br> 6. System validates input if requirements(correct email adress,password with at least one uppercase letter, number, special character) is fulfilled <br> 7. System returns conformation of new registered account |
| Result | Actor registered successfully|
| Exceptions | 6. Actor has already an account, go back to step 3 <br> 6. Input is invalid, go back to step 3 |
| Extensions | N/A |
