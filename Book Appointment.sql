
/*
		Author : Eega Ramakrishna
        Date 02/01/22

*/
CREATE DATABASE PAMS_PROJECT;

USE PAMS_PROJECT;

-- DDL ---------------------------------------
drop table if exists Book_Appointment;
CREATE TABLE Book_Appointment(
Patient_id int not null auto_increment primary KEY,
Patient_Name varchar(30),
Date_Of_Birth date,
Contact_No varchar(20),
Address varchar(50),
Appointment_Date date,
Preferred_TimeSlot time,
Ailment_Symptoms varchar(200),
Doctor_Name varchar(30),
Status varchar(200)
);
ALTER TABLE Book_Appointment
ADD AGE INT;




-- DQL----------------------------------------
select * from Book_Appointment;

-- DML----------------------------------------
insert into Book_Appointment(Patient_Name,Date_Of_Birth,Contact_No,Address,Appointment_Date,Preferred_TimeSlot,Ailment_Symptoms,Doctor_Name,Status)
values("RAM",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("sri",'2003-05-08','9526495150','Karimagar','2023-01-20',123000 ,'cold','DR.Prakesh','Booked1'),
("Shiva",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("Harish",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("Raoram",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("manoj",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("siri",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("Aman",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked'),
("shaik",'2000-08-08','9390495150','Karimagar','2023-01-20',1130 ,'fever','DR.Prakesh','Booked');



-- DCL-------------------------------------------------


SHOW DATABASES;

-- Check current user and database server version
SELECT USER();
SELECT version();

SELECT host, user, account_locked, password_expired
FROM mysql.user
ORDER BY 1,2;

SELECT host, user, db, command 
FROM information_schema.processlist;

-- Check previlages on the account
DESCRIBE mysql.user;

SELECT * FROM mysql.user;

DROP USER 'ram'@'localhost' ;
CREATE USER 'ram'@'localhost' IDENTIFIED BY 'ram';

use pams_project;

------ GIVE PERMISSIONS USING GRANT --------- 
GRANT select , delete , update on book_appointment TO 'ram'@'localhost'; 
GRANT ALL ON batch TO 'ram'@'localhost';

--------- REMOVE PERMISSIONS USING REVOKE -------
REVOKE select, delete , update ON book_appointment FROM 'ram'@'localhost';
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'ram'@'localhost';

SHOW GRANTS FOR 'ram'@'localhost';

-- To Reload newly assigned permissions run:
FLUSH PRIVILEGES;

-- Shows all PERMISSIONS to currenly logged in user
SHOW GRANTS;
