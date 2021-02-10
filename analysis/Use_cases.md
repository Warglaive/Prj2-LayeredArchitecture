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
