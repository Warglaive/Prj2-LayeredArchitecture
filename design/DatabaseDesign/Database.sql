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


create table plane ( id SERIAL primary key,
registration VARCHAR(255) not null,
brand VARCHAR(255) not null,
type VARCHAR(255) not null,
seats_on_board INTEGER,
extra_legroom_seats INTEGER,
first_class_seats INTEGER );

create table airport ( id SERIAL primary key,
name VARCHAR(255) not null,
country VARCHAR(255) not null,
city VARCHAR(255) not null );

create table gate (id SERIAL primary key,
airportId INTEGER references airport(id),
gateNumber varchar(255) );

create table systemUser ( id SERIAL primary key,
firstName VARCHAR(255) not null,
lastName VARCHAR(255) not null,
email VARCHAR(255) not null unique,
password VARCHAR(255) not null,
address VARCHAR(255) null,
role VARCHAR(255) not null );

create table bookingrequest ( id SERIAL primary key,
customerId INTEGER references systemUser(id),
salesOfficerId INTEGER references systemUser(id),
requestFrom VARCHAR(255) not null,
requestTo VARCHAR(255) not null,
departure DATE not null,
return DATE not null,
amountOfPassengers INTEGER not null,
status VARCHAR(255) not null );

create table booking ( id SERIAL primary key,
customerId INTEGER references systemUser(id),
salesOfficerId INTEGER references systemUser(id),
bookingDate DATE not null );

create table passenger ( id SERIAL primary key,
name VARCHAR(255) not null,
travelDoc VARCHAR(255) not null,
dob DATE not null,
blackListed BOOLEAN not null );

create table route ( id SERIAL primary key,
start_airport INTEGER references airport(id),
end_airport INTEGER references airport(id),
plannerId INTEGER references systemUser(id) );

create table flight ( id SERIAL primary key,
flightDate DATE not null,
routeId INTEGER references route(id),
planeId INTEGER references plane(id) );

create table ticket ( id SERIAL primary key,
price INTEGER,
passengerId INTEGER references passenger(id),
bookingId INTEGER references booking(id),
flightId INTEGER references flight(id),
status VARCHAR(255) not null );
