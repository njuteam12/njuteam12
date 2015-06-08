create table buyer(
NAME VARCHAR(20) NOT NULL,
PSW VARCHAR(20) NOT NULL,
PHONE  VARCHAR(20) ,
ADDRES VARCHAR(30) ,
ONL INT,
PRIMARY KEY(NAME),
);



create table seller(
NAME VARCHAR(20) NOT NULL,
PSW VARCHAR(20) NOT NULL,
PHONE  VARCHAR(20) ,
ADDRES VARCHAR(30) ,
ID VARCHAR(2) NOT NULL,
ONL INT,
star float,
num int not null,
PRIMARY KEY(ID),
);
create table menu(
ID VARCHAR(4) NOT NULL,
seller_name VARCHAR(20) not null,
PRICE float not null,
NAME VARCHAR(20) not null,
comment VARCHAR(100),
sell INT not null,
PRIMARY KEY(ID),
);
create table orders(
ID INT NOT NULL,
buyer_name VARCHAR(20) NOT NULL,
seller_name VARCHAR(20) NOT NULL,
menu_id VARCHAR(4) NOT NULL,
sta INT NOT NULL,
beg VARCHAR(20) ,
fin VARCHAR(20) ,  
PRIMARY KEY(ID),
);
select *
from menu
select *
from orders;
select *
from buyer
select *
from seller

drop table buyer
drop table seller
drop table menu
drop table orders