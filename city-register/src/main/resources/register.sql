DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_district;
DROP TABLE IF EXISTS cr_street;



create table cr_district (
    district_code integer not null,
    district_name varchar(300),
    PRIMARY KEY (district_code)
);

insert into cr_district(district_code, district_name) values (1, 'Выборгский');

CREATE TABLE cr_street
(
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);

insert into cr_street(street_code, street_name) values (1, 'Сампсоневский проспект');

create table cr_address
(
	address_id SERIAL,
	district_code integer not null,
	street_code integer not null,
	building varchar(10) not null,
    extension varchar(10),
    apartment varchar(10),
    PRIMARY KEY (address_id),
    FOREIGN KEY (district_code) REFERENCES cr_district(district_code) ON DELETE RESTRICT,
    FOREIGN KEY (street_code) REFERENCES cr_street(street_code) ON DELETE RESTRICT
);

insert into cr_address(district_code, street_code, building, extension, apartment)
 values (1, 1, '10', '2', '222');
 insert into cr_address(district_code, street_code, building, extension, apartment)
 values (1, 1, '34', '1', '111');


create table cr_person
(
	person_id serial,
 	sur_name varchar(100) not null,
    given_name varchar(100) not null,
    patronymic varchar(100) not null,
    date_of_birth date not null,
    passport_seria varchar(10),
    passport_number varchar(10),
    passport_date date,
    c_certificate_number varchar(10),
    c_certificate_date date,
	PRIMARY KEY (person_id)
);

insert into cr_person(sur_name, given_name, patronymic,  date_of_birth,  passport_seria, passport_number,
passport_date, c_certificate_number, c_certificate_date)
values ('Кротов', 'Александр', 'Витальевич', '2001-06-08', '4115', '680124', '2021-07-06', null, null);

insert into cr_person(sur_name, given_name, patronymic,  date_of_birth,  passport_seria, passport_number,
passport_date, c_certificate_number, c_certificate_date)
values ('Кротова', 'Василиса', 'Николевна', '2000-01-03', '4115', '680124', '2020-01-26', null, null);

insert into cr_person(sur_name, given_name, patronymic,  date_of_birth,  passport_seria, passport_number,
passport_date, c_certificate_number, c_certificate_date)
values ('Кротов', 'Николай', 'Александрович', '2020-01-05', null, null, null, 43435465, '2020-01-05');

insert into cr_person(sur_name, given_name, patronymic,  date_of_birth,  passport_seria, passport_number,
passport_date, c_certificate_number, c_certificate_date)
values ('Кротова', 'Мария', 'Александровна', '2019-03-05', null, null, null, 45412223, '2019-03-05');


create table cr_address_person
(
	person_address_id serial,
	address_id integer not null,
	person_id integer not null,
	start_date date not null,
	end_date date,
	temporal boolean DEFAULT false,
	PRIMARY KEY (person_address_id),
	FOREIGN KEY (address_id) REFERENCES cr_address(address_id) ON DELETE RESTRICT,
    FOREIGN KEY (person_id) REFERENCES cr_person(person_id) ON DELETE RESTRICT
);
insert into cr_address_person (address_id, person_id, start_date, end_date, temporal) 
values (1, 1, '2018-10-12', null, false);
insert into cr_address_person (address_id, person_id, start_date, end_date) 
values (1, 2, '2018-10-12', null);
insert into cr_address_person (address_id, person_id, start_date, end_date) 
values (1, 4, '2020-01-05', null);
insert into cr_address_person (address_id, person_id, start_date, end_date) 
values (1, 3, '2019-03-05', null);
