-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;

DROP TABLE `consulta`;


DROP TABLE `dieta_alimento`;


DROP TABLE `dieta`;


DROP TABLE `cita`;


DROP TABLE `alimento`;


DROP TABLE `paciente`;


DROP TABLE `medidasConsulta`;


DROP TABLE `horario_dieta`;


DROP TABLE `tipo_porcion`;


DROP TABLE `estatus`;


DROP TABLE `medico`;



-- ************************************** `medidasConsulta`

CREATE TABLE `medidasConsulta`
(
 `idMedicion` INTEGER NOT NULL ,
 `talla`      VARCHAR(45) NOT NULL ,
 `peso`       VARCHAR(45) NOT NULL ,
 `estatura`   VARCHAR(45) NOT NULL ,
 `imc`        VARCHAR(45) NOT NULL ,

PRIMARY KEY (`idMedicion`)
);






-- ************************************** `horario_dieta`

CREATE TABLE `horario_dieta`
(
 `idHorario`  INTEGER NOT NULL ,
 `horaComida` VARCHAR(45) NOT NULL ,

PRIMARY KEY (`idHorario`)
);






-- ************************************** `tipo_porcion`

CREATE TABLE `tipo_porcion`
(
 `idPorcion` INTEGER NOT NULL ,
 `Tipo`      VARCHAR(45) NOT NULL ,

PRIMARY KEY (`idPorcion`)
);






-- ************************************** `estatus`

CREATE TABLE `estatus`
(
 `idEstatus` INTEGER NOT NULL ,
 `nombre`    VARCHAR(45) NOT NULL ,

PRIMARY KEY (`idEstatus`)
);






-- ************************************** `medico`

CREATE TABLE `medico`
(
 `idMedico`        INTEGER NOT NULL ,
 `nombre`          VARCHAR(45) NOT NULL ,
 `apellidoMaterno` VARCHAR(45) NOT NULL ,
 `apellidoPaterno` VARCHAR(45) NOT NULL ,
 `direccion`       VARCHAR(100) NOT NULL ,
 `correo`          VARCHAR(45) NOT NULL ,
 `password`        VARCHAR(45) NOT NULL ,
 `telefono`        VARCHAR(45) NOT NULL ,
 `fechaNacimiento` DATE NOT NULL ,
 `sexo`            VARCHAR(45) NOT NULL ,

PRIMARY KEY (`idMedico`)
);






-- ************************************** `alimento`

CREATE TABLE `alimento`
(
 `idAlimento`     INTEGER NOT NULL ,
 `nombreAlimento` VARCHAR(45) NOT NULL ,
 `calorias`       DOUBLE NOT NULL ,
 `idPorcion`      INTEGER NOT NULL ,

PRIMARY KEY (`idAlimento`),
KEY `fkIdx_105` (`idPorcion`),
CONSTRAINT `FK_105` FOREIGN KEY `fkIdx_105` (`idPorcion`) REFERENCES `tipo_porcion` (`idPorcion`)
);






-- ************************************** `paciente`

CREATE TABLE `paciente`
(
 `idPaciente`      INTEGER NOT NULL ,
 `nombre`          VARCHAR(45) NOT NULL ,
 `apellidoMaterno` VARCHAR(45) NOT NULL ,
 `apellidoPaterno` VARCHAR(45) NOT NULL ,
 `direccion`       VARCHAR(100) NOT NULL ,
 `correo`          VARCHAR(45) NOT NULL ,
 `password`        VARCHAR(45) NOT NULL ,
 `telefono`        VARCHAR(45) NOT NULL ,
 `fechaNacimiento` DATE NOT NULL ,
 `sexo`            VARCHAR(45) NOT NULL ,
 `idEstatus`       INTEGER NOT NULL ,

PRIMARY KEY (`idPaciente`),
KEY `fkIdx_30` (`idEstatus`),
CONSTRAINT `FK_30` FOREIGN KEY `fkIdx_30` (`idEstatus`) REFERENCES `estatus` (`idEstatus`)
);






-- ************************************** `cita`

CREATE TABLE `cita`
(
 `idCita`     INTEGER NOT NULL ,
 `idPaciente` INTEGER NOT NULL ,
 `idMedico`   INTEGER NOT NULL ,
 `fecha`      DATE NOT NULL ,
 `hora`       VARCHAR(45) NOT NULL ,

PRIMARY KEY (`idCita`),
KEY `fkIdx_36` (`idPaciente`),
CONSTRAINT `FK_36` FOREIGN KEY `fkIdx_36` (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
KEY `fkIdx_39` (`idMedico`),
CONSTRAINT `FK_39` FOREIGN KEY `fkIdx_39` (`idMedico`) REFERENCES `medico` (`idMedico`)
);






-- ************************************** `dieta`

CREATE TABLE `dieta`
(
 `idDieta`         INTEGER NOT NULL ,
 `nombreDieta`     VARCHAR(45) NOT NULL ,
 `totalCalorias`   DOUBLE NOT NULL ,
 `idMedico`        INTEGER NOT NULL ,
 `idDietaAlimento` INTEGER NOT NULL ,

PRIMARY KEY (`idDieta`),
KEY `fkIdx_108` (`idMedico`),
CONSTRAINT `FK_108` FOREIGN KEY `fkIdx_108` (`idMedico`) REFERENCES `medico` (`idMedico`),
KEY `fkIdx_114` (`idDietaAlimento`),
CONSTRAINT `FK_114` FOREIGN KEY `fkIdx_114` (`idDietaAlimento`) REFERENCES `dieta_alimento` (`idDietaAlimento`)
);






-- ************************************** `consulta`

CREATE TABLE `consulta`
(
 `idConsulta`    INTEGER NOT NULL ,
 `idPaciente`    INTEGER NOT NULL ,
 `idMedico`      INTEGER NOT NULL ,
 `idDieta`       INTEGER NOT NULL ,
 `observaciones` VARCHAR(100) NOT NULL ,
 `fechaConsulta` DATE NOT NULL ,
 `idMedicion`    INTEGER NOT NULL ,

PRIMARY KEY (`idConsulta`),
KEY `fkIdx_84` (`idPaciente`),
CONSTRAINT `FK_84` FOREIGN KEY `fkIdx_84` (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
KEY `fkIdx_87` (`idMedico`),
CONSTRAINT `FK_87` FOREIGN KEY `fkIdx_87` (`idMedico`) REFERENCES `medico` (`idMedico`),
KEY `fkIdx_90` (`idDieta`),
CONSTRAINT `FK_90` FOREIGN KEY `fkIdx_90` (`idDieta`) REFERENCES `dieta` (`idDieta`),
KEY `fkIdx_102` (`idMedicion`),
CONSTRAINT `FK_102` FOREIGN KEY `fkIdx_102` (`idMedicion`) REFERENCES `medidasConsulta` (`idMedicion`)
);






-- ************************************** `dieta_alimento`

CREATE TABLE `dieta_alimento`
(
 `idDietaAlimento` INTEGER NOT NULL ,
 `idAlimento`      INTEGER NOT NULL ,
 `cantidad`         NOT NULL ,
 `idDieta`         INTEGER NOT NULL ,
 `idHorario`       INTEGER NOT NULL ,

PRIMARY KEY (`idDietaAlimento`),
KEY `fkIdx_57` (`idAlimento`),
CONSTRAINT `FK_57` FOREIGN KEY `fkIdx_57` (`idAlimento`) REFERENCES `alimento` (`idAlimento`),
KEY `fkIdx_71` (`idDieta`),
CONSTRAINT `FK_71` FOREIGN KEY `fkIdx_71` (`idDieta`) REFERENCES `dieta` (`idDieta`),
KEY `fkIdx_78` (`idHorario`),
CONSTRAINT `FK_78` FOREIGN KEY `fkIdx_78` (`idHorario`) REFERENCES `horario_dieta` (`idHorario`)
);





