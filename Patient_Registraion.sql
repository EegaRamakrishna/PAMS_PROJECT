create database PAMS_OWN;
use PAMS_OWN;
drop table if exists Patient_Registration;
create table Patient_Registration(
Patient_ID int auto_increment not null primary key, 
Name varchar(30), 
email varchar(30), 
phone  varchar(30),
Age tinyint, 
password varchar(30)
);

insert into Patient_Registration(Name,email,phone,Age,password)
values('RAm','efsfs@sd','52236',36,'54555');

select * from Patient_Registration;


-- create table Patient_Registration(
-- Patient_ID int auto_increment not null primary key, 
-- Name varchar(30), 
-- email varchar(30), 
-- phone  varchar(30),
-- address  varchar(30), 	
-- date_of_birth date, 
-- Age date,
-- physical_disability  varchar(30), 
-- identity_proof  varchar(30),
-- password varchar(30)
-- );


