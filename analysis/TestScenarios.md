## General Functionality

|Test ID | -2 |
| --- | --- |
|Test Case | Create account(Register) for SalesOfficer VALID|
|Description |  |
|Pre-steps | None |
|Test steps | 	1. Actor starts the application.<br>2. Actor clicks "Register" button.<br>Expected: Actor receives register input form.<br>3. Actor fills username with "Daniel".<br>4. Actor fills email with "daniel@gmail.com". <br>5. Actor fills password with "12345678_AsD".<br>6. Actor selects role "SalesOfficer" from a dropdown menu.<br>6. Actor clicks "Submit" button.<br>Expected: Entry successfully created into the database and returned on request.  |
|Exceptions |  registration constraints not fulfilled(short pass, illegal characters, etc. |
|Test ID | -1 |
| --- | --- |
|Test Case | Create account(Register) for SalesOfficer INVALID|
|Description |  |
|Pre-steps | None |
|Test steps | 1. Actor starts the application.<br>2. Actor clicks "Register" button.<br>Expected: Actor receives register input form.<br>3. Actor fills username with "Daniel".<br>4. Actor fills email with "daniel@gmail.com".<br>5. Actor fills password with "123"<br>6. Actor selects role "SalesOfficer" from a dropdown menu.<br>7. Actor clicks "Submit" button.<br>Expected: Test failed: Exception thrown expected with message "invalid password". |
|Exceptions |  registration constraints not fulfilled(short pass, illegal characters, etc. |




|Test ID | 0 |
| --- | --- |
|Test Case | Log in as Role: SalesOfficer VALID|
|Description | Verify "Log in" functionality |
|Pre-steps | Register |
|Test steps | 1. Actor starts the application.<br>Expected: Actor receives login input form.<br>2. Actor fills username with "Daniel".<br>3. Actor fills password with "12345678_AsD".<br>4. Actor clicks "submit" button. <br>Expected: Actor receives SalesOfficer Login View |
<br>

|Test ID | 0 |
| --- | --- |
|Test Case | Log in as Role: SalesOfficer INVALID|
|Description | Verify "Log in" functionality |
|Pre-steps | Register |
|Test steps | 1. Actor starts the application. <br>Expected: Actor receives login input form. <br>2. Actor fills username with "DanieLLLLLWrong".<br>3. Actor fills password with "123".<br>4. Actor clicks "submit" button. <br>Expected: Actor receives "Invalid credentials" message |
<br>

## Customer Tests
| Test ID | 1 |
| --- | --- |
| Test Case | Order a Ticket as Customer VALID |
| Description | Verify "Order a Ticket" functionality |
| Pre-steps | Login
| Test steps | 1. Actor selected "Order ticket" button.<br>Expected: A order ticket form is returned to the actor.<br>2. Actor selects "choose dates" field.<br>Expected: a Calendar form is returned to the actor.( Or manual input, to be decided with respect to complexity)<br>3. Actor clicks on departure date(21/03/2021).<br>Expected: A list with all available flights with departure hours for this date is returned to the actor.<br>4. Actor selects 14:00 o'clock.<br>5. Actor fills full name "Svetoslav Stoyanov".<br>6. Actor fills ID Card credentials "0123456789".<br>7. Actor clicks "Submit" button.<br>Expected: Order saved in database and returned on request as object.

| Exceptions | Invalid Card credentials, fake name or something |



| Test ID | 1 |
| --- | --- |
| Test Case | Order a Ticket as Customer INVALID |
| Description | Verify "Order a Ticket" functionality |
| Pre-steps | Login
| Test steps | 1. Actor selected "Order ticket" button.<br>Expected: A order ticket form is returned to the actor.<br>2. Actor selects "choose dates" field.<br>Expected: a Calendar form is returned to the actor.( Or manual input, to be decided with respect to complexity)<br>3. Actor clicks on departure date(21/03/2021).<br>Expected: A list with all available flights with departure hours for this date is returned to the actor.<br>4. Actor selects 14:00 o'clock.<br>5. Actor fills full name "Svetoslav Stoyanov".<br>6. Actor fills ID Card credentials "999999999".<br>7. Actor clicks "Submit" button.<br>Expected: Thrown Exception with message "No such ID card credentials".

| Exceptions | Invalid Card credentials, fake name or something |






| Test ID | 2 |
| --- | --- |
| Test Case | Customer accesses Ticket VALID |
| Description | Verify "Customer access a Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 1. Customer selects "view bookings" option in user profile.<br>Expected: Customer receives all bookings as list.<br>2. Customer selects specific booking available on the list.<br>Expected: Customer receives a selected specific booking.<br>3. Customer choses to download tickets.<br>Expected: Customer receives tickets as PDF/String. |
| Exceptions | |


| Test ID | 3 |
| --- | --- |
| Test Case | Customer changes Ticket |
| Description | Verify "Customer changes Ticket" functionality VALID|
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 1. Customer selects "view all bookings" option in user profile.<br>Expected: Customer receives a list of all bookings.<br>2. Customer selects a specific booking.<br>Expected: Customer receives a view of specific booking.<br>3. Customer selects "change tickets" option.<br>Expected: Customer receives a form to input new ticket info.<br>4. Customer selects "choose dates" field.<br>Expected: a Calendar form is returned to the actor.( Or manual input, to be decided with respect to complexity)<br>5. Customer clicks on departure date(21/03/2021).<br>Expected: A list with all available flights with departure hours for this date is returned to the actor.<br>6. Customer selects 14:00 o'clock.<br>7. Customer fills full name "Svetoslav Stoyanov".<br>8. Customer fills ID Card credentials "0123456789".<br>9. Customer clicks "Submit" button.<br>Expected: Customer receives UPDATED ticket details as View/String.|
| Exceptions | Invalid input arguments |
MULTANI TODO:
| Test ID | 4 |
| --- | --- |
| Test Case | Customer canceles Ticket |
| Description | Verify "Customer canceles Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps |<br>1. Customer selects bookings in profile<br>Expected: Customer receives all bookings.<br>2. Customer selects specific booking<br>Selected Booking: Berlin to Munich on 25.03.2021 at 14:00h<br>Expected: Customer receives the selected specific booking from Berlin to Munich<br>3. Customer selects "cancel ticket" option.<br>Expected: Customer receives confirmation that cancellation of ticket to Munich is successfull. |
| Exceptions | Ticket cannot be cancelled anymore |


## Planner Tests

| Test ID | 5 |
| --- | --- |
| Test Case | Planner Create route |
| Description | Verify "Planner Create route" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. Planner selects "view current routes" option. <br>Expected: Planner receives current routes. <br>2. Planner selects "create new Route" option. <br>3. Planner provides arguments(start and end locations). <br>	Start: Berlin, Germany<br>	End:   Munich, Germany<br>Expected: New route from Berlin to Munich is created and returned to Planner.  |
| Exceptions |  Invalid arguments |

| Test ID | 6 |
| --- | --- |
| Test Case | Set plane to route |
| Description | Verify "Set plane to route" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. Planner selects "view current routes" option. <br>Expected: Planner receives current routes. <br>2. Planner selects "edit route". <br>Selected route: Berlin to Munich <br>3. Planner selects "set plane to route" for the chosen route<br>Expected: Planner receives planes view.<br>4. Planner sets plane to the route.<br>Selected plane: Airbus A300<br>Expected: Planner receives status message. |
| Exceptions |  Invalid arguments |

## SalesOfficer Tests
| Test ID | 7 |
| --- | --- |
| Test Case | Edit ticket |
| Description | Verify "Edit ticket" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "edit ticket" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br>	Expected: SalesOfficer receives details about selected ticket. <br> 3. SalesOfficer edits ticket in its takeoff time. <br>Old Time: 14:00h <br>New Time: 13:00h <br>Expected: Status message (successfull or not). |
| Exceptions |  Invalid arguments |

| Test ID | 7a |
| --- | --- |
| Test Case | Edit ticket |
| Description | Verify "Edit ticket" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "edit ticket" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br>	Expected: SalesOfficer receives details about selected ticket. <br> 3. SalesOfficer edits ticket in its takeoff time. <br>Old Time: 14:00h <br>New Time: 25:00h <br>Expected: Status message "invalid time!".|
| Exceptions |  Invalid arguments |

| Test ID | 8 |
| --- | --- |
| Test Case | Add discount |
| Description | Verify "Add discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "add discount" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br>Expected: SalesOfficer receives details about selected ticket. <br> 3. SalesOfficer selects "add discount" option for selected ticket. <br> Expected: SalesOfficer gets possibility to add discount <br>4. SalesOfficer inputs discount arguments. <br>Discount amount : 10%<br>Expected: Status message (successfull or not).  |

| Test ID | 8a |
| --- | --- |
| Test Case | Add discount |
| Description | Verify "Add discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "add discount" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br>Expected: SalesOfficer receives details about selected ticket. <br> 3. SalesOfficer selects "add discount" option for selected ticket. <br> Expected: SalesOfficer gets possibility to add discount <br>4. SalesOfficer inputs discount arguments. <br>Discount amount : 110% <br>Expected: Status message "invalid discount!"|

| Test ID | 9 |
| --- | --- |
| Test Case | Edit discount |
| Description | Verify "Edit discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "add discount" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br> Expected: SalesOfficer receives details about selected ticket. <br> 3. SalesOfficer selects "edit discount" option for selected ticket. <br> Expected: SalesOfficer gets possibility to edit discount <br>4. SalesOfficer inputs discount arguments. <br> Old discount: 10%<br>New discount: 13%<br>Expected: Status message (successfull or not). |
| Exceptions |  Invalid arguments(discount can not be above specified % or number |

| Test ID | 9a |
| --- | --- |
| Test Case | Edit discount |
| Description | Verify "Edit discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "add discount" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br> Expected: SalesOfficer receives details about selected ticket. <br> 3. SalesOfficer selects "edit discount" option for selected ticket. <br> Expected: SalesOfficer gets possibility to edit discount <br>4. SalesOfficer inputs discount arguments. <br> Old discount: 10%<br>New discount: 110%<br>Expected: Status message "invalid discount!" |

| Test ID | 10 |
| --- | --- |
| Test Case | Put ticket on sale |
| Description | Verify "Put ticket on sale" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "put a ticket on sale" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br> Expected: SalesOfficer gets possibility to write down the price of the ticket. <br>3. SalesOfficer inputs arguments about "ticketOnSale". <br> Price: 95??? <br>Expected: SalesOfficer receives Status message (successfull or not). |
| Exceptions |  Invalid arguments |

| Test ID | 10 |
| --- | --- |
| Test Case | Put ticket on sale |
| Description | Verify "Put ticket on sale" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets" <br> Expected: SalesOfficer receives all tickets. <br> 2. SalesOfficer selects "put a ticket on sale" <br>Selected Ticket: Berlin to Munich on 25.03.2021 at 14:00h <br> Expected: SalesOfficer gets possibility to write down the price of the ticket. <br>3. SalesOfficer inputs arguments about "ticketOnSale". <br> Price: -100??? <br>Expected: SalesOfficer receives Status message "invalid price!"|

## Sales Employee Test
| Test ID | 11 |
| --- | --- |
| Test Case | Receive a list of Open booking request|
| Description | Verify "Open Booking Request List" functionality "Select Request Functionality" with "None selected exception"|
| Pre-steps | 1. Sales employee is logged in |
| Test steps | 1. Sales Employee logs in and  "view all booking request" <br> Expected: Sales Employee receives a list of open BookingRequest. <br> 2. Sales Employee selects "Handle Request" <br>Selected request: Sent to handleBookingRequest <br> Expected: Sales Employee gets selected Booking Request to handle in the next step.<br>3. Sales Employee forgets to select a Request. <br> Expected: SalesOfficer receives Status message "No BookingRequest selected!"|

| Test ID | 12 |
| --- | --- |
| Test Case | Create Booking from booking request |
| Description | Verify "Create Booking" functionality |
| Pre-steps | 1. Sales Employee is logged in |
| Test steps | 1. Sales Employee opens booking handle window from the Overview with a request selected <br> Expected: Sales Employee receives all tickets available for that request. <br> 2. Sales Employee selects tickets available <br> Sales Employee Accepts BookingRequest <br> Expected: System accepts and creates a booking and attaches tickets to it. <br>3. Sales Employee didnt select a ticket. <br> Expected: Sales Employee receives message "No tickets selected!"|

| Test ID | 13 |
| --- | --- |
| Test Case | Decline Booking Request |
| Description | Verify "Decline Booking Request" functionality |
| Pre-steps | 1. Sales Employee is logged in |
| Test steps | 1. Sales Employee opens booking handle window from the Overview with a request selected <br> Expected: Sales Employee receives all tickets available for that request.<br> Expected: Sales Employee has no tickets to fill request. <br>3. Sales Employee selects decline request. <br> System updates request status with "Declined" |

| Test ID | 14 |
| --- | --- |
| Test Case | Verify booking(request) date. not in the past |
| Description | Verify "Booking(Request) date" functionality |
| Pre-steps | 1. Sales Employee is logged in |
| Test steps | 1. Sales Employee opens booking handle window from the Overview with a request selected <br> Expected: System Recognizes booking request is in the past/outdated throws exception/error message <br> 2. Sales Employee declines Booking Request|

| Test ID | 15 |
| --- | --- |
| Test Case | Verify Login as sales Employee |
| Description | Verify "Put ticket on sale" functionality |
| Pre-steps | User is registered |
| Test steps | 1. SalesOfficer enters his user/password <br> Expected: System receives systemuser. <br> 2. System checks what the system user role is and redirects <br> Expected role = " SalesEmployee "|
