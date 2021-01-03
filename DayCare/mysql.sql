create database daycareDB

use daycareDB

create table daycaredb.student(rollno INT NOT NULL AUTO_INCREMENT,studentname varchar(60),PRIMARY KEY(rollno));

delete from  daycaredb.student;

drop table daycaredb.student;

insert into daycaredb.student values(2,'Bird');



select * from daycaredb.student;