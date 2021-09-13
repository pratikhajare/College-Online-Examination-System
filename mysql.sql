use onlineexam;

 create table Student(stud_id varchar(6) primary key,fname varchar(10),mame varchar(10),lname varchar(10),
 dept_id int, year int, division varchar(4),rollno int,email varchar(15), password varchar(13),conPassword varchar(13),
 FOREIGN KEY (dept_id) REFERENCES Department(dept_id));
 
 create table department(dept_id int primary key, name varchar(10), hod_name varchar(20));