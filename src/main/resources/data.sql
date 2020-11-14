
CREATE TABLE IF NOT EXISTS survey
(
    id_survey                   INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                        VARCHAR(65) NOT NULL,
    description                 TEXT(255) NOT NULL,
    isAvailable                 BOOLEAN NOT NULL,
    endDate                     DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS comments
(
    id_comments                 INT(11) PRIMARY KEY,
    id_survey                   INT(11) NOT NULL REFERENCES survey (id_survey),
    message                     TEXT(255)
);

CREATE TABLE IF NOT EXISTS votes
(
    id_votes                    INT(11) PRIMARY KEY NOT NULL,
    id_survey                   INT(11) NOT NULL REFERENCES survey (id_survey),
    option                      DATETIME NOT NULL,
    answers                     VARCHAR(65),
    name                        VARCHAR(65)
);

INSERT INTO survey VALUES (1, 'Mon premier sondage',  'Mon tout premier sondage !', true, '2020-11-06 12:35:45');

INSERT INTO comments VALUES (1, 1,  'Comptez sur moi :)');

INSERT INTO votes VALUES (1, 1,  '2020-11-08 12:00:00', 'available', 'Alexandre');
INSERT INTO votes VALUES (2, 1,  '2020-11-08 12:00:00', 'available', 'Clément');
INSERT INTO votes VALUES (3, 1,  '2020-11-08 12:00:00', 'unknown', 'Liam');
INSERT INTO votes VALUES (4, 1,  '2020-11-08 12:00:00', 'unavailable', 'Vincent');

INSERT INTO votes VALUES (5, 1,  '2020-11-15 12:00:00', 'unknown', 'Alexandre');
INSERT INTO votes VALUES (6, 1,  '2020-11-15 12:00:00', 'unknown', 'Clément');
INSERT INTO votes VALUES (7, 1,  '2020-11-15 12:00:00', 'unknown', 'Liam');
INSERT INTO votes VALUES (8, 1,  '2020-11-15 12:00:00', 'unavailable', 'Vincent');

INSERT INTO survey VALUES (2, 'Mon deuxieme sondage',  'Mon tout deuxieme sondage !', true, '2020-11-10 12:35:45');

INSERT INTO comments VALUES (9, 2,  'Comptez sur moi :)');

INSERT INTO votes VALUES (10, 2,  '2020-11-08 12:00:00', 'available', 'Alexandre');
INSERT INTO votes VALUES (11, 2,  '2020-11-08 12:00:00', 'available', 'Clément');
INSERT INTO votes VALUES (12, 2,  '2020-11-08 12:00:00', 'unknown', 'Liam');
INSERT INTO votes VALUES (13, 2,  '2020-11-08 12:00:00', 'unavailable', 'Vincent');

INSERT INTO votes VALUES (14, 2,  '2020-11-15 12:00:00', 'unknown', 'Alexandre');
INSERT INTO votes VALUES (15, 2,  '2020-11-15 12:00:00', 'unknown', 'Clément');
INSERT INTO votes VALUES (16, 2,  '2020-11-15 12:00:00', 'unknown', 'Liam');
INSERT INTO votes VALUES (17, 2,  '2020-11-15 12:00:00', 'unavailable', 'Vincent');