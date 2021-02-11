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

## Administrator
| Name | Manage airplanes|
| --- | --- |
| Actor | Administrator |
| Description | Administrator manages plane fleet|
| Precondition |  Administrator must be logged in|
| Scenario | 1. Administrator selects planefleet option <br> 2. System shows all planes. <br> 3. Administrator selects edit on a plane <br> 4. System displays options for editing selected plane. <br> 5. Administrator edits plane and saves <br> 6. System accepts plane edit and returns to mainscreen. |
| Result |Planner created a route |
| Exceptions | Plane cannot be removed from service if it is planned for an upcoming route  |
| Extensions | N/A  |
