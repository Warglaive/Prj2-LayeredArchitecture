## General Functionality
| --- | --- |

| Test ID | 0 |
| Test Case | Log in |
| Description | Verify "Log in" functionality |
| Pre-steps | None |
| Test steps | 
	1. Actor starts the application.
	Expected: Actor receives an input form.
	2. Actor provides input data.
	Expected: Actor can log in.
	|
| Exceptions |  registration constraints not fulfilled(short pass, illegal characters, etc. |
<br>


## Customer Tests
| --- | --- |
| Test ID | 1 |
| Test Case | Order a Ticket |
| Description | Verify "Show tickets available" functionality |
| Pre-steps | Login
| Test steps | 
	1. Customer selects time/date and destination and or return for trip.
	Expected : Customer can select time/date and destination/return for trip.
	2. Customer selects tickets and seats.
	Expected: Customer can select tickets and seats.
	3. Customer pays and fills documents.
	Expected: Customer can pay and fill documents.
	4. Customer submits documents.
	Expected: Customer receives tickets/boardingpasses.
	|
| Exceptions | InvalidDocuments, PaymentFailed |

| --- | --- |
| Test ID | 2 |
| Test Case | Customer accesses Ticket |
| Description | Verify "Customer access a Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 
	1. Customer selects bookings in profile
	Expected: Customer receives all bookings.
	2. Customer selects specific booking.
	Expected: Customer receives a selected specific booking.
	3. Customer choses to download tickets
	Expected: Customer receives tickets. |
| Exceptions |


| --- | --- |
| Test ID | 3 |
| Test Case | Customer changes Ticket |
| Description | Verify "Customer changes Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 
	1. Customer selects bookings in profile
	Expected: Customer receives all bookings.
	2. Customer selects specific booking.
	Expected: Customer receives a selected specific booking.
	3. Customer selects "change tickets" option.
	4. Customer inputs new dates/seats/etc arguments.
	5. Customer pays and accepts.
	Expected: Customer receives new tickets.
	|
| Exceptions | Invalid input arguments |

| --- | --- |
| Test ID | 4 |
| Test Case | Customer canceles Ticket |
| Description | Verify "Customer canceles Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 
	1. Customer selects bookings in profile
	Expected: Customer receives all bookings.
	2. Customer selects specific booking.
	Expected: Customer receives a selected specific booking.
	3. Customer selects "cancel ticket" option.
	Expected: Customer receives confirmation that cancel ticket is successfull.
	|
| Exceptions | Ticket cannot be cancelled anymore |


## Planner Tests

| --- | --- |
| Test ID | 5 |
| Test Case | Planner Create route |
| Description | Verify "Planner Create route" functionality |
| Pre-steps | 1. Login |
| Test steps | 
	1. Planner selects "view current routes" option.
	Expected: Planner receives current routes.
	2. Planner selects "create new Route" option.
	3. Planner provides arguments(start and end locations).
	Expected: New route is created and returned to Planner. |
| Exceptions |  Invalid arguments |

| --- | --- |
| Test ID | 6 |
| Test Case | Set plane to route |
| Description | Verify "Set plane to route" functionality |
| Pre-steps | 1. Login |
| Test steps | 
	1. Planner selects "view current routes" option.
	Expected: Planner receives current routes.
	2. Planner selects "edit route".
	3. Planner selects "set plane to route"
	Expected: Planner receives planes view.
	4. Planner sets plane to new alredy created route.
	Expected: Planner receives status message.
	|
| Exceptions |  Invalid arguments |

## SalesOfficer Tests
| --- | --- |
| Test ID | 7 |
| Test Case | Edit ticket |
| Description | Verify "Edit ticket" functionality |
| Pre-steps | 1. Login |
| Test steps | 
	1. SalesOfficer selects "view all tickets"
	Expected: SalesOfficer receives all tickets.
	2. SalesOfficer selects "edit ticket".
	Expected: SalesOfficer receives details about selected ticket.
	3. SalesOfficer edit ticket.
	Expected: Status message (successfull or not).
	|
| Exceptions |  Invalid arguments |

| --- | --- |
| Test ID | 8 |
| Test Case | Add discount |
| Description | Verify "Add discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 
	1. SalesOfficer selects "view all tickets"
	Expected: SalesOfficer receives all tickets.
	2. SalesOfficer selects "add discount".
	Expected: SalesOfficer receives details about selected ticket.
	3. SalesOfficer selects "add discount" option for selected ticket.
	4. SalesOfficer inputs discount arguments.
	Expected: Status message (successfull or not).
	|
| Exceptions |  Invalid arguments(discount can not be above specified % or number |

| --- | --- |
| Test ID | 9 |
| Test Case | Edit discount |
| Description | Verify "Edit discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 
	1. SalesOfficer selects "view all tickets"
	Expected: SalesOfficer receives all tickets.
	2. SalesOfficer selects "add discount".
	Expected: SalesOfficer receives details about selected ticket.
	3. SalesOfficer selects "edit discount" option for selected ticket.
	4. SalesOfficer inputs discount arguments.
	Expected: Status message (successfull or not).
	|
| Exceptions |  Invalid arguments(discount can not be above specified % or number |


| --- | --- |
| Test ID | 10 |
| Test Case | Put ticket on sale |
| Description | Verify "Put ticket on sale" functionality |
| Pre-steps | 1. Login |
| Test steps | 
	1. SalesOfficer selects "view all tickets"
	Expected: SalesOfficer receives all tickets.
	1. SalesOfficer selects "put a ticket on sale".
	0. SalesOfficer inputs arguments about "ticketOnSale".
	Expected: SalesOfficer receives Status message (successfull or not).
	|
| Exceptions |  Invalid arguments |