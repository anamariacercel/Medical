CREATE TABLE `doctors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `specialisation` varchar(45) NOT NULL,
  `level_training` int NOT NULL,
  `university_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `medical`.`doctors`
(
`first_name`,
`last_name`,
`specialisation`,
`level_training`,
`university_name`)
VALUES
(
'Maria',
'Paraschiv',
'Medic de familie' ,
 4,
'Carol Davila');
INSERT INTO `medical`.`doctors`
(
`first_name`,
`last_name`,
`specialisation`,
`level_training`,
`university_name`)
VALUES
(
'Corina',
'Preda',
'Medic ginecolog' ,
8,
'Univ din Craiova');




CREATE TABLE `medical`.`medicalclinics` (
  `id` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `district` INT NOT NULL,
  `street_name` VARCHAR(45) NOT NULL,
  `street_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );
INSERT INTO `medical`.`medicalclinics`
(`id`,
`city`,
`district`,
`street_name`,
`street_number`)
VALUES
(231,
'Bucuresti',
 2,
'Iuliu Maniu',
'2B');
INSERT INTO `medical`.`medicalclinics`
(`id`,
`city`,
`district`,
`street_name`,
`street_number`)
VALUES
(21,
'Craiova',
1,
'Dezrobirii',
'30');




CREATE TABLE `pills` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `prospect` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `medical`.`pills`
(`id`,
`name`,
`prospect`)
VALUES
(3432,
'Paracetamol',
'administrare orala');
INSERT INTO `medical`.`pills`
(`id`,
`name`,
`prospect`)
VALUES
(3022,
'Nurofen',
'administrare orala');


CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(13) NOT NULL,
  `email` varchar(45) NOT NULL,
  `CNP` varchar(45) NOT NULL,
  `blood_type` varchar(10) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `medical`.`patients`
(
`CNP`,
`name`,
`email`,
`age`,
`sex`,
`blood_type`
)
VALUES
(
'23242535',
'Ana Cercel',
'anamaria2410@gmail.com',
23,
'femeie',
'0');

INSERT INTO `medical`.`patients`
(
`CNP`,
`name`,
`email`,
`age`,
`sex`,
`blood_type`
)
VALUES
(
'204957',
'Ilinca Priboi',
'ilinca@gmail.com',
21,
'femeie',
'B');

INSERT INTO `medical`.`patients`
(
`CNP`,
`name`,
`email`,
`age`,
`sex`,
`blood_type`
)
VALUES
(
'23456',
'Morariu Alexa',
'alexandra@gmail.com',
19,
'femeie',
'0');

INSERT INTO `medical`.`patients`
(
`CNP`,
`name`,
`email`,
`age`,
`sex`,
`blood_type`
)
VALUES
(
'09876543',
'Costi Drago',
'costin@gmail.com',
29,
'barbat',
'0');

