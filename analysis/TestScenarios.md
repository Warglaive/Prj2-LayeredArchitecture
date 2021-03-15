## General Functionality
|Test ID | 0 |
| --- | --- |
|Test Case | Log in |
|Description | Verify "Log in" functionality |
|Pre-steps | None |
|Test steps | 1. Actor starts the application.<br> Expected: Actor receives an input form.<br> 2. Actor provides input data.<br> Expected: Actor can log in. |
|Exceptions |  registration constraints not fulfilled(short pass, illegal characters, etc. |
<br>


## Customer Tests
| Test ID | 1 |
| --- | --- |
| Test Case | Order a Ticket |
| Description | Verify "Show tickets available" functionality |
| Pre-steps | Login
| Test steps | 1. Customer selects time/date and destination and or return for trip.<br> Expected : Customer can select time/date and destination/return for trip.<br> 2. Customer selects tickets and seats.<br> Expected: Customer can select tickets and seats.<br> 3. Customer pays and fills documents.<br> Expected: Customer can pay and fill documents.<br> 4. Customer submits documents.<br> Expected: Customer receives tickets/boardingpasses.<br> |
| Exceptions | InvalidDocuments, PaymentFailed |

| Test ID | 2 |
| --- | --- |
| Test Case | Customer accesses Ticket |
| Description | Verify "Customer access a Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 1. Customer selects bookings in profile<br> Expected: Customer receives all bookings.<br> 2. Customer selects specific booking.<br> Expected: Customer receives a selected specific booking.<br> 3. Customer choses to download tickets<br> Expected: Customer receives tickets. |
| Exceptions | |


| Test ID | 3 |
| --- | --- |
| Test Case | Customer changes Ticket |
| Description | Verify "Customer changes Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 1. Customer selects bookings in profile<br> Expected: Customer receives all bookings.<br> 2. Customer selects specific booking.<br> Expected: Customer receives a selected specific booking.<br> 3. Customer selects "change tickets" option.<br> 4. Customer inputs new dates/seats/etc arguments.<br> 5. Customer pays and accepts.<br> Expected: Customer receives new tickets.<br> |
| Exceptions | Invalid input arguments |


| Test ID | 4 |
| --- | --- |
| Test Case | Customer canceles Ticket |
| Description | Verify "Customer canceles Ticket" functionality |
| Pre-steps | 1. Login, 2. Order a Ticket |
| Test steps | 1. Customer selects bookings in profile<br> Expected: Customer receives all bookings.<br> 2. Customer selects specific booking.<br> Expected: Customer receives a selected specific booking.<br> 3. Customer selects "cancel ticket" option.<br> Expected: Customer receives confirmation that cancel ticket is successfull.<br> |
| Exceptions | Ticket cannot be cancelled anymore |


## Planner Tests

| Test ID | 5 |
| --- | --- |
| Test Case | Planner Create route |
| Description | Verify "Planner Create route" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. Planner selects "view current routes" option.<br> Expected: Planner receives current routes.<br> 2. Planner selects "create new Route" option.<br> 3. Planner provides arguments(start and end locations).<br> Expected: New route is created and returned to Planner.<br>  |
| Exceptions |  Invalid arguments |

| Test ID | 6 |
| --- | --- |
| Test Case | Set plane to route |
| Description | Verify "Set plane to route" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. Planner selects "view current routes" option.<br> Expected: Planner receives current routes.<br> 2. Planner selects "edit route".<br> 3. Planner selects "set plane to route"<br> Expected: Planner receives planes view.<br> 4. Planner sets plane to new alredy created route.<br> Expected: Planner receives status message.<br> |
| Exceptions |  Invalid arguments |

## SalesOfficer Tests
| Test ID | 7 |
| --- | --- |
| Test Case | Edit ticket |
| Description | Verify "Edit ticket" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets"<br> Expected: SalesOfficer receives all tickets.<br> 2. SalesOfficer selects "edit ticket".<br> Expected: SalesOfficer receives details about selected ticket.<br> 3. SalesOfficer edit ticket.<br> Expected: Status message (successfull or not).<br> |
| Exceptions |  Invalid arguments |

| Test ID | 8 |
| --- | --- |
| Test Case | Add discount |
| Description | Verify "Add discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets"<br> Expected: SalesOfficer receives all tickets.<br> 2. SalesOfficer selects "add discount".<br> Expected: SalesOfficer receives details about selected ticket.<br> 3. SalesOfficer selects "add discount" option for selected ticket.<br> 4. SalesOfficer inputs discount arguments.<br> Expected: Status message (successfull or not).<br> |
| Exceptions |  Invalid arguments(discount can not be above specified % or number |

| Test ID | 9 |
| --- | --- |
| Test Case | Edit discount |
| Description | Verify "Edit discount" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets"<br> Expected: SalesOfficer receives all tickets.<br> 2. SalesOfficer selects "add discount".<br> Expected: SalesOfficer receives details about selected ticket.<br> 3. SalesOfficer selects "edit discount" option for selected ticket.<br> 4. SalesOfficer inputs discount arguments.<br> Expected: Status message (successfull or not).<br> |
| Exceptions |  Invalid arguments(discount can not be above specified % or number |


| Test ID | 10 |
| --- | --- |
| Test Case | Put ticket on sale |
| Description | Verify "Put ticket on sale" functionality |
| Pre-steps | 1. Login |
| Test steps | 1. SalesOfficer selects "view all tickets"<br> Expected: SalesOfficer receives all tickets.<br> 1. SalesOfficer selects "put a ticket on sale".<br> 0. SalesOfficer inputs arguments about "ticketOnSale".<br> Expected: SalesOfficer receives Status message (successfull or not).<br> |
| Exceptions |  Invalid arguments |
