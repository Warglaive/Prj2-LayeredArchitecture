drop table if exists salesOfficer cascade;

drop table if exists Customer cascade;

drop table if exists bookingrequest cascade;

drop table if exists booking cascade;

drop table if exists ticket cascade;

drop table if exists systemUser cascade;

drop table if exists gate cascade;

drop table if exists passenger cascade;

drop table if exists flight cascade;

drop table if exists route cascade;

drop table if exists airport cascade;

drop table if exists plane cascade;


create table plane (planeId SERIAL primary key,
registration VARCHAR(255) not null,
brand VARCHAR(255) not null,
type VARCHAR(255) not null,
seats_on_board INTEGER,
extra_legroom_seats INTEGER,
first_class_seats INTEGER );

create table airport (airportId SERIAL primary key,
name VARCHAR(255) not null,
country VARCHAR(255) not null,
city VARCHAR(255) not null );

create table gate (gateId SERIAL primary key,
airportId INTEGER references airport(airportId ),
gateNumber varchar(255) );

create table systemUser ( systemuserid SERIAL primary key,
firstName VARCHAR(255) not null,
lastName VARCHAR(255) not null,
email VARCHAR(255) not null unique,
password VARCHAR(255) not null,
address VARCHAR(255) null,
role VARCHAR(255) not null );

create table bookingrequest ( requestId SERIAL primary key,
customerId INTEGER references systemUser(systemuserid) not null,
salesOfficerId INTEGER references systemUser(systemuserid),
requestFrom VARCHAR(255) not null,
requestTo VARCHAR(255) not null,
departure DATE not null,
return DATE not null,
amountOfPassengers INTEGER not null,
status VARCHAR(255) not null );

create table booking (bookingId SERIAL primary key,
customerId INTEGER references systemUser(systemuserid),
salesOfficerId INTEGER references systemUser(systemuserid),
bookingDate DATE not null );

create table passenger (passengerId SERIAL primary key,
name VARCHAR(255) not null,
travelDoc VARCHAR(255) not null,
dob DATE not null,
blackListed BOOLEAN not null );

create table route (routeId SERIAL primary key,
start_airport INTEGER references airport(airportId),
end_airport INTEGER references airport(airportId),
plannerId INTEGER references systemUser(systemuserid) );

create table flight ( flightId SERIAL primary key,
flightDate DATE not null,
routeId INTEGER references route(routeId),
planeId INTEGER references plane(planeId) );

create table ticket ( ticketId SERIAL primary key,
price INTEGER,
passengerId INTEGER references passenger(passengerId),
bookingId INTEGER references booking(bookingId),
flightId INTEGER references flight(flightId),
status VARCHAR(255) not null );
