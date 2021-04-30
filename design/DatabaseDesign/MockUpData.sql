insert into plane 
values (1, 'PH-GHD', 'Airbus', 'Longdistance passenger plane', 296, 150, 20);
insert into plane 
values (2, 'DE-TDE', 'Boeing', 'Small passenger plane', 150, 50, 6);
insert into plane 
values (3, 'PH-EPG', 'Boeing', 'Small passenger plane', 138, 39, 5);
insert into plane 
values (4, 'DE-QFP', 'Airbus', 'Longdistance plane', 334, 175, 34);

insert into airport 
values (1, 'Schiphol', 'Netherlands', 'Amsterdam');
insert into airport 
values (2, 'Antwerpen Airport', 'Netherlands', 'Antwerpen');
insert into airport 
values (3, 'Dusseldorf International Airport', 'Germany', 'Dusseldorf');
insert into airport 
values ('4', 'Fraport', 'Germany', 'Frankfurt');

insert into gate 
values (1, 1, '1A');
insert into gate 
values (2, 1, '1B');
insert into gate 
values (3, 1, '2A');
insert into gate 
values (4, 2, '1A');
insert into gate 
values (5, 2, '1B');
insert into gate 
values (6, 2, '2A');
insert into gate 
values (7, 3, '1A');
insert into gate 
values (8, 3, '1B');
insert into gate 
values (9, 3, '2A');

insert into systemuser 
values (1, 'Peter', 'van Haag', 'peter@gmail.nl', 'Peter123!', 'Netherweg 1', 'customer');
insert into systemuser 
values (2, 'Marcus', 'Meijer', 'marcus@gmail.nl', 'Marcus123!', 'Marktweg 34', 'SalesOfficer');
insert into systemuser 
values (3, 'Patrick', 'Becker', 'patrickbecker@outlook.de', 'Patrick23;', 'Tegelseweg 96', 'SalesEmployee');
insert into systemuser 
values (4, 'Alexander', 'Cox', 'alexander@gmail.de', 'Alex,321', 'Pagstraat 85', 'Planner');

insert into bookingrequest 
values (1, 1, 2, 'Amsterdam', 'Dusseldorf', '07-21-2021', '07-21-2021', 4, 'available');
insert into bookingrequest 
values (2, 1, 2, 'Dusseldorf', 'Antwerpen', '04-08-2022', '04-08-2022', 2, 'available');

insert into booking 
values (1, 1, 2, '04-26-2021');
insert into booking 
values (2, 1, 2, '07-19-2021');

--- travelDoc missing between name & dob
insert into passenger 
values (1, 'Max', '09-01-1999', false);
insert into passenger 
values (1, 'Martin', '28-05-1970', false);
insert into passenger 
values (1, 'Gabriela', '11-12-2002', false);

insert into route 
values (1, 1, 2, 1);
insert into route 
values (2, 2, 3, 1);
insert into route 
values (3, 4, 1, 1);
insert into route 
values (4, 3, 1, 1);

insert into flight 
values (1, '06-30-2021', 1, 2);
insert into flight 
values (2, '06-25-2021', 2, 3);
insert into flight 
values (3, '06-15-2021', 3, 1);
insert into flight 
values (4, '06-02-2021', 4, 4);

--- working after passenger is corrected
insert into ticket 
values (1, 200, 1, 1, 1, 'economy');
insert into ticket 
values (2, 200, 2, 1, 1, 'economy');
insert into ticket 
values (3, 250, 3, 2, 2, 'first class');