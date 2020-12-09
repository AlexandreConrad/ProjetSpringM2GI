DROP VIEW IF EXISTS "RESULTAT_COMPTE";
DROP VIEW IF EXISTS "RESULTAT_DISPONIBLE";
DROP VIEW IF EXISTS "RESULTAT_SUSCEPTIBLE";
DROP VIEW IF EXISTS "RESULTAT";
DROP VIEW IF EXISTS "RESULTAT_COMMENTS";

DROP TABLE IF EXISTS "VOTE";
DROP TABLE IF EXISTS "CHOICES";
DROP TABLE IF EXISTS "COMMENTS";
DROP TABLE IF EXISTS "OPTION";
DROP TABLE IF EXISTS "SURVEY";

--
-- Structure de la table `choices`
--

CREATE TABLE `choices` ( `id_choices` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,`date` DATETIME NOT NULL,`id_survey` int(11) NOT NULL);

--
-- Déchargement des données de la table `choices`
--

INSERT INTO `choices` (`id_choices`, `date`, `id_survey`) VALUES(1, '2021-01-31 12:00:00', 1),(2, '2020-12-25 12:00:00', 1),(3, '2020-12-31 12:00:00', 2),(4, '2021-01-01 12:00:00', 2),(5, '2021-01-08 12:00:00', 3),(6, '2021-01-15 12:00:00', 3),(7, '2020-12-16 12:00:00', 4),(8, '2020-12-01 12:00:00', 4);

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

CREATE TABLE `comments` ( `id_comments` int(11) NOT NULL AUTO_INCREMENT, `comments` text NOT NULL, `author` varchar(65) NOT NULL, `id_survey` int(11) NOT NULL);

--
-- Déchargement des données de la table `comments`
--

INSERT INTO `comments` (`id_comments`, `comments`, `author`, `id_survey`) VALUES(1, 'Je serai là !', 'Théo', 1),(2, 'Je ramène la guacamole !', 'Vincent', 3),(3, 'Ok, je ramène les chips', 'Clément', 3),(4, 'La tournée est pour moi, je te paie même une MacLaren :)', 'Stéphane', 4);

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
-- Structure de la table `survey`
--

CREATE TABLE `survey` ( `id_survey` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(65) NOT NULL, `description` text NOT NULL, `endDate` DATETIME NOT NULL, `isAvailable` BOOLEAN NOT NULL);

--
-- Déchargement des données de la table `survey`
--

INSERT INTO `survey` (`id_survey`, `name`, `description`, `endDate`, `isAvailable`) VALUES(1, 'Quand fêter le birthday à Alexandre ?', 'On fait une surprise, ne lui dites pas !!', '2020-12-31 12:00:00', 1),(2, 'Projet X après le déconfinement ?', 'Ça va être mortel !!', '2020-12-31 12:00:00', 0),(3, 'Soirée Netflix & Chill ?', 'On regardera Star Wars :)', '2021-01-31 12:00:00', 1),(4, 'Tour des garages pour trouver ma nouvelle voiture ?', 'Je veux une lambo, minimum', '2021-01-31 12:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

CREATE TABLE `vote` ( `id_vote` int(11) NOT NULL AUTO_INCREMENT, `author` varchar(65) NOT NULL, `id_choices` int(11) NOT NULL, `id_option` int(11) NOT NULL);

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

CREATE VIEW `resultat_disponible` AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` WHERE `resultat`.`Choices` = 'Disponible' GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ORDER BY count(`resultat`.`Choices`) DESC LIMIT 0, 1;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_susceptible`
--

CREATE VIEW `resultat_susceptible` AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` WHERE `resultat`.`Choices` in ('Disponible','Peut-être') GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ORDER BY count(`resultat`.`Choices`) DESC LIMIT 0, 1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `choices`
--
ALTER TABLE `choices` ADD PRIMARY KEY (`id_choices`);

--
-- Index pour la table `comments`
--
ALTER TABLE `comments` ADD PRIMARY KEY (`id_comments`);

--
-- Index pour la table `option`
--
ALTER TABLE `option` ADD PRIMARY KEY (`id_option`);

--
-- Index pour la table `survey`
--
ALTER TABLE `survey` ADD PRIMARY KEY (`id_survey`);

--
-- Index pour la table `vote`
--
ALTER TABLE `vote` ADD PRIMARY KEY (`id_vote`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `choices`
--
ALTER TABLE `choices` ADD CONSTRAINT `choices_ibfk_1` FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`);

--
-- Contraintes pour la table `comments`
--
ALTER TABLE `comments` ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote` ADD CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`id_option`) REFERENCES `option` (`id_option`);
ALTER TABLE `vote` ADD CONSTRAINT `vote_ibfk_2` FOREIGN KEY (`id_choices`) REFERENCES `choices` (`id_choices`);
COMMIT;





