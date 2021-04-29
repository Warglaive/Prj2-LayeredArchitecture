## Customer
| Name | Create a new Booking request|
| --- | --- |
| Actor | Customer |
| Description | Customer creates a new booking request|
| Precondition |  Customer must be logged in|
| Scenario | 1. Customer selects departure date, return date, destination, passangers amount and submits the input<br> 2. System makes validations<br>3. System inputs the request into the database. <br> 4. Customer is redirected to "View all booking requests" view. |
| Result | Customer request a booking |
| Exceptions |TBD  |
| Extensions | N/A  |

| Name | Finalize an approved booking request|
| --- | --- |
| Actor | Customer |
| Description | Customer Orders a Booking|
| Precondition |  1. Customer must be logged in. <br> 2. Must have at least 1 approved booking request. |
| Scenario | 1. Customer selects an approved booking request. <br> 2. The system redirects him to specified view to enter date of birth and EU Id Card/ Passport number. and submits it <br> 3. System performs check if the customer is allowed to fly ( old enought and valid documents). <br> 4. System creates a booking containing a ticket/boarding pass.<br> 5. Customer is redirected to a view with the option to download booking info (ticket/boarding pass included) |
| Result | Booking successfully created |
| Exceptions | Invalid documents, customer underaged, customer banned from flying |
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
| Scenario | 1. Customer selects bookings in profile <br> 2. System shows bookings <br> 3. Customer selects specific booking <br> 4. System shows selected seats and tickets. <br> 5. Customer choses to change ticket(s). <br> 6. System shows gives option to change tickets. <br> 7. Customer changes tickets dates/seats/etc <br> 8. System calculates fees/discount for new ticket(s) <br> 9. Customer pays and accepts. <br> 10. System swaps tickets and sends confirmation |
| Result |Customer changed a ticket |
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
| Name | Approve booking request |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer approves a bookingRequest |
| Precondition | Sales Officer must be logged in |
| Scenario | 1. Sales Officer goes to the "view" booking request section <br> 2. System shows all booking requests <br> 3. Sales Officer selects a specific booking request <br> 4. System displays a specific view for the selected request with APPROVE/REJECT options <br> 5. Sales Officer approves the selected request and submits it <br> 6. System sets the status of the request to "approved" or isApproved to "true" <br> 7. System sets the Id of the SalesOfficer to the BookingRequest handled by him |
| Result | successfully approved booking request |
| Exceptions | N/A |
| Extensions | N/A |

| Name | Edit ticket |
| --- | --- |
| Actor | Sales Officer |
| Description | Sales Officer edits a ticket |
| Precondition | Sales Officer must be logged in |
| Scenario | 1. Sales Officer goes to the tickets section <br> 2. System shows all tickets available <br> 3. Sales Officer selects edit ticket <br> 4. System displays options for editing a ticket <br> 5. Sales Officer changed the ticket options <br> 6. System accepts the changes and returns to view all tickets |
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
| Scenario | 1.	Actor opens system <br> 2. Actor chooses to register a new account  <br> 3. System shows form to register a new customer <br> 4. System asks for customer data like a name, password and email address <br> 5. Customer enters name, password and email adress and clicks next <br> 6. System validates input if the following requirements are fulfilled: <ul><li>Users name only contains letters and is 1 to 24 characters long</li><li>The email address contains an @ sign and a domain name</li><li>The password is between 8 and 40 characters long, has at least one lowercase and one uppercase letter, a number and a special character</li><li>the address has a space between the street name and house number</li></ul>7. System returns conformation of new registered account |
| Result | Actor registered successfully|
| Exceptions | 6. Actor has already an account, go back to step 3 <br> 6. Input is invalid, go back to step 3 |
| Extensions | N/A |
