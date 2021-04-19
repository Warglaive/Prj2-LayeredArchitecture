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

create table customer ( id SERIAL primary key,
firstName VARCHAR(255) not null,
lastName VARCHAR(255) not null,
email VARCHAR(255) not null,
password VARCHAR(255) not null,
address VARCHAR(255) null,
role VARCHAR(255) not null );

create table salesOfficer ( salesOfficer_id SERIAL primary key,
email VARCHAR(255) not null,
password VARCHAR(255) not null,
auth_level INTEGER );

create table booking ( booking_id SERIAL primary key,
customer_id INTEGER references customer(id),
salesOfficer_id INTEGER references salesOfficer(salesOfficer_id),
booking_date DATE not null );

create table passenger ( passenger_id SERIAL primary key,
name VARCHAR(255) not null,
travelDoc VARCHAR(255) not null,
dob DATE not null );

create table route ( route_id SERIAL primary key,
start_airport INTEGER references airport(airport_id),
end_airport INTEGER references airport(airport_id) );

create table flight ( flight_id SERIAL primary key,
flight_date DATE not null,
route_id INTEGER references route(route_id),
plane_id INTEGER references plane(plane_id) );

create table ticket ( ticket_id SERIAL primary key,
price INTEGER,
passenger_id INTEGER references passenger(passenger_id),
booking_id INTEGER references booking(booking_id),
flight_id INTEGER references flight(flight_id) );
