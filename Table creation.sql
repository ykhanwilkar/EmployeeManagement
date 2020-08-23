CREATE TABLE `Employee` (
  `emp_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `fist_name` varchar(255),
  `last_name` varchar(255),
  `email` varchar(255),
  `salary` double,
  `password` varchar(255),
  `manager_id` int,
  `designation_id` int
);

CREATE TABLE `designation` (
  `designation_id` int PRIMARY KEY,
  `designation` varchar(255)
);

ALTER TABLE `Employee` ADD FOREIGN KEY (`manager_id`) REFERENCES `Employee` (`emp_id`);

ALTER TABLE `Employee` ADD FOREIGN KEY (`designation_id`) REFERENCES `designation` (`designation_id`);


insert into designation values (1,'CEO');
insert into designation values (2,'Vice President');
insert into designation values (3,'Director');
insert into designation values (4,'Program Manager');
insert into designation values (5,'Lead');
insert into designation values (6,'Engineer');
insert into designation values (7,'Trainee');
insert into designation values (8,'Intern');


insert into employee values(1,'John','Doe','johndoe@abc.com',100000.0,'password123',1,1);
insert into employee values(2,'John','Cena','johncena@abc.com',500000.0,'password234',1,2);
insert into employee values(3,'Johnny','Cage','johnnycage@abc.com',60000.0,'password345',1,2);
insert into employee values(4,'Janardan','Anthony','janardan@abc.com',20000.0,'password456',2,3);
insert into employee values(5,'Jacob','Dolittle','jacobdolittle@abc.com',20000.0,'password567',3,3);
insert into employee values(6,'Jabbar','Daslim','jabbardaslim@abc.com',10000.0,'password678',3,3);
insert into employee values(7,'Jacquline','Davis','jacqulinedavis@abc.com',10000.0,'password789',5,4);
insert into employee values(8,'Jasmin','Das','jasmindas@abc.com',5000.0,'password890',7,5);
insert into employee values(9,'Natalie','Portman','natalieportman@abc.com',4000.0,'password100',8,6);
insert into employee values(10,'Gal','Gadot','galgadot@abc.com',4000.0,'password222',8,7);