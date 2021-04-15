drop table if exists customer cascade;

drop table if exists salesOfficer cascade;

drop table if exists booking cascade;

drop table if exists ticket cascade;

drop table if exists passenger cascade;

drop table if exists flight cascade;

drop table if exists route cascade;

drop table if exists airport cascade;

drop table if exists plane cascade;

create table plane ( plane_id SERIAL primary key,
registration VARCHAR(255) not null,
brand VARCHAR(255) not null,
type VARCHAR(255) not null,
seats_on_board INTEGER,
extra_legroom_seats INTEGER,
first_class_seats INTEGER );

create table airport ( airport_id SERIAL primary key,
name VARCHAR(255) not null,
country VARCHAR(255) not null,
city VARCHAR(255) not null );

create table customer ( customer_id SERIAL primary key,
firstName VARCHAR(255) not null,
lastName VARCHAR(255) not null,
email VARCHAR(255) not null,
password VARCHAR(255) not null,
address VARCHAR(255) null,
name VARCHAR(255) not null,
phone INTEGER not null );

create table salesOfficer ( salesOfficer_id SERIAL primary key,
email VARCHAR(255) not null,
password VARCHAR(255) not null,
auth_level INTEGER );

create table booking ( booking_id SERIAL primary key,
customer_id INTEGER references customers(customer_id),
salesOfficer_id INTEGER references salesOfficers(salesOfficer_id),
booking_date DATE not null );

create table passenger ( passenger_id SERIAL primary key,
name VARCHAR(255) not null,
travelDoc VARCHAR(255) not null,
dob DATE not null );

create table route ( route_id SERIAL primary key,
start_airport INTEGER references airports(airport_id),
end_airport INTEGER references airports(airport_id) );

create table flight ( flight_id SERIAL primary key,
flight_date DATE not null,
route_id INTEGER references routes(route_id),
plane_id INTEGER references planes(plane_id) );

create table ticket ( ticket_id SERIAL primary key,
price INTEGER,
passenger_id INTEGER references passengers(passenger_id),
booking_id INTEGER references bookings(booking_id),
flight_id INTEGER references flights(flight_id) );
