-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : lun. 07 déc. 2020 à 13:40
-- Version du serveur :  10.5.7-MariaDB-1:10.5.7+maria~focal
-- Version de PHP : 7.4.12

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- START TRANSACTION;
-- SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Alexandre Conrad`
--

-- --------------------------------------------------------

--
-- Structure de la table `choices`
--

CREATE TABLE `choices` (
                           `id_choices` int(11) NOT NULL,
                           `date` date NOT NULL,
                           `id_survey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `choices`
--

INSERT INTO `choices` (`id_choices`, `date`, `id_survey`) VALUES
(1, '2020-12-24', 1),
(2, '2020-12-25', 1),
(3, '2020-12-31', 2),
(4, '2021-01-01', 2),
(5, '2021-01-08', 3),
(6, '2021-01-15', 3),
(7, '2020-12-16', 4),
(8, '2020-12-01', 4);

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

CREATE TABLE `comments` (
                            `id_comments` int(11) NOT NULL,
                            `comments` text NOT NULL,
                            `author` varchar(65) NOT NULL,
                            `id_survey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `comments`
--

INSERT INTO `comments` (`id_comments`, `comments`, `author`, `id_survey`) VALUES
(1, 'Je serai là !', 'Théo', 1),
(2, 'Je ramène la guacamole !', 'Vincent', 3),
(3, 'Ok, je ramène les chips', 'Clément', 3),
(4, 'La tournée est pour moi, je te paie même une MacLaren :)', 'Stéphane', 4);

-- --------------------------------------------------------

--
-- Structure de la table `option`
--

CREATE TABLE `option` (
  `id_option` int(11) NOT NULL,
  `name` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `option`
--

INSERT INTO `option` (`id_option`, `name`) VALUES
(1, 'Disponible'),
(2, 'Indisponible'),
(3, 'Peut-être');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `resultat`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `resultat` (
`Survey` varchar(65)
,`Date` date
,`Choices` varchar(65)
,`Author` varchar(65)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `resultat_comments`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `resultat_comments` (
`name` varchar(65)
,`comments` text
,`author` varchar(65)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `resultat_compte`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `resultat_compte` (
`Survey` varchar(65)
,`Date` date
,`Choises` varchar(65)
,`Nombre de votes` bigint(21)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `resultat_disponible`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `resultat_disponible` (
`Survey` varchar(65)
,`Date` date
,`Choises` varchar(65)
,`Nombre de votes` bigint(21)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `resultat_susceptible`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `resultat_susceptible` (
`Survey` varchar(65)
,`Date` date
,`Choises` varchar(65)
,`Nombre de votes` bigint(21)
);

-- --------------------------------------------------------

--
-- Structure de la table `survey`
--

CREATE TABLE `survey` (
  `id_survey` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(65) NOT NULL,
  `description` text NOT NULL,
  `endDate` date NOT NULL,
  `isAvailable` BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `survey`
--

INSERT INTO `survey` (`id_survey`, `name`, `description`, `endDate`, `isAvailable`) VALUES
(1, 'Quand fêter le birthday à Alexandre ?', 'On fait une surprise, ne lui dites pas !!', '2020-12-31', 1),
(2, 'Projet X après le déconfinement ?', 'Ça va être mortel !!', '2020-12-31', 0),
(3, 'Soirée Netflix & Chill ?', 'On regardera Star Wars :)', '2021-01-31', 1),
(4, 'Tour des garages pour trouver ma nouvelle voiture ?', 'Je veux une lambo, minimum', '2020-12-24', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

CREATE TABLE `vote` (
                        `id_vote` int(11) NOT NULL,
                        `author` varchar(65) NOT NULL,
                        `id_choices` int(11) NOT NULL,
                        `id_option` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vote`
--

INSERT INTO `vote` (`id_vote`, `author`, `id_choices`, `id_option`) VALUES
(1, 'Théo', 1, 1),
(2, 'Théo', 2, 2),
(3, 'Alexandre', 1, 1),
(4, 'Alexandre', 2, 3),
(5, 'Jade', 1, 2),
(6, 'Jade', 2, 2),
(7, 'Camylle', 2, 3),
(8, 'Loïc', 2, 3),
(9, 'Jérôme', 2, 3),
(10, 'Théo', 3, 1),
(11, 'Théo', 4, 1),
(12, 'Alex', 3, 3),
(13, '', 4, 3),
(14, 'Vincent', 3, 1),
(15, 'Vincent', 4, 1),
(16, 'Clément', 3, 2),
(17, 'Clément', 4, 2),
(18, 'Clément', 5, 1),
(19, 'Clément', 6, 1),
(20, 'Vincent', 5, 3),
(21, 'Vincent', 6, 3),
(22, 'Cédric', 5, 3),
(23, '', 6, 3),
(24, 'Stéphane', 7, 1),
(25, 'Stéphane', 8, 1),
(26, 'Théo', 7, 1),
(27, 'Théo', 8, 3);

-- --------------------------------------------------------

--
-- Structure de la vue `resultat`
--
DROP TABLE IF EXISTS `resultat`;

CREATE ALGORITHM=UNDEFINED DEFINER=`alexandreconrad`@`%` SQL SECURITY DEFINER VIEW `resultat`  AS SELECT `s`.`name` AS `Survey`, `c`.`date` AS `Date`, `o`.`name` AS `Choices`, `v`.`author` AS `Author` FROM (((`vote` `v` join `choices` `c` on(`c`.`id_choices` = `v`.`id_choices`)) join `survey` `s` on(`c`.`id_survey` = `s`.`id_survey`)) join `option` `o` on(`v`.`id_option` = `o`.`id_option`)) ;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_comments`
--
DROP TABLE IF EXISTS `resultat_comments`;

CREATE ALGORITHM=UNDEFINED DEFINER=`alexandreconrad`@`%` SQL SECURITY DEFINER VIEW `resultat_comments`  AS SELECT `s`.`name` AS `name`, `c`.`comments` AS `comments`, `c`.`author` AS `author` FROM (`comments` `c` join `survey` `s`) WHERE `c`.`id_survey` = `s`.`id_survey` ;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_compte`
--
DROP TABLE IF EXISTS `resultat_compte`;

CREATE ALGORITHM=UNDEFINED DEFINER=`alexandreconrad`@`%` SQL SECURITY DEFINER VIEW `resultat_compte`  AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_disponible`
--
DROP TABLE IF EXISTS `resultat_disponible`;

CREATE ALGORITHM=UNDEFINED DEFINER=`alexandreconrad`@`%` SQL SECURITY DEFINER VIEW `resultat_disponible`  AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` WHERE `resultat`.`Choices` = 'Disponible' GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ORDER BY count(`resultat`.`Choices`) DESC LIMIT 0, 1 ;

-- --------------------------------------------------------

--
-- Structure de la vue `resultat_susceptible`
--
DROP TABLE IF EXISTS `resultat_susceptible`;

CREATE ALGORITHM=UNDEFINED DEFINER=`alexandreconrad`@`%` SQL SECURITY DEFINER VIEW `resultat_susceptible`  AS SELECT `resultat`.`Survey` AS `Survey`, `resultat`.`Date` AS `Date`, `resultat`.`Choices` AS `Choices`, count(`resultat`.`Choices`) AS `Nombre de votes` FROM `resultat` WHERE `resultat`.`Choices` in ('Disponible','Peut-être') GROUP BY `resultat`.`Survey`, `resultat`.`Choices`, `resultat`.`Date` ORDER BY count(`resultat`.`Choices`) DESC LIMIT 0, 1 ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `choices`
--
ALTER TABLE `choices`
    ADD PRIMARY KEY (`id_choices`),
  ADD KEY `id_survey` (`id_survey`);

--
-- Index pour la table `comments`
--
ALTER TABLE `comments`
    ADD PRIMARY KEY (`id_comments`),
  ADD KEY `comments_ibfk_1` (`id_survey`);

--
-- Index pour la table `option`
--
ALTER TABLE `option`
    ADD PRIMARY KEY (`id_option`);

--
-- Index pour la table `survey`
--
ALTER TABLE `survey`
    ADD PRIMARY KEY (`id_survey`);

--
-- Index pour la table `vote`
--
ALTER TABLE `vote`
    ADD PRIMARY KEY (`id_vote`),
  ADD KEY `id_option` (`id_option`),
  ADD KEY `id_choices` (`id_choices`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `choices`
--
ALTER TABLE `choices`
    MODIFY `id_choices` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `comments`
--
ALTER TABLE `comments`
    MODIFY `id_comments` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `option`
--
ALTER TABLE `option`
    MODIFY `id_option` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `survey`
--
ALTER TABLE `survey`
    MODIFY `id_survey` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `vote`
--
ALTER TABLE `vote`
    MODIFY `id_vote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `choices`
--
ALTER TABLE `choices`
    ADD CONSTRAINT `choices_ibfk_1` FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`);

--
-- Contraintes pour la table `comments`
--
ALTER TABLE `comments`
    ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote`
    ADD CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`id_option`) REFERENCES `option` (`id_option`),
  ADD CONSTRAINT `vote_ibfk_2` FOREIGN KEY (`id_choises`) REFERENCES `choices` (`id_choices`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
