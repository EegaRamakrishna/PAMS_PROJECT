use pams_own;

drop table if exists Receptionist;
Create Table Receptionist(
Receptionist_id tinyint not null unique check(Receptionist_id <=2),
Receptionist_name varchar(30),
Receptionist_startime time(1),
Receptionist_endtime time(1)
);

insert into Receptionist(Receptionist_id,Receptionist_name,Receptionist_startime,Receptionist_endtime)
values(1,'Siri','08:00:00','15:59:59'),
		(2,'Priya','16:00:00','23:59:59');
        select * from Receptionist;
        
    select current_time();    
select Receptionist_name from Receptionist where current_time() between  Receptionist_startime and Receptionist_endtime;