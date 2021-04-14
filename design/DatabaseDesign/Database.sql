drop table if exists customers cascade;
drop table if exists salesOfficers cascade;
drop table if exists bookings cascade;
drop table if exists tickets cascade;
drop table if exists passengers cascade;
drop table if exists flights cascade;
drop table if exists routes cascade;
drop table if exists airports cascade;
drop table if exists planes cascade;

CREATE TABLE planes (
	plane_id SERIAL PRIMARY KEY,
  registration VARCHAR(255) NOT NULL,
	brand VARCHAR(255) NOT NULL,
	type VARCHAR(255) NOT NULL,
  seats_on_board INTEGER,
  extra_legroom_seats INTEGER,
  first_class_seats INTEGER
);

CREATE TABLE airports (
	airport_id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
	country VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL
);

CREATE TABLE customers (
	customer_id SERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
  phone INTEGER NOT NULL
);

CREATE TABLE salesOfficers (
	salesOfficer_id SERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  auth_level INTEGER
);

CREATE TABLE bookings (
  booking_id SERIAL PRIMARY KEY,
  customer_id INTEGER REFERENCES customers(customer_id),
  salesOfficer_id INTEGER REFERENCES salesOfficers(salesOfficer_id),
  booking_date DATE NOT NULL
);

CREATE TABLE passengers (
	passenger_id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	travelDoc VARCHAR(255) NOT NULL,
  dob DATE NOT NULL
);

CREATE TABLE routes (
	route_id SERIAL PRIMARY KEY,
  start_airport INTEGER REFERENCES airports(airport_id),
  end_airport INTEGER REFERENCES airports(airport_id)
);

CREATE TABLE flights (
	flight_id SERIAL PRIMARY KEY,
	flight_date DATE NOT NULL,
	route_id INTEGER REFERENCES routes(route_id),
	plane_id INTEGER REFERENCES planes(plane_id)
);

CREATE TABLE tickets (
	ticket_id SERIAL PRIMARY KEY,
  price INTEGER,
  passenger_id INTEGER REFERENCES passengers(passenger_id),
  booking_id INTEGER REFERENCES bookings(booking_id),
  flight_id INTEGER REFERENCES flights(flight_id)
);
