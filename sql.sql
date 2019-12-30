SELECT * FROM bloodbank.user_role;

create database bloodbank;

use bloodbank;
select * from user;
select * from role;
select * from user_role;

insert into role values (1,"ADMIN");
insert into role values (2,"USER");

insert into state values(1,"Andhra Pradesh");
insert into state values(2,"Karnataka");
insert into state values(3,"Telangana");

insert into city values(1,"Viskapatanam",1);
insert into city values(2,"Guntur",1);
insert into city values(3,"Tirupati",1);
insert into city values(4,"Bangalore",2);
insert into city values(5,"Mysore",2);
insert into city values(6,"Hyderabad",3);

insert into area values(1,"Anakapalli",1);
insert into area values(2,"Narsipatnam",1);
insert into area values(3,"Atchuthapuram",1);
insert into area values(4,"Manyata Tech Park",4);
insert into area values(5,"Central Silk Board",4);
insert into area values(6,"Hebbal",5);
insert into area values(7,"HiTech City",6);
insert into area values(8,"Amaravati",2);
insert into area values(9,"Srikalahsti",3);

insert into blood_group values(1,"A+");
insert into blood_group values(2,"B+");
insert into blood_group values(3,"O+");
insert into blood_group values(4,"AB+");
insert into blood_group values(5,"A-");
insert into blood_group values(6,"B-");
insert into blood_group values(7,"O-");
insert into blood_group values(8,"AB-");

insert into hospital values(1,"Rainbow",1);
insert into hospital values(2,"Apollo",1);
insert into hospital values(3,"AD Prasad",2);
insert into hospital values(4,"Goverment Hospital",3);
insert into hospital values(5,"JMJ Hospital",4);
insert into hospital values(6,"Karanth Speciality",5);
insert into hospital values(7,"NRG Hospitals",6);
insert into hospital values(8,"Pace Hospitals",7);
insert into hospital values(9,"District General Hospital",8);
insert into hospital values(10,"Sravan",9);

select * from area;
select * from blood_group;
select * from city;
select * from hospital;
select * from state;

select * from donation_details;
select * from donor_slot_details;

select * from request_posting_details;
select * from slot_details;

select * from faqs;
SELECT * FROM bloodbank.feedback;

select * from slot_details where sd_us_id=8 and sd_donation_date>=DATE_SUB(CURRENT_DATE(),INTERVAL 89 DAY);

select * from donor_slot_details;

select * from donor_slot_details where ds_donation_date<=DATE_SUB(CURRENT_DATE(),INTERVAL 89 DAY) ;

desc user;

desc donation_details;

desc request_posting_details;

desc slot_details;

desc feedback;

desc faqs;

