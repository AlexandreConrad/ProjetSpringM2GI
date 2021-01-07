DROP TABLE IF EXISTS "VOTE";
DROP TABLE IF EXISTS "CHOICE";
DROP TABLE IF EXISTS "COMMENT";
DROP TABLE IF EXISTS "OPTION";
DROP TABLE IF EXISTS "SURVEY";

CREATE TABLE `SURVEY`( `ID_SURVEY` int(11) NOT NULL AUTO_INCREMENT, `NAME` varchar(65) NOT NULL, `DESCRIPTION` text NOT NULL, `END_DATE` DATETIME NOT NULL, `IS_AVAILABLE` BOOLEAN NOT NULL);
INSERT INTO `SURVEY` (`ID_SURVEY`, `NAME`, `DESCRIPTION`, `END_DATE`, `IS_AVAILABLE`)VALUES (1, 'Anniversaire suprise pour Alexandre ?', 'On fait une surprise, ne lui dites pas !!', '2020-12-31 12:00:00', 1), (2, 'Projet X après le déconfinement ?', 'Ça va être mortel !!', '2020-12-31 12:00:00', 0), (3, 'Soirée Netflix & Chill ?', 'On regardera Star Wars :)', '2021-01-31 12:00:00', 1), (4, 'Tour des garages pour trouver ma nouvelle voiture ?', 'Je veux une lambo, minimum', '2021-01-31 12:00:00', 1);

CREATE TABLE `CHOICE`( `ID_CHOICE` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, `DATE` DATETIME NOT NULL, `ID_SURVEY` int(11) NOT NULL, CONSTRAINT ID_SURVEY_CHOICE FOREIGN KEY (`ID_SURVEY`) REFERENCES SURVEY (ID_SURVEY) ON DELETE CASCADE);
INSERT INTO `CHOICE` (`ID_CHOICE`, `DATE`, `ID_SURVEY`)VALUES (1, '2021-01-31 12:00:00', 1), (2, '2020-12-25 12:00:00', 1), (3, '2020-12-31 12:00:00', 2), (4, '2021-01-01 12:00:00', 2), (5, '2021-01-08 12:00:00', 3), (6, '2021-01-15 12:00:00', 3), (7, '2020-12-16 12:00:00', 4), (8, '2020-12-01 12:00:00', 4);

CREATE TABLE `COMMENT`( `ID_COMMENT` int(11) NOT NULL AUTO_INCREMENT, `COMMENT` text NOT NULL, `AUTHOR` varchar(65) NOT NULL, `ID_SURVEY` int(11) NOT NULL, CONSTRAINT ID_SURVEY_COMMENT FOREIGN KEY (`ID_SURVEY`) REFERENCES SURVEY (ID_SURVEY) ON DELETE CASCADE);
INSERT INTO `COMMENT` (`ID_COMMENT`, `COMMENT`, `AUTHOR`, `ID_SURVEY`)VALUES (1, 'Je serai là !', 'Théo', 1), (2, 'Je ramène la guacamole !', 'Vincent', 3), (3, 'Ok, je ramène les chips', 'Clément', 3), (4, 'La tournée est pour moi, je te paie même une MacLaren :)', 'Stéphane', 4);

CREATE TABLE `OPTION`( `ID_OPTION` int(11) NOT NULL AUTO_INCREMENT, `NAME` varchar(65) NOT NULL);
INSERT INTO `OPTION` (`ID_OPTION`, `NAME`)VALUES (1, 'Disponible'), (2, 'Indisponible'), (3, 'Peut-être');

CREATE TABLE `VOTE`( `ID_VOTE` int(11) NOT NULL AUTO_INCREMENT, `AUTHOR` varchar(65) NOT NULL, `ID_CHOICE` int(11) NOT NULL, `ID_OPTION` int(11) NOT NULL, CONSTRAINT ID_OPTION_VOTE FOREIGN KEY (`ID_OPTION`) REFERENCES OPTION (ID_OPTION) ON DELETE CASCADE, CONSTRAINT ID_CHOICE_VOTE FOREIGN KEY (`ID_CHOICE`) REFERENCES CHOICE (ID_CHOICE) ON DELETE CASCADE);
INSERT INTO `VOTE` (`ID_VOTE`, `AUTHOR`, `ID_CHOICE`, `ID_OPTION`)VALUES (1, 'Théo', 1, 1), (2, 'Théo', 2, 2), (3, 'Alexandre', 1, 1), (4, 'Alexandre', 2, 3), (5, 'Jade', 1, 2), (6, 'Jade', 2, 2), (7, 'Camylle', 2, 3), (8, 'Loïc', 2, 3), (9, 'Jérôme', 2, 3), (10, 'Théo', 3, 1), (11, 'Théo', 4, 1), (12, 'Alex', 3, 3), (13, 'Samuel', 4, 3), (14, 'Vincent', 3, 1), (15, 'Vincent', 4, 1), (16, 'Clément', 3, 2), (17, 'Clément', 4, 2), (18, 'Clément', 5, 1), (19, 'Clément', 6, 1), (20, 'Vincent', 5, 3), (21, 'Vincent', 6, 3), (22, 'Cédric', 5, 3), (23, 'George', 6, 3), (24, 'Stéphane', 7, 1), (25, 'Stéphane', 8, 1), (26, 'Théo', 7, 1), (27, 'Théo', 8, 3);

COMMIT;
