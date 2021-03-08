## Customer
| Name | Order a Ticket |
| --- | --- |
| Actor | Customer |
| Description | Customer Orders a Ticket|
| Precondition |  Customer must be logged in|
| Scenario | 1. Customer selects time/date and destination/return for trip <br> 2. System shows tickets available and pricing. <br> 3. Customer selects tickets and seats <br> 4. System starts payment and validation steps. <br> 5. Customer pays and fills documents. <br> 6. After acceptance system sends confirmation to customer with tickets/boardingpasses |
| Result |Customer booked a ticket |
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

| Name | Customer changes Ticket |
| --- | --- |
| Actor | Customer |
| Description | Customer changes Ticket|
| Precondition |  Customer must be logged in|
| Scenario | 1. Customer selects bookings in profile <br> 2. System shows bookings <br> 3. Customer selects specific booking <br> 4. System shows selected seats and tickets. <br> 5. Customer choses to change ticket(s). <br> 6. System shows gives option to change tickets. <br> 7. customer changes tickets dates/seats/etc <br> 8. System calculates fees/discount for new ticket(s) <br> 9. Customer pays and accepts. <br> 10. System swaps tickets and sends conformation |
| Result |Customer changed a ticket |
| Exceptions |TBD  |
| Extensions | N/A  |

| Name | Customer canceles Ticket |
| --- | --- |
| Actor | Customer |
| Description | Customer wants to cancel a Ticket|
| Precondition |  Customer must be logged in and must have bought a ticket|
| Scenario | 1.	Actor decides to cancel a booked ticket <br> 2.	Actor opens overview of orders <br> 3. System provides overview of all orders <br> 4. Actor chooses the order which he want to cancel <br> 5. System offers opportunity to cancel ticket 6. Actor chooses option <br> 7. System cancels ticket |
| Result |Customer canceles a ticket successfully |
| Exceptions | Actor is blocked <br> Ticket cannot be cancelled anymore |
| Extensions | N/A  |


## Planner
| Name | Create route |
| --- | --- |
| Actor | Planner |
| Description | Planner Creates Route|
| Precondition |  Planner must be logged in|
| Scenario | 1. Planner selects route option <br> 2. System shows current routes. <br> 3. Planner selects create new route <br> 4. System starts new route steps. <br> 5. Planner selects start and ending location. <br> 6. System accepts route and returns to mainscreen. |
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

## Salesman
| Name | Edit ticket |
| --- | --- |
| Actor | Salesman |
| Description | Salesman edits a ticket |
| Precondition | Salesman must be logged in |
| Scenario | 1. Salesman goes to the tickets section <br> 2. System shows all tickets available <br> 3. Salesman selects edit ticket <br> 4. System displays options for editing a ticket <br> 5. Salesman changed the ticket options <br> 6. System accepts the changes and returns to the tickets section |
| Result | The ticket is edited |
| Exceptions | The ticket can not be edited if you have invalid data |
| Extensions | N/A |

| Name | Add discount |
| --- | --- |
| Actor | Salesman |
| Description | Salesman adds a discount |
| Precondition | Salesman must be logged in |
| Scenario | 1. Salesman goes to the tickets section <br> 2. System shows all tickets available <br> 3. Salesman selects add discount <br> 4. System displays options for adding a discount <br> 5. Salesman puts in information for the discount <br> 6. System validates the discount and returns to the tickets section |
| Result | The discount is added |
| Exceptions | The discount can not be added with an invalid price or code |
| Extensions | N/A |

| Name | Edit discount |
| --- | --- |
| Actor | Salesman |
| Description | Salesman edits a discount |
| Precondition | Salesman must be logged in |
| Scenario | 1. Salesman goes to the tickets section <br> 2. System shows all tickets available <br> 3. Salesman selects edit discount <br> 4. System displays options for editing a discount <br> 5. Salesman changed the discount options <br> 6. System accepts the changes and returns to the tickets section |
| Result | The discount is edited |
| Exceptions | The discount can not be edited if you have invalid data |
| Extensions | N/A |

| Name | Put ticket on sale |
| --- | --- |
| Actor | Salesman |
| Description | Salesman wants to put a ticket on sale |
| Precondition | Salesman must be logged in |
| Scenario | 1.	Actor decides to put a ticket on sale <br> 2. System offers opportunity to put a ticket on sale <br> 3. Actor chooses the option <br> 4. System gives opportunity to enter information about the ticket <br> 5. Actor enters valid information about the ticket <br> 6. System adds the ticket in to system |
| Result | Ticket is put on sale successfully |
| Exceptions | Salesman is blocked <br> Information about ticket is incomplete |
| Extensions | N/A |

| Name | Log in |
| --- | --- |
| Actor | Salesman/Administrator/Customer |
| Description | Actor wants to log in |
| Precondition | Actor must have an account and valid sign in data |
| Scenario | 1.	Actor opens system <br> 2. Enters valid log in data <br> 3. System validates and processes log in |
| Result | Actor is loggend in successfully|
| Exceptions | Actor is blocked |
| Extensions | N/A |
