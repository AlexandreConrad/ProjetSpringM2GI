DROP TABLE IF EXISTS surveys;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS votes;

CREATE TABLE IF NOT EXISTS surveys
(
    `id`                        INT(11) PRIMARY KEY,
    `name`                      VARCHAR(65),
    `description`               TEXT(255),
    `isAvailable`               BOOLEAN,
    `endDate`                   DATETIME
);

CREATE TABLE IF NOT EXISTS comments
(
    `id`                        INT(11) PRIMARY KEY,
    `id_survey`                 INT(11),
    `message`                   TEXT(255)
);

CREATE TABLE IF NOT EXISTS votes
(
    `id`                        INT(11) PRIMARY KEY,
    `id_survey`                 INT(11),
    `option`                    DATETIME,
    `availability`              VARCHAR(65),
    `name`                      VARCHAR(65)
);

INSERT INTO surveys VALUES (1, 'Mon premier sondage',  'Mon tout premier sondage !', true, '2020-11-06 12:35:45');

INSERT INTO comments VALUES (1, 1,  'Comptez sur moi :)');

INSERT INTO votes VALUES (1, 1,  '2020-11-08 12:00:00', 'available', 'Alexandre');
INSERT INTO votes VALUES (2, 1,  '2020-11-08 12:00:00', 'available', 'Clément');
INSERT INTO votes VALUES (3, 1,  '2020-11-08 12:00:00', 'unknown', 'Liam');
INSERT INTO votes VALUES (4, 1,  '2020-11-08 12:00:00', 'unavailable', 'Vincent');

INSERT INTO votes VALUES (5, 1,  '2020-11-15 12:00:00', 'unknown', 'Alexandre');
INSERT INTO votes VALUES (6, 1,  '2020-11-15 12:00:00', 'unknown', 'Clément');
INSERT INTO votes VALUES (7, 1,  '2020-11-15 12:00:00', 'unknown', 'Liam');
INSERT INTO votes VALUES (8, 1,  '2020-11-15 12:00:00', 'unavailable', 'Vincent');