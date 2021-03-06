
insert into auth_user values('shrey', 'p0laris');

insert into Faction values('Doomsgate', 'Charlemagne', 'Atlantis');
insert into Faction values('Templars', 'Artanis', 'Aiur');
insert into Faction values('Wintersong', 'Wolf', 'Dorado');
insert into Faction values('Vortex', 'Arcturus', 'Augustgrad');
insert into Faction values('Symphian Order', 'Shadow', 'Tryst');
     
insert into Post values('Captain', 250000, 30);
insert into Post values('1st Mate', 175000, 25); 
insert into Post values('Cook', 150000, 20);
insert into Post values('Officer', 125000, 20);
insert into Post values('Medic', 100000, 15);
insert into Post values('Engineer', 100000, 15);
insert into Post values('Seaman', 25000, 0);

insert into Port values('Piota', 'A', 'Templars');
insert into Port values('Macklow', 'C', 'Templars');
insert into Port values('Adria', 'S', 'Vortex');
insert into Port values('Chillrend', 'B','Wintersong');
insert into Port values('Arthas', 'B','Wintersong');
insert into Port values('Shadowsong', 'S', 'Doomsgate');
insert into Port values('Chauron', 'B', 'Vortex');
insert into Port values('Zerus', 'A','Wintersong');
insert into Port values('Ventrue', 'S', 'Symphian Order');
insert into Port values('Adun', 'A', 'Symphian Order');
insert into Port values('Mar Sara', 'B', 'Templars');
insert into Port values('Vale', 'B', 'Doomsgate');

insert into Cargo values('Passenger', 5);
insert into Cargo values('Vehicles', 20);
insert into Cargo values('Ore', 15);
insert into Cargo values('Timber', 20);
insert into Cargo values('Food', 10);
insert into Cargo values('Weapons', 25);
insert into Cargo values('Misc', 20);

insert into Class values('Frigate', 'A');
insert into Class values('Caravel', 'C');
insert into Class values('Carrack', 'B');
insert into Class values('Brig', 'C');
insert into Class values('Schooner', 'B');
insert into Class values('Man o-war', 'S');
insert into class values('Galleon', 'A');
insert into Class values('Corvette', 'B');
insert into Class values('Flyut', 'C');
insert into Class values('Sloop', 'C');

insert into Ship values('Leviathan', 1709, 'Wintersong', 'Man o-war');
insert into Ship values('Westdale', 1590, 'Vortex', 'Sloop');
insert into Ship values('Jackdaw', 1698, 'Templars', 'Corvette');
insert into Ship values('Overdose', 1721, 'Doomsgate', 'Man o-war');
insert into Ship values('Lament', 1574, 'Wintersong', 'Schooner');
insert into Ship values('Compton', 1723, 'Templars', 'Brig');
insert into Ship values('Argonaut', 1655, 'Doomsgate', 'Frigate');
insert into Ship values('Olympus', 1624, 'Vortex', 'Carrack');
insert into Ship values('Ainz', 1711, 'Doomsgate', 'Caravel');
insert into Ship values('Alphonse', 1667, 'Doomsgate', 'Brig');
insert into Ship values('Crimson', 1600, 'Templars', 'Galleon');
insert into Ship values('Meltdown', 1567, 'Templars', 'Caravel');
insert into Ship values('Enthrall', 1674, 'Vortex', 'Flyut');
insert into Ship values('Alladin', 1787, 'Vortex', 'Frigate');
insert into Ship values('Crass', 1762, 'Wintersong', 'Flyut');
insert into Ship values('Overlord', 1500, 'Templars', 'Man o-war');
insert into Ship values('Alarak', 1699, 'Symphian Order', 'Galleon');
insert into Ship values('Tempest', 1700, 'Symphian Order', 'Carrack');
insert into Ship values('Pride', 1732, 'Symphian Order', 'Sloop');
insert into Ship values('Dauntless' ,1678 , 'Symphian Order', 'Caravel');

insert into Crew values (1,'Regina',32,5,'Meltdown','Wintersong','Seaman','M');
insert into Crew values (2,'Alden',56,10,'Alarak','Wintersong','Seaman','M');
insert into Crew values (3,'Castor',21,0,'Dauntless','Doomsgate','1st Mate','F');
insert into Crew values (4,'Mannix',65,17,'Dauntless','Symphian Order','Seaman','F');
insert into Crew values (5,'Jayme',51,30,'Olympus','Vortex','Seaman','F');
insert into Crew values (6,'Dahlia',39,15,'Alarak','Templars','Captain','M');
insert into Crew values (7,'Shay',51,9,'Alarak','Doomsgate','Seaman','M');
insert into Crew values (8,'Erasmus',55,30,'Ainz','Symphian Order','Officer','F');
insert into Crew values (9,'Brock',64,24,'Jackdaw','Vortex','Medic','M');
insert into Crew values (10,'Shana',40,18,'Tempest','Doomsgate','Seaman','M');
insert into Crew values (11,'Elaine',65,30,'Jackdaw','Doomsgate','Medic','M');
insert into Crew values (12,'Donna',42,14,'Olympus','Wintersong','Officer','M');
insert into Crew values (13,'Nyssa',38,4,'Tempest','Templars','Medic','M');
insert into Crew values (14,'Maggie',68,22,'Jackdaw','Wintersong','1st Mate','M');
insert into Crew values (15,'Madeson',63,19,'Enthrall','Doomsgate','Officer','M');
insert into Crew values (16,'Zephr',46,6,'Tempest','Wintersong','Medic','F');
insert into Crew values (17,'Rebekah',62,23,'Olympus','Symphian Order','Captain','M');
insert into Crew values (18,'Brennan',52,27,'Ainz','Doomsgate','Seaman','M');
insert into Crew values (19,'Lucy',26,3,'Overlord','Doomsgate','Captain','F');
insert into Crew values (20,'Sage',27,0,'Ainz','Wintersong','Cook','M');
insert into Crew values (21,'Dominique',27,1,'Jackdaw','Vortex','Engineer','F');
insert into Crew values (22,'Alexandra',65,45,'Argonaut','Doomsgate','Engineer','M');
insert into Crew values (23,'Wynne',32,1,'Leviathan','Templars','Engineer','F');
insert into Crew values (24,'Cadman',47,21,'Alphonse','Wintersong','Captain','F');
insert into Crew values (25,'Chelsea',46,21,'Enthrall','Templars','Captain','M');
insert into Crew values (26,'Graham',23,0,'Westdale','Wintersong','Captain','M');
insert into Crew values (27,'Dora',68,8,'Lament','Doomsgate','1st Mate','F');
insert into Crew values (28,'Randall',50,28,'Leviathan','Vortex','Captain','F');
insert into Crew values (29,'Linda',28,7,'Crass','Symphian Order','Captain','M');
insert into Crew values (30,'Cassandra',60,33,'Alladin','Symphian Order','Officer','M');
insert into Crew values (31,'Priscilla',27,3,'Overlord','Wintersong','1st Mate','F');
insert into Crew values (32,'Maxwell',29,2,'Tempest','Wintersong','1st Mate','F');
insert into Crew values (33,'Ursa',45,4,'Overdose','Vortex','Engineer','F');
insert into Crew values (34,'Ivory',31,8,'Enthrall','Symphian Order','Officer','F');
insert into Crew values (35,'Gage',30,4,'Alarak','Symphian Order','1st Mate','M');
insert into Crew values (36,'Sigourney',26,6,'Overdose','Doomsgate','1st Mate','M');
insert into Crew values (37,'Chaim',34,3,'Tempest','Templars','Medic','F');
insert into Crew values (38,'Chancellor',50,22,'Dauntless','Vortex','Seaman','F');
insert into Crew values (39,'Raven',28,4,'Alarak','Templars','Medic','M');
insert into Crew values (40,'Cole',24,1,'Overdose','Templars','1st Mate','M');
insert into Crew values (41,'Wilma',20,0,'Crimson','Doomsgate','Captain','F');
insert into Crew values (42,'Scarlett',30,1,'Alarak','Vortex','Medic','M');
insert into Crew values (43,'Pandora',25,2,'Compton','Symphian Order','Officer','F');
insert into Crew values (44,'Margaret',55,35,'Meltdown','Doomsgate','1st Mate','F');
insert into Crew values (45,'Steven',50,27,'Leviathan','Wintersong','1st Mate','F');
insert into Crew values (46,'Kato',22,2,'Compton','Templars','Cook','M');
insert into Crew values (47,'Michelle',58,15,'Ainz','Wintersong','Engineer','F');
insert into Crew values (48,'Kermit',39,12,'Meltdown','Doomsgate','Officer','M');
insert into Crew values (49,'Yetta',22,2,'Argonaut','Symphian Order','1st Mate','M');
insert into Crew values (50,'Kylynn',50,30,'Leviathan','Wintersong','Officer','M');
insert into Crew values (51,'Omar',66,35,'Pride','Symphian Order','Officer','F');
insert into Crew values (52,'Darryl',30,10,'Alladin','Wintersong','1st Mate','F');
insert into Crew values (53,'Shafira',66,22,'Compton','Wintersong','Cook','M');
insert into Crew values (54,'Camille',39,4,'Leviathan','Templars','Captain','M');
insert into Crew values (55,'Janna',43,14,'Meltdown','Vortex','Officer','M');
insert into Crew values (56,'Xander',66,30,'Overlord','Symphian Order','Engineer','F');
insert into Crew values (57,'Shana',25,3,'Argonaut','Symphian Order','Captain','M');
insert into Crew values (58,'Hanna',67,14,'Olympus','Symphian Order','Officer','M');
insert into Crew values (59,'Ivana',29,3,'Leviathan','Vortex','Engineer','F');
insert into Crew values (60,'Patrick',27,3,'Pride','Doomsgate','Seaman','F');
insert into Crew values (61,'Gareth',69,37,'Pride','Templars','1st Mate','M');
insert into Crew values (62,'Carolyn',38,9,'Crimson','Templars','Medic','M');
insert into Crew values (63,'Mohammad',38,2,'Westdale','Wintersong','1st Mate','M');
insert into Crew values (64,'Leah',31,9,'Argonaut','Templars','Engineer','F');
insert into Crew values (65,'Idona',22,0,'Compton','Wintersong','Captain','M');
insert into Crew values (66,'Imogene',33,12,'Lament','Wintersong','Captain','F');
insert into Crew values (67,'Isadora',36,17,'Tempest','Vortex','Captain','M');
insert into Crew values (68,'Aidan',24,1,'Overdose','Wintersong','Captain','M');
insert into Crew values (69,'Myra',30,7,'Jackdaw','Templars','Officer','F');
insert into Crew values (70,'Declan',33,11,'Compton','Vortex','Cook','F');
insert into Crew values (71,'Kuame',64,30,'Overlord','Doomsgate','Medic','M');
insert into Crew values (72,'Herrod',41,1,'Ainz','Doomsgate','Captain','F');
insert into Crew values (73,'Nell',22,2,'Jackdaw','Doomsgate','Seaman','M');
insert into Crew values (74,'Maggie',59,15,'Alphonse','Vortex','Medic','M');
insert into Crew values (75,'Anjolie',32,5,'Olympus','Doomsgate','Medic','M');
insert into Crew values (76,'Castor',66,27,'Crass','Wintersong','Cook','F');
insert into Crew values (77,'Xanthus',67,30,'Leviathan','Templars','Officer','M');
insert into Crew values (78,'Fredericka',52,23,'Olympus','Symphian Order','Engineer','M');
insert into Crew values (79,'Kimberley',25,4,'Jackdaw','Doomsgate','Captain','M');
insert into Crew values (80,'Trevor',40,13,'Crimson','Vortex','Medic','M');
insert into Crew values (81,'Neve',51,18,'Enthrall','Templars','Cook','M');
insert into Crew values (82,'Dorothy',21,0,'Tempest','Doomsgate','Seaman','F');
insert into Crew values (83,'April',34,4,'Dauntless','Vortex','Engineer','M');
insert into Crew values (84,'Illiana',21,1,'Alarak','Doomsgate','Officer','F');
insert into Crew values (85,'Lucius',35,13,'Lament','Vortex','Officer','F');
insert into Crew values (86,'Tana',23,2,'Overdose','Templars','Cook','F');
insert into Crew values (87,'Peter',35,17,'Pride','Wintersong','Captain','M');
insert into Crew values (88,'Jaquelyn',24,2,'Tempest','Wintersong','Officer','M');
insert into Crew values (89,'Shaeleigh',22,0,'Overdose','Doomsgate','Cook','F');
insert into Crew values (90,'Sloane',55,32,'Dauntless','Vortex','Captain','F');
insert into Crew values (91,'Jameson',55,13,'Ainz','Doomsgate','Cook','F');
insert into Crew values (92,'Demetrius',48,5,'Lament','Symphian Order','Medic','M');
insert into Crew values (93,'Velma',44,20,'Enthrall','Vortex','Engineer','F');
insert into Crew values (94,'Kylynn',60,13,'Overlord','Templars','Seaman','M');
insert into Crew values (95,'Riley',20,0,'Crimson','Doomsgate','Medic','M');
insert into Crew values (96,'Teegan',30,5,'Crass','Doomsgate','Officer','M');
insert into Crew values (97,'Rinah',54,27,'Argonaut','Vortex','Medic','M');
insert into Crew values (98,'Quentin',47,16,'Alladin','Wintersong','Captain','F');
insert into Crew values (99,'Nigel',34,3,'Westdale','Symphian Order','Seaman','M');
insert into Crew values (100,'Maia',23,1,'Enthrall','Vortex','Cook','F');
insert into Crew values (101,'Donaldson',58,21,'Ainz','Doomsgate','1st Mate','F');
insert into Crew values (102,'Nicholson',43,3,'Ainz','Templars','Medic','F');
insert into Crew values (103,'Cote',65,10,'Leviathan','Wintersong','Engineer','F');
insert into Crew values (104,'Campos',67,19,'Alladin','Wintersong','Engineer','F');
insert into Crew values (105,'Dickerson',49,7,'Argonaut','Wintersong','1st Mate','M');
insert into Crew values (106,'Brennan',47,16,'Alarak','Symphian Order','Engineer','M');
insert into Crew values (107,'Stuart',61,13,'Alphonse','Wintersong','Engineer','F');
insert into Crew values (108,'Ellis',57,4,'Enthrall','Templars','Engineer','F');
insert into Crew values (109,'Cardenas',51,8,'Leviathan','Templars','Officer','M');
insert into Crew values (110,'Hubbard',30,15,'Alladin','Vortex','Medic','F');
insert into Crew values (111,'Kent',60,26,'Westdale','Wintersong','Seaman','F');
insert into Crew values (112,'Bullock',40,1,'Crass','Wintersong','Seaman','F');
insert into Crew values (113,'Stevenson',44,25,'Argonaut','Vortex','Officer','F');
insert into Crew values (114,'Hansen',39,21,'Alphonse','Templars','Cook','M');
insert into Crew values (115,'Woods',40,17,'Ainz','Symphian Order','Engineer','M');
insert into Crew values (116,'Mcdaniel',66,23,'Tempest','Templars','Officer','F');
insert into Crew values (117,'Rojas',70,3,'Olympus','Templars','Engineer','F');
insert into Crew values (118,'Delaney',48,27,'Olympus','Wintersong','Engineer','F');
insert into Crew values (119,'Gibson',30,18,'Dauntless','Templars','Medic','F');
insert into Crew values (120,'Stanton',49,7,'Leviathan','Wintersong','Cook','F');
insert into Crew values (121,'Gross',54,29,'Compton','Symphian Order','Cook','F');
insert into Crew values (122,'Fuller',31,16,'Olympus','Wintersong','Cook','F');
insert into Crew values (123,'Becker',60,18,'Alladin','Symphian Order','Cook','M');
insert into Crew values (124,'Alford',56,3,'Dauntless','Wintersong','Cook','M');
insert into Crew values (125,'Blevins',61,12,'Leviathan','Vortex','Medic','F');
insert into Crew values (126,'Wilcox',61,20,'Tempest','Symphian Order','Engineer','M');
insert into Crew values (127,'Washington',59,3,'Overdose','Templars','Medic','F');
insert into Crew values (128,'Gilliam',52,22,'Crimson','Vortex','Officer','F');
insert into Crew values (129,'Rose',37,29,'Jackdaw','Symphian Order','Cook','F');
insert into Crew values (130,'Roach',42,17,'Compton','Templars','Cook','M');
insert into Crew values (131,'Mercado',61,5,'Pride','Symphian Order','Medic','F');
insert into Crew values (132,'Thornton',56,24,'Crass','Vortex','Engineer','M');
insert into Crew values (133,'Pope',55,16,'Olympus','Templars','Officer','F');
insert into Crew values (134,'Short',40,21,'Crass','Doomsgate','Seaman','M');
insert into Crew values (135,'Hale',41,25,'Compton','Vortex','Officer','F');
insert into Crew values (136,'Cash',53,5,'Overdose','Templars','Medic','M');
insert into Crew values (137,'Watson',46,3,'Ainz','Symphian Order','Cook','M');
insert into Crew values (138,'Parker',44,11,'Overdose','Symphian Order','Cook','F');
insert into Crew values (139,'Hall',31,24,'Alladin','Symphian Order','Cook','M');
insert into Crew values (140,'Stevens',48,14,'Tempest','Templars','Cook','F');
insert into Crew values (141,'Gardner',33,10,'Alarak','Wintersong','Medic','M');
insert into Crew values (142,'Odonnell',56,3,'Overdose','Wintersong','Medic','M');
insert into Crew values (143,'Roy',64,9,'Olympus','Templars','Cook','M');
insert into Crew values (144,'Snyder',61,13,'Meltdown','Symphian Order','Officer','M');
insert into Crew values (145,'Hood',48,18,'Olympus','Wintersong','Engineer','F');
insert into Crew values (146,'Figueroa',65,11,'Enthrall','Vortex','Cook','M');
insert into Crew values (147,'Stephenson',43,11,'Alphonse','Symphian Order','Medic','F');
insert into Crew values (148,'Rios',69,23,'Lament','Templars','Medic','F');
insert into Crew values (149,'Savage',50,15,'Alphonse','Symphian Order','1st Mate','M');
insert into Crew values (150,'Acevedo',37,14,'Tempest','Doomsgate','Medic','F');
insert into Crew values (151,'Porter',39,17,'Crass','Wintersong','1st Mate','M');
insert into Crew values (152,'Miller',63,30,'Compton','Doomsgate','Seaman','M');
insert into Crew values (153,'Reese',61,1,'Alladin','Templars','Medic','M');
insert into Crew values (154,'Whitaker',37,30,'Alarak','Vortex','Seaman','F');
insert into Crew values (155,'Ross',49,29,'Compton','Vortex','Cook','M');
insert into Crew values (156,'Steele',46,8,'Pride','Vortex','Officer','F');
insert into Crew values (157,'Madden',58,11,'Ainz','Doomsgate','Seaman','F');
insert into Crew values (158,'Myers',66,16,'Alphonse','Templars','Officer','F');
insert into Crew values (159,'Dawson',55,6,'Pride','Templars','Cook','F');
insert into Crew values (160,'Lopez',68,6,'Enthrall','Doomsgate','1st Mate','F');
insert into Crew values (161,'Hayden',56,18,'Pride','Doomsgate','Seaman','F');
insert into Crew values (162,'Christian',56,7,'Westdale','Templars','Officer','M');
insert into Crew values (163,'Best',49,20,'Lament','Vortex','Officer','F');
insert into Crew values (164,'Kirby',68,17,'Crimson','Symphian Order','Seaman','F');
insert into Crew values (165,'Finch',37,29,'Crass','Wintersong','Medic','F');
insert into Crew values (166,'Cabrera',41,0,'Crass','Symphian Order','Cook','F');
insert into Crew values (167,'Alston',69,28,'Olympus','Symphian Order','Medic','M');
insert into Crew values (168,'Summers',67,14,'Crass','Doomsgate','Cook','M');
insert into Crew values (169,'Lamb',69,28,'Tempest','Vortex','Seaman','F');
insert into Crew values (170,'Morin',64,8,'Enthrall','Symphian Order','Medic','F');
insert into Crew values (171,'Browning',30,7,'Pride','Doomsgate','Officer','M');
insert into Crew values (172,'Kent',41,25,'Tempest','Wintersong','Cook','F');
insert into Crew values (173,'Madden',48,18,'Crimson','Wintersong','Medic','F');
insert into Crew values (174,'Oconnor',42,11,'Meltdown','Doomsgate','Engineer','M');
insert into Crew values (175,'Olson',33,19,'Leviathan','Doomsgate','Officer','F');
insert into Crew values (176,'Patel',57,26,'Alladin','Vortex','Cook','F');
insert into Crew values (177,'Burke',36,12,'Alladin','Templars','Seaman','F');
insert into Crew values (178,'Ayala',50,12,'Meltdown','Wintersong','Medic','F');
insert into Crew values (179,'Stone',62,12,'Crimson','Vortex','Medic','M');
insert into Crew values (180,'Mercado',64,16,'Argonaut','Vortex','Medic','M');
insert into Crew values (181,'Pratt',32,24,'Alarak','Doomsgate','Engineer','M');
insert into Crew values (182,'Merrill',35,9,'Crimson','Doomsgate','Engineer','F');
insert into Crew values (183,'Harrison',40,16,'Crimson','Templars','Engineer','F');
insert into Crew values (184,'Murray',30,7,'Crass','Wintersong','Cook','F');
insert into Crew values (185,'Buck',55,0,'Tempest','Vortex','Seaman','M');
insert into Crew values (186,'Delacruz',63,29,'Pride','Doomsgate','Medic','F');
insert into Crew values (187,'Pacheco',35,14,'Pride','Wintersong','Seaman','M');
insert into Crew values (188,'Shelton',33,2,'Alphonse','Templars','Officer','M');
insert into Crew values (189,'Norris',38,10,'Leviathan','Templars','Officer','F');
insert into Crew values (190,'Crawford',37,10,'Enthrall','Templars','Cook','F');
insert into Crew values (191,'Shields',39,10,'Overdose','Doomsgate','Cook','F');
insert into Crew values (192,'Matthews',66,7,'Olympus','Wintersong','Officer','F');
insert into Crew values (193,'Huff',43,11,'Lament','Vortex','Officer','M');
insert into Crew values (194,'Barron',36,1,'Overdose','Templars','Seaman','F');
insert into Crew values (195,'Alvarado',46,18,'Olympus','Symphian Order','1st Mate','F');
insert into Crew values (196,'Gaines',41,6,'Alladin','Doomsgate','Officer','F');
insert into Crew values (197,'Gross',39,27,'Alladin','Doomsgate','Cook','F');
insert into Crew values (198,'Vaughn',63,12,'Compton','Symphian Order','1st Mate','M');
insert into Crew values (199,'Peters',48,19,'Meltdown','Doomsgate','Cook','F');
insert into Crew values (200,'Young',70,12,'Leviathan','Doomsgate','Medic','M');

insert into Voyage values('Piota', 'Shadowsong','31-Dec-1798' ,'Leviathan' ,'Weapons');
insert into Voyage values('Arthas', 'Vale','15-Jan-1799' ,'Westdale' ,'Passenger');
insert into Voyage values('Zerus', 'Piota','13-Mar-1799' ,'Jackdaw' ,'Food');
insert into Voyage values('Chillrend', 'Shadowsong','07-Apr-1799' ,'Overdose' ,'Vehicles');
insert into Voyage values('Ventrue', 'Zerus','05-Feb-1799' ,'Lament' ,'Timber');
insert into Voyage values('Macklow', 'Adria','10-Jun-1799' ,'Compton' ,'Timber');
insert into Voyage values('Arthas', 'Mar Sara','15-Jun-1799' ,'Argonaut','Food');
insert into Voyage values('Mar Sara', 'Adun','28-Feb-1799' ,'Olympus' ,'Misc');
insert into Voyage values('Piota', 'Ventrue','01-Mar-1799' ,'Ainz' ,'Passenger');
insert into Voyage values('Adria', 'Chillrend','19-Jan-1799' ,'Alphonse' ,'Passenger');
insert into Voyage values('Chillrend', 'Adria','22-Apr-1799' ,'Crimson','Vehicles');
insert into Voyage values('Shadowsong', 'Zerus','29-Mar-1799' ,'Meltdown','Misc');
insert into Voyage values('Chauron', 'Piota','31-May-1799' ,'Enthrall' ,'Passenger');
insert into Voyage values('Adun', 'Piota','30-Apr-1799' ,'Alladin' ,'Misc');
insert into Voyage values('Mar Sara', 'Shadowsong','12-Mar-1799' ,'Crass' ,'Weapons');
insert into Voyage values('Shadowsong', 'Adria','19-Jul-1799' ,'Overlord' ,'Food');
insert into Voyage values('Adria', 'Ventrue','15-Feb-1799' ,'Alarak' ,'Timber');
insert into Voyage values('Arthas', 'Shadowsong','24-Jan-1799' ,'Tempest' ,'Ore');
insert into Voyage values('Piota', 'Vale','05-Mar-1799' ,'Pride' ,'Ore');
insert into Voyage values('Zerus', 'Ventrue','09-Apr-1799' ,'Dauntless','Vehicles');