--liquibase formatted sql

--changeset Ruslan:01
insert into people (id, full_name, year) values (1, 'Dale Fensome', 2011);
insert into people (id, full_name, year) values (2, 'Nanice Kelmere', 1995);
insert into people (id, full_name, year) values (3, 'Ailee Dreghorn', 1999);
insert into people (id, full_name, year) values (4, 'Dacie Petruskevich', 2003);
insert into people (id, full_name, year) values (5, 'Odetta Hiner', 2001);
insert into people (id, full_name, year) values (6, 'Edith Marzella', 1999);
insert into people (id, full_name, year) values (7, 'Morly Staveley', 1989);
insert into people (id, full_name, year) values (8, 'Fiorenze Faulks', 2001);
insert into people (id, full_name, year) values (9, 'Fulvia Rubertelli', 2009);
insert into people (id, full_name, year) values (10, 'Gallagher Blackaller', 2004);
insert into people (id, full_name, year) values (11, 'Kipp Cowely', 2005);
insert into people (id, full_name, year) values (12, 'Stavros Whimpenny', 1992);
insert into people (id, full_name, year) values (13, 'Terri Broadwell', 2002);
insert into people (id, full_name, year) values (14, 'Agosto Durbann', 2007);
insert into people (id, full_name, year) values (15, 'Gilligan Breakey', 1999);
insert into people (id, full_name, year) values (16, 'Payton Strevens', 1989);
insert into people (id, full_name, year) values (17, 'Giff Rudd', 2005);
insert into people (id, full_name, year) values (18, 'Augusto Mallalieu', 1991);
insert into people (id, full_name, year) values (19, 'Kristofor Payze', 1997);
insert into people (id, full_name, year) values (20, 'Shelley Ewert', 1999);
insert into people (id, full_name, year) values (21, 'Patrick Danslow', 2007);
insert into people (id, full_name, year) values (22, 'Priscilla Cottey', 1989);
insert into people (id, full_name, year) values (23, 'Rex McCafferty', 1984);
insert into people (id, full_name, year) values (24, 'Gates Jupp', 2012);
insert into people (id, full_name, year) values (25, 'Babara Toffel', 1999);
insert into people (id, full_name, year) values (26, 'Amalia Hutson', 2009);
insert into people (id, full_name, year) values (27, 'Jerome Phifer', 1994);
insert into people (id, full_name, year) values (28, 'Kerri Presser', 2008);
insert into people (id, full_name, year) values (29, 'Diandra Bumpass', 1984);
insert into people (id, full_name, year) values (30, 'Joby Bustin', 1994);

--rollback delete from people;
