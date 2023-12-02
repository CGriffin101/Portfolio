-- This database is for a store that sells custom built computers. It has tables including customers, 
-- orders, builds, and parts.

DROP SCHEMA IF EXISTS Section4_Team05;
CREATE SCHEMA Section4_Team05;
USE Section4_Team05;

-- create customer table

CREATE TABLE customer(
customer_ID int NOT NULL,
customer_LastName char(40) not null,
customer_FirstName char(40) not null,
customer_Email char(60) not null,
customer_PhoneNumber char(12),
PRIMARY KEY (customer_ID) 
);
-- create order table (named "order_table" because "order" is keyword)

create table order_table(
order_Number int not null,
order_Date date not null,
order_Total decimal(7,2) not null,
order_Status char(40),
customer_ID int,
PRIMARY KEY(order_Number),
FOREIGN KEY(customer_ID) references customer(customer_ID)
);

-- create build table 

create table build(
build_Number int not null,
build_Name char(40) not null,
build_Cost decimal(7,2) not null,
order_Number int,
primary key(build_Number),
foreign key(order_Number) references order_table(order_Number)
);

-- create part table

create table part(
part_ID int not null,
part_Brand char(40) not null,
part_Model char(60) not null,
part_Cost decimal(6,2) not null,
part_Type char(40) not null,
primary key(part_ID)
);

-- create part_has_build table

create table part_has_build(
phb_quantity int,
part_ID int,
build_Number int,
foreign key(part_ID) references part(part_ID),
foreign key(build_Number) references build(build_Number),
primary key(part_ID,build_Number)
);

-- insert rows

-- insert into customer table

insert into customer(customer_ID, customer_LastName, customer_FirstName, customer_Email, customer_PhoneNumber)
values 
	(1, "Griffin","Connor",'cgriffin10@ggc.edu',"678-920-9090"),
	(2, "Chen", "Jeff", "jchen13@ggc.edu", "678-943-1388"),
    (3, "Smith","John", "jsmith@gmail.com","770-338-2232"),
    (4, "Chen","Cherry", "cchen@ggc.edu","338-221-2222"),
    (5, "Griffin","Chris","clgriffin@comcast.net","770-338-1284"),
    (6, "Liu","Cameron", "getSWoll1717@gmail.com","111-222-2233"),
    (7, "Reid","Termaine", "treid22@ggc.edu", "770-882-9647"),
    (8, "Supic","Katherine","K_IS_HERE_19@gmail.com","910-992-5473"),
    (9,"Smith","James","j.smith123@comcast.net","770-213-8484"),
    (10,"James","Lebron","kingjames@nba.org","678-929-1042"),
    (11,"Fielder","Nathan","nathan4you@comcasty.net","738-110-3321"),
    (12,"Pattinson","Robert","rpattinson33@ggc.edu","678-211-4322"),
    (13,"Lowry","Shane","slowry@pga.org","404-221-5444"),
    (14,"Biden","Joe","potus@usa.gov","211-222-3211"),
    (15,"Biden","Jill","flotus@usa.gov","211-222-3212")
;

-- insert into order_table

insert into order_table(order_Number, order_Date, order_Total, order_Status, customer_ID)
values
	(1,'2020-10-01',12345.67,'Shipped',1),
    (2,'2020-10-05',444.32,'Shipped',1),
    (3,'2020-10-28',1200.99,'Shipped',2),
    (4,'2021-01-07',7544.22,'Shipped',2),
    (5,'2021-03-06',929.19,'Shipped',5),
    (6,'2021-03-30',12032.99,'Shipped',4),
    (7,'2021-04-01',1717.17,'Shipped',2),
    (8,'2021-07-25',301.84,'Shipped',1),
    (9,'2021-09-21',99999.99,'Shipped',6),
    (10,'2021-10-14',104.77,'Shipped',12),
    (11,'2021-11-01',2333.33,'Shipped',13),
    (12,'2023-09-13',1094.19,'Awaiting Carrier Pickup',11),
    (13,'2023-09-25',923.23,'Build in Progress',1),
    (14,'2023-10-08',23456.89,'Payment Recieved',3),
    (15,'2023-10-15',1010.10,'Awaiting Payment',13)
;

-- insert into build table

insert into build(build_Number, build_Name, build_cost, order_Number)
values
	(1,"The Box", 10000.67, 1),
    (2,"The Cube", 2345.00, 1),
    (3,"Calulator", 444.32, 2),
    (4,"Random name", 1200.99, 3),
    (5,"The Dolphin",929.19,5),
    (6,"Spoons",932.00,6),
    (7,"Rubber Stamp",800.99,6),
    (8,"Pop Can",1717.17,7),
    (9,"Toy Top",301.84,8),
    (10,"Cowboy Hat",104.77,10),
    (11,"Paintbrush",999.99,9),
    (12,"The Comb",9000.00,9),
    (13,"Packet of Seeds",90000.00,9),
    (14,"Hand Mirror",1094.19,12),
    (15,"Book of Matches",1010.10,15)
;
-- insert into part table

insert into part(part_ID, part_Brand, part_Model, part_Cost, part_Type)
values
	(1,"Intel","i7",289.99,"CPU"),
    (2,"NVidea","RTX 3060",299.99,"GPU"),
    (3,"Asus","PRIME Z790-A WIFI",250.49,"Motherboard"),
    (4,"Asus","ProArt Z790-CREATOR WIFI",449.99,"Motherboard"),
    (5,"NVidea","RTX A6000",3900.00,"GPU"),
    (6,"Intel","i5-12400",171.99,"CPU"),
    (7,"MSi","MEG Ai1300P PCIE 5.0",329.99,"Power Supply"),
    (8,"IBM","90Y8926",66.54,"Internal Hard Drive"),
    (9,"CORSAIR","VENGREANCE RGB DDR5 32GB",119.99,"RAM"),
    (10,"SAMSUNG","980 PRO 2TB",129.99,"M.2 SSD"),
    (11,"Asus","ROG STRIX B760-A GAMING WIFI D4",350.00,"Motherboard"),
    (12,"AMD","Ryzen 7 5800X 8-core",208.74,"CPU"),
    (13,"CORSAIR","VENGREANCE LPX DDR4 32GB",64.99,"RAM"),
    (14,"CORSAIR","4000D Airflow Tempered Glass Mid-Tower ATX",94.99,"Case"),
    (15,"SAMSUNG","970 EVO PLUS 2TB",129.99,"M.2 SSD")
;
-- insert into part_has_build table
insert into part_has_build(phb_quantity, part_ID, build_Number)
values
	(1,1,1),
    (1,2,1),
    (1,1,2),
    (1,1,3),
    (1,2,2),
    (1,2,3),
    (1,14,1),
    (2,15,7),
    (2,15,6),
    (2,5,6),
    (1,12,10),
    (1,11,2),
    (1,14,3),
    (1,3,1),
    (1,14,4)
;
-- check work

select * from customer;
select * from order_table;
select * from build;
select * from part;
select * from part_has_build;


