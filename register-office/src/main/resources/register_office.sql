drop table if exists ro_marriage_certificate;
drop table if exists ro_birth_certificate;
drop table if exists ro_passport;
drop table if exists ro_person;

create table ro_person
(
	person_id serial,
	sex smallint not null,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	patronymic varchar(100),
	date_of_birth date not null,
	primary key (person_id)
);

create table ro_passport
(
	passport_id SERIAL,
	person_id integer not null,
	seria varchar(10) not null,
	number varchar(10) not null,
	issue_date date not null,
	issue_department varchar(200) not null,
	Primary key(passport_id),
	foreign key(person_id) references ro_person(person_id) on delete restrict

);

create table ro_birth_certificate
(
	birth_certificate_id serial,
	number_certificate varchar(20) not null,
	issue_date date not null,
	person_id integer not null,
	father_id integer,
	mother_id integer,
	Primary key(birth_certificate_id),
	foreign key(person_id) references ro_person(person_id) on delete restrict,
	foreign key(father_id) references ro_person(person_id) on delete restrict,
	foreign key(mother_id) references ro_person(person_id) on delete restrict
);

create table ro_marriage_certificate
(
	marriage_certificate_id serial,
	number_certificate varchar(20) not null,
	issue_date date not null,
	husband_id int not null,
	wife_id int not null,
	active boolean DEFAULT false,
	end_date date,
	primary key(marriage_certificate_id),
	foreign key(husband_id) references ro_person(person_id) on delete restrict,
	foreign key(wife_id) references ro_person(person_id) on delete restrict
	





);


insert into ro_person(sex, first_name, last_name, patronymic, date_of_birth)
values(1, 'Виктория', 'Кузнецова', 'Николаевна', '1996-03-11'),
	  (2, 'Александр', 'Кротов', 'Витальевич', '2001-06-08'),
	  (1, 'Василиса', 'Кротова', 'Николаевна', '2000-01-03'),
	  (2, 'Николай', 'Кротов', 'Александрович', '2020-09-01');
	  
	  
insert into ro_passport(person_id, seria, number, issue_date, issue_department)
values (2, '4115', '680124', '2021-07-06', 'МВД РФ г. Волхов'),
		(2, '4121', '783124', '2021-09-07', 'МВД РФ г. Волхов'),
	   (3, '4211', '682222', '2017-09-22', 'МВД РФ г. Санкт-Петеребург');
	   
insert into ro_marriage_certificate(number_certificate, issue_date, husband_id, wife_id, active)
values ('322332', '2019-11-12', 2, 3, true);

insert into  ro_birth_certificate (number_certificate, issue_date, person_id, father_id, mother_id)
values ('111111', '2020-09-01', 4, 2, 3);