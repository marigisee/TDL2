
-- Database: mundial_futbol_2022


CREATE DATABASE `mundial_futbol_2022`;
USE `mundial_futbol_2022`;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `idpais` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `idioma` varchar(45) NOT NULL,
  PRIMARY KEY (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Table structure for table `futbolista`
--

DROP TABLE IF EXISTS `futbolista`;
CREATE TABLE `futbolista` (
  `idfutbolista` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `docIdentidad` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `idpais` int NOT NULL,
  PRIMARY KEY (`idfutbolista`),
  KEY `fk_jugador_pais_idx` (`idpais`),
  CONSTRAINT `fk_jugador_pais` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;

CREATE TABLE `sede` (
  `idsede` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `capacidad` int NOT NULL,
  `idpais` int NOT NULL,
  PRIMARY KEY (`idsede`),
  KEY `fk_sede_pais_idx` (`idpais`),
  CONSTRAINT `fk_sede_pais` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

----- INSERT DATA TEST-----

INSERT INTO `pais` (`nombre`, `idioma`)
VALUES
    ('Argentina', 'Español'),
    ('Brasil', 'Portugués'),
    ('Alemania', 'Alemán'),
    ('Francia', 'Francés'),
    ('Italia', 'Italiano');

INSERT INTO futbolista (nombre, apellido, docIdentidad, telefono, email, idpais)
VALUES
    ('Lionel', 'Messi', '123456789', '123-456-7890', 'lionel@messi.com', 1),
    ('Cristiano', 'Ronaldo', '987654321', '987-654-3210', 'cristiano@ronaldo.com', 2);

INSERT INTO sede (nombre, capacidad, idpais)
VALUES
    ('Estadio Maracaná', 100000, 2),
    ('Estadio Monumental', 80000, 1);
