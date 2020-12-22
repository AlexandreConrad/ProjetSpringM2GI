DROP VIEW IF EXISTS "RESULTAT_COMPTE";
DROP VIEW IF EXISTS "RESULTAT_DISPONIBLE";
DROP VIEW IF EXISTS "RESULTAT_SUSCEPTIBLE";
DROP VIEW IF EXISTS "RESULTAT";
DROP VIEW IF EXISTS "RESULTAT_COMMENTS";
DROP VIEW IF EXISTS MOST_POSSIBLE;
DROP VIEW IF EXISTS MOST_MAYBE;

DROP TABLE IF EXISTS "VOTE";
DROP TABLE IF EXISTS "CHOICES";
DROP TABLE IF EXISTS "COMMENT";
DROP TABLE IF EXISTS "OPTION";
DROP TABLE IF EXISTS "SURVEY";

-- --------------------------------------------------------

--
-- Structure de la table `survey`
--

CREATE TABLE `survey` ( `id_survey` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(65) NOT NULL, `description` text NOT NULL, `endDate` DATETIME NOT NULL, `isAvailable` BOOLEAN NOT NULL);

--
-- Déchargement des données de la table `survey`
--

INSERT INTO `survey` (`id_survey`, `name`, `description`, `endDate`, `isAvailable`) VALUES(1, 'Anniversaire suprise pour Alexandre ?', 'On fait une surprise, ne lui dites pas !!', '2020-12-31 12:00:00', 1),(2, 'Projet X après le déconfinement ?', 'Ça va être mortel !!', '2020-12-31 12:00:00', 0),(3, 'Soirée Netflix & Chill ?', 'On regardera Star Wars :)', '2021-01-31 12:00:00', 1),(4, 'Tour des garages pour trouver ma nouvelle voiture ?', 'Je veux une lambo, minimum', '2021-01-31 12:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `choices`
--

-- CREATE TABLE `choices` ( `id_choices` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,`date` DATETIME NOT NULL,`id_survey` int(11) NOT NULL, FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`));

CREATE TABLE `choices` ( `id_choices` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,`date` DATETIME NOT NULL,`id_survey` int(11) NOT NULL, CONSTRAINT id_survey_choices FOREIGN KEY (`id_survey`) REFERENCES SURVEY (id_survey) ON DELETE CASCADE);


--
-- Déchargement des données de la table `choices`
--

INSERT INTO `choices` (`id_choices`, `date`, `id_survey`) VALUES(1, '2021-01-31 12:00:00', 1),(2, '2020-12-25 12:00:00', 1),(3, '2020-12-31 12:00:00', 2),(4, '2021-01-01 12:00:00', 2),(5, '2021-01-08 12:00:00', 3),(6, '2021-01-15 12:00:00', 3),(7, '2020-12-16 12:00:00', 4),(8, '2020-12-01 12:00:00', 4);

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

-- CREATE TABLE `comment` ( `id_comments` int(11) NOT NULL AUTO_INCREMENT, `comments` text NOT NULL, `author` varchar(65) NOT NULL, `id_survey` int(11) NOT NULL, FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`));
CREATE TABLE `comment` ( `id_comments` int(11) NOT NULL AUTO_INCREMENT, `comments` text NOT NULL, `author` varchar(65) NOT NULL, `id_survey` int(11) NOT NULL, CONSTRAINT id_survey_comments FOREIGN KEY (`id_survey`) REFERENCES SURVEY (id_survey) ON DELETE CASCADE);

--
-- Déchargement des données de la table `comments`
--

INSERT INTO `comment` (`id_comments`, `comments`, `author`, `id_survey`) VALUES(1, 'Je serai là !', 'Théo', 1L),(2, 'Je ramène la guacamole !', 'Vincent', 3),(3, 'Ok, je ramène les chips', 'Clément', 3),(4, 'La tournée est pour moi, je te paie même une MacLaren :)', 'Stéphane', 4);

-- --------------------------------------------------------

--
-- Structure de la table `option`
--

CREATE TABLE `option` ( `id_option` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(65) NOT NULL);

--
-- Déchargement des données de la table `option`
--

INSERT INTO `option` (`id_option`, `name`) VALUES(1, 'Disponible'),(2, 'Indisponible'),(3, 'Peut-être');

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

-- CREATE TABLE `vote` ( `id_vote` int(11) NOT NULL AUTO_INCREMENT, `author` varchar(65) NOT NULL, `id_choices` int(11) NOT NULL, `id_option` int(11) NOT NULL, FOREIGN KEY (`id_option`)  REFERENCES `option` (`id_option`), FOREIGN KEY (`id_choices`) REFERENCES `choices` (`id_choices`));
CREATE TABLE `vote` ( `id_vote` int(11) NOT NULL AUTO_INCREMENT, `author` varchar(65) NOT NULL, `id_choices` int(11) NOT NULL, `id_option` int(11) NOT NULL, CONSTRAINT id_option_vote FOREIGN KEY (`id_option`) REFERENCES OPTION (id_option) ON DELETE CASCADE, CONSTRAINT id_choices_vote FOREIGN KEY (`id_choices`) REFERENCES CHOICES (id_choices) ON DELETE CASCADE);

--
-- Déchargement des données de la table `vote`
--

INSERT INTO `vote` (`id_vote`, `author`, `id_choices`, `id_option`) VALUES(1, 'Théo', 1, 1),(2, 'Théo', 2, 2),(3, 'Alexandre', 1, 1),(4, 'Alexandre', 2, 3),(5, 'Jade', 1, 2),(6, 'Jade', 2, 2),(7, 'Camylle', 2, 3),(8, 'Loïc', 2, 3),(9, 'Jérôme', 2, 3),(10, 'Théo', 3, 1),(11, 'Théo', 4, 1),(12, 'Alex', 3, 3),(13, '', 4, 3),(14, 'Vincent', 3, 1),(15, 'Vincent', 4, 1),(16, 'Clément', 3, 2),(17, 'Clément', 4, 2),(18, 'Clément', 5, 1),(19, 'Clément', 6, 1),(20, 'Vincent', 5, 3),(21, 'Vincent', 6, 3),(22, 'Cédric', 5, 3),(23, '', 6, 3),(24, 'Stéphane', 7, 1),(25, 'Stéphane', 8, 1),(26, 'Théo', 7, 1),(27, 'Théo', 8, 3);

-- --------------------------------------------------------

--
-- Structure de la vue `resultat`
--

CREATE VIEW `resultat` AS SELECT `s`.`name` AS `Survey`, `c`.`date` AS `Date`, `o`.`name` AS `Choices`, `v`.`author` AS `Author` FROM (((`vote` `v` join `choices` `c` on(`c`.`id_choices` = `v`.`id_choices`)) join `survey` `s` on(`c`.`id_survey` = `s`.`id_survey`)) join `option` `o` on(`v`.`id_option` = `o`.`id_option`));

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_comments`
--

CREATE VIEW `resultat_comments` AS SELECT `s`.`name` AS `name`, `c`.`comments` AS `comments`, `c`.`author` AS `author` FROM (`comments` `c` join `survey` `s`) WHERE `c`.`id_survey` = `s`.`id_survey`;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_compte`
--

CREATE VIEW `resultat_compte` AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date`;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_disponible`
--

CREATE VIEW `resultat_disponible` AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` WHERE `resultat`.`Choices` = 'Disponible' GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ORDER BY count(`resultat`.`Choices`) DESC LIMIT 0, 10;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_susceptible`
--

CREATE VIEW `resultat_susceptible` AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` WHERE `resultat`.`Choices` in ('Disponible','Peut-être') GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ORDER BY count(`resultat`.`Choices`) DESC LIMIT 0, 10;

-- --------------------------------------------------------

--
-- Structure de la vue `MOST_MAYBE`
-- Le plus de personne susceptible
--
CREATE VIEW "MOST_MAYBE" AS SELECT COUNT(O.NAME) AS "PARTICIPANTS", S.ID_SURVEY AS "ID_SURVEY", O.ID_OPTION AS "ID_OPTION", S.NAME AS "NAME", C.DATE AS "DATE" from SURVEY S JOIN CHOICES C ON C.ID_SURVEY = S.ID_SURVEY JOIN VOTE V ON V.ID_CHOICES = C.ID_CHOICES JOIN OPTION O ON O.ID_OPTION = V.ID_OPTION WHERE O.NAME IN ('Disponible', 'Peut-être') GROUP BY C.DATE, O.ID_OPTION, C.DATE, S.ID_SURVEY, S.NAME ORDER BY ID_SURVEY, PARTICIPANTS;

-- --------------------------------------------------------

--
-- Structure de la vue `MOST_POSSIBLE`
-- Le plus de personne possible
--
CREATE VIEW "MOST_POSSIBLE" AS SELECT COUNT(O.NAME) AS "PARTICIPANTS", S.ID_SURVEY, O.ID_OPTION, S.NAME, C.DATE from SURVEY S JOIN CHOICES C ON C.ID_SURVEY = S.ID_SURVEY JOIN VOTE V ON V.ID_CHOICES = C.ID_CHOICES JOIN OPTION O ON O.ID_OPTION = V.ID_OPTION WHERE O.NAME IN ('Disponible') GROUP BY C.DATE, O.ID_OPTION, C.DATE, S.ID_SURVEY, S.NAME ORDER BY ID_SURVEY, PARTICIPANTS;

--
-- Contraintes pour les tables déchargées
--

COMMIT;