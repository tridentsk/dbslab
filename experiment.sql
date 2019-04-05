drop table Voyage;
drop table Port;
drop table Crew;
drop table Ship;
drop table Class;
drop table Post;
drop table Cargo;
drop table Faction;
drop table auth_user;

create table auth_user(username varchar(10) primary key,
                        passwd varchar(20));

create table Faction(faction_name varchar (20) primary key, 
                    Leader varchar(15), 
                    HQ varchar(10));

create table Post(post_name varchar(10) primary key, 
                  salary number, 
                  yrs_of_exp_req number);

create table Class(class_name varchar(10) primary key, 
                    class_size varchar(1) check(class_size in('C', 'B', 'A', 'S')));

create table Ship(ship_name varchar(10) primary key, 
                    yrofmanuf number, 
                    faction_name varchar(20) references Faction(faction_name) on delete cascade,
                    class_name varchar(20) references Class(class_name) on delete cascade);

create table Crew(ID number primary key,
                    crew_name varchar (10), 
                    age number, 
                    yrs_of_exp number,
                    ship_name varchar(20) references Ship(ship_name) on delete cascade, 
                    faction_name varchar(20) references Faction(faction_name) on delete cascade, 
                    post_name varchar(20) references Post(post_name) on delete cascade,
                    sex varchar(1) check(sex in ('M', 'F')));

create table Port(Port_name varchar(10) primary key, 
                    port_size varchar(1) check(port_size in('C', 'B','A', 'S')),
                    faction_name varchar(20) references Faction(faction_name) on delete cascade);

create table Cargo(Cargo_type varchar(10) primary key, 
                    weight number);

create table Voyage(Source_name varchar(20) references Port(port_name),
                     Dest_name varchar(20) references Port(port_name),
                     dateofj date, 
                     ship_name varchar(20) references Ship(ship_name),
                     cargo_type varchar(20) references Cargo(cargo_type), primary key(Source_name, Dest_name, dateofj, ship_name));
