-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

-- DROP SEQUENCE public.airport_airportid_seq;

CREATE SEQUENCE public.airport_airportid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.booking_bookingid_seq;

CREATE SEQUENCE public.booking_bookingid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.bookingrequest_requestid_seq;

CREATE SEQUENCE public.bookingrequest_requestid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.flight_flightid_seq;

CREATE SEQUENCE public.flight_flightid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.gate_gateid_seq;

CREATE SEQUENCE public.gate_gateid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.passenger_passengerid_seq;

CREATE SEQUENCE public.passenger_passengerid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.plane_planeid_seq;

CREATE SEQUENCE public.plane_planeid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.route_routeid_seq;

CREATE SEQUENCE public.route_routeid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.systemuser_systemuserid_seq;

CREATE SEQUENCE public.systemuser_systemuserid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.ticket_ticketid_seq;

CREATE SEQUENCE public.ticket_ticketid_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public.airport definition

-- Drop table

-- DROP TABLE public.airport;

CREATE TABLE public.airport (
	airportid serial NOT NULL,
	"name" varchar(255) NOT NULL,
	country varchar(255) NOT NULL,
	city varchar(255) NOT NULL,
	CONSTRAINT airport_pkey PRIMARY KEY (airportid)
);


-- public.passenger definition

-- Drop table

-- DROP TABLE public.passenger;

CREATE TABLE public.passenger (
	passengerid serial NOT NULL,
	"name" varchar(255) NOT NULL,
	traveldoc varchar(255) NOT NULL,
	dob date NOT NULL,
	blacklisted bool NOT NULL,
	CONSTRAINT passenger_pkey PRIMARY KEY (passengerid)
);


-- public.plane definition

-- Drop table

-- DROP TABLE public.plane;

CREATE TABLE public.plane (
	planeid serial NOT NULL,
	registration varchar(255) NOT NULL,
	brand varchar(255) NOT NULL,
	"type" varchar(255) NOT NULL,
	seats_on_board int4 NULL,
	extra_legroom_seats int4 NULL,
	first_class_seats int4 NULL,
	CONSTRAINT plane_pkey PRIMARY KEY (planeid)
);


-- public.systemuser definition

-- Drop table

-- DROP TABLE public.systemuser;

CREATE TABLE public.systemuser (
	systemuserid serial NOT NULL,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	address varchar(255) NULL,
	"role" varchar(255) NOT NULL,
	CONSTRAINT systemuser_email_key UNIQUE (email),
	CONSTRAINT systemuser_pkey PRIMARY KEY (systemuserid)
);


-- public.booking definition

-- Drop table

-- DROP TABLE public.booking;

CREATE TABLE public.booking (
	bookingid serial NOT NULL,
	customerid int4 NULL,
	salesofficerid int4 NULL,
	bookingdate date NOT NULL,
	CONSTRAINT booking_pkey PRIMARY KEY (bookingid),
	CONSTRAINT booking_customerid_fkey FOREIGN KEY (customerid) REFERENCES public.systemuser(systemuserid),
	CONSTRAINT booking_salesofficerid_fkey FOREIGN KEY (salesofficerid) REFERENCES public.systemuser(systemuserid)
);


-- public.bookingrequest definition

-- Drop table

-- DROP TABLE public.bookingrequest;

CREATE TABLE public.bookingrequest (
	bookingrequestid serial NOT NULL,
	customerid int4 NOT NULL,
	salesofficerid int4 NULL,
	departuredestination varchar(255) NOT NULL,
	arrivaldestination varchar(255) NOT NULL,
	departuredate date NOT NULL,
	returndate date NOT NULL,
	passengersamount int4 NOT NULL,
	status varchar(255) NOT NULL DEFAULT false,
	CONSTRAINT bookingrequest_pkey PRIMARY KEY (bookingrequestid),
	CONSTRAINT bookingrequest_customerid_fkey FOREIGN KEY (customerid) REFERENCES public.systemuser(systemuserid),
	CONSTRAINT bookingrequest_salesofficerid_fkey FOREIGN KEY (salesofficerid) REFERENCES public.systemuser(systemuserid)
);


-- public.gate definition

-- Drop table

-- DROP TABLE public.gate;

CREATE TABLE public.gate (
	gateid serial NOT NULL,
	airportid int4 NULL,
	gatenumber varchar(255) NULL,
	CONSTRAINT gate_pkey PRIMARY KEY (gateid),
	CONSTRAINT gate_airportid_fkey FOREIGN KEY (airportid) REFERENCES public.airport(airportid)
);


-- public.route definition

-- Drop table

-- DROP TABLE public.route;

CREATE TABLE public.route (
	routeid serial NOT NULL,
	start_airport int4 NULL,
	end_airport int4 NULL,
	plannerid int4 NULL,
	CONSTRAINT route_pkey PRIMARY KEY (routeid),
	CONSTRAINT route_end_airport_fkey FOREIGN KEY (end_airport) REFERENCES public.airport(airportid),
	CONSTRAINT route_plannerid_fkey FOREIGN KEY (plannerid) REFERENCES public.systemuser(systemuserid),
	CONSTRAINT route_start_airport_fkey FOREIGN KEY (start_airport) REFERENCES public.airport(airportid)
);


-- public.flight definition

-- Drop table

-- DROP TABLE public.flight;

CREATE TABLE public.flight (
	flightid serial NOT NULL,
	flightdate date NOT NULL,
	routeid int4 NULL,
	planeid int4 NULL,
	CONSTRAINT flight_pkey PRIMARY KEY (flightid),
	CONSTRAINT flight_planeid_fkey FOREIGN KEY (planeid) REFERENCES public.plane(planeid),
	CONSTRAINT flight_routeid_fkey FOREIGN KEY (routeid) REFERENCES public.route(routeid)
);


-- public.ticket definition

-- Drop table

-- DROP TABLE public.ticket;

CREATE TABLE public.ticket (
	ticketid serial NOT NULL,
	price int4 NULL,
	passengerid int4 NULL,
	bookingid int4 NULL,
	flightid int4 NULL,
	status varchar(255) NOT NULL,
	CONSTRAINT ticket_pkey PRIMARY KEY (ticketid),
	CONSTRAINT ticket_bookingid_fkey FOREIGN KEY (bookingid) REFERENCES public.booking(bookingid),
	CONSTRAINT ticket_flightid_fkey FOREIGN KEY (flightid) REFERENCES public.flight(flightid),
	CONSTRAINT ticket_passengerid_fkey FOREIGN KEY (passengerid) REFERENCES public.passenger(passengerid)
);
