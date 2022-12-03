--liquibase formatted sql

--changeset Ruslan:01
insert into books (id, name, year, author, person_id, taken_at) values (1, 'Charm''s Incidents (Charms Zwischenfälle)', 2011, 'Tera Itzkovsky', 1, '2022-06-11 21:27:01');
insert into books (id, name, year, author, person_id, taken_at) values (2, 'Lacombe Lucien', 2008, 'Juliane Gunn', 2, '2022-03-13 19:37:58');
insert into books (id, name, year, author, person_id, taken_at) values (3, 'Wish Me Away', 2009, 'Addia Kristoffersson', 3, '2022-02-27 06:41:33');
insert into books (id, name, year, author, person_id, taken_at) values (4, 'Redemption: For Robbing the Dead', 2012, 'Mallory Hadwick', 4, '2022-03-03 20:13:35');
insert into books (id, name, year, author, person_id, taken_at) values (5, 'Inception', 2002, 'Yurik Wissby', 5, '2022-08-17 09:07:16');
insert into books (id, name, year, author, person_id, taken_at) values (6, 'Monterey Pop', 2005, 'Julieta Rosettini', 6, '2022-04-29 21:38:50');
insert into books (id, name, year, author, person_id, taken_at) values (7, 'Mystic Pizza', 2012, 'Rudolph Brogan', 7, '2022-05-26 16:01:12');
insert into books (id, name, year, author, person_id, taken_at) values (8, 'Dinner for One (Der 90. Geburtstag oder Dinner for One)', 1997, 'Neall Davidowich', 8, '2022-10-27 14:14:23');
insert into books (id, name, year, author, person_id, taken_at) values (9, 'Great Flamarion, The', 1992, 'Lilas McGeoch', 9, '2022-04-23 18:16:55');
insert into books (id, name, year, author, person_id, taken_at) values (10, 'I Spit on Your Grave', 1999, 'Meade Michie', 10, '2022-06-05 06:00:55');
insert into books (id, name, year, author, person_id, taken_at) values (11, 'Line of Sight', 1995, 'Jacquelyn Blaxland', 11, '2022-06-03 07:31:50');
insert into books (id, name, year, author, person_id, taken_at) values (12, 'Killer Joe', 2006, 'Silvan Wass', 12, '2022-06-07 22:36:43');
insert into books (id, name, year, author, person_id, taken_at) values (13, 'Big Steal, The', 1991, 'Kiley Redmain', 13, '2022-09-07 02:27:56');
insert into books (id, name, year, author, person_id, taken_at) values (14, 'Samson and Delilah', 2009, 'Rivy Sharrard', 14, '2022-05-14 13:40:02');
insert into books (id, name, year, author, person_id, taken_at) values (15, 'Christine', 2005, 'Coletta Gentery', 15, '2022-04-14 18:19:51');
insert into books (id, name, year, author, person_id, taken_at) values (16, 'Good Humor Man, The', 2013, 'Thor Le Teve', 16, '2022-11-15 17:08:39');
insert into books (id, name, year, author, person_id, taken_at) values (17, 'And So It Goes', 1990, 'Suki Teck', 17, '2022-08-10 00:28:39');
insert into books (id, name, year, author, person_id, taken_at) values (18, '14 Hours (Fourteen Hours)', 1989, 'Zach Emmer', 18, '2022-06-04 23:11:41');
insert into books (id, name, year, author, person_id, taken_at) values (19, 'Sorceress', 2004, 'Morrie Lomb', 19, '2021-12-30 19:41:51');
insert into books (id, name, year, author, person_id, taken_at) values (20, 'Be Cool', 2006, 'Nissa Sinncock', 20, '2022-10-29 17:42:47');
insert into books (id, name, year, author, person_id, taken_at) values (21, 'Into the West', 2010, 'Rutter Verson', 21, '2022-06-14 05:17:00');
insert into books (id, name, year, author, person_id, taken_at) values (22, 'Battle of the Sexes, The', 2007, 'Caron Giurio', 22, '2021-12-16 14:02:20');
insert into books (id, name, year, author, person_id, taken_at) values (23, 'Her Highness and the Bellboy', 1998, 'Nickolas Lowthorpe', 23, '2022-07-17 10:01:49');
insert into books (id, name, year, author, person_id, taken_at) values (24, 'Hawking', 1995, 'Ennis Pitford', 24, '2022-02-24 04:27:42');
insert into books (id, name, year, author, person_id, taken_at) values (25, 'Adventures of Mary-Kate and Ashley, The: The Case of the United States Navy Adventure', 2011, 'Timotheus Aiston', 25, '2022-03-31 20:01:17');
insert into books (id, name, year, author, person_id, taken_at) values (26, 'Divide and Conquer (Why We Fight, 3)', 1998, 'Curry Medforth', 26, '2022-11-05 22:05:51');
insert into books (id, name, year, author, person_id, taken_at) values (27, 'Home Sweet Hell', 2004, 'Jamie Simenet', 27, '2022-03-09 23:34:47');
insert into books (id, name, year, author, person_id, taken_at) values (28, 'Molière', 2002, 'Maritsa Jeandot', 28, '2022-10-21 07:35:12');
insert into books (id, name, year, author, person_id, taken_at) values (29, 'E=mc2', 1998, 'Clarissa Tarte', 29, '2021-12-13 13:40:07');
insert into books (id, name, year, author, person_id, taken_at) values (30, 'Pee-wee''s Big Adventure', 1995, 'Jorey Pucker', 30, '2022-08-29 21:46:17');
--rollback delete from books;
