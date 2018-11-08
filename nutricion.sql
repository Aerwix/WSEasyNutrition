-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `porcion`

CREATE TABLE `porcion`
(
 `idPorcion` integer NOT NULL AUTO_INCREMENT ,
 `Tipo`      varchar(45) NOT NULL ,
PRIMARY KEY (`idPorcion`)
);






-- ************************************** `medico`

CREATE TABLE `medico`
(
 `idMedico`        integer NOT NULL AUTO_INCREMENT ,
 `nombre`          varchar(45) NOT NULL ,
 `apellidoMaterno` varchar(45) NOT NULL ,
 `apellidoPaterno` varchar(45) NOT NULL ,
 `direccion`       varchar(100) NOT NULL ,
 `correo`          varchar(45) NOT NULL ,
 `password`        varchar(45) NOT NULL ,
 `telefono`        varchar(45) NOT NULL ,
 `fechaNacimiento` date NOT NULL ,
 `sexo`            varchar(45) NOT NULL ,
PRIMARY KEY (`idMedico`)
);






-- ************************************** `horario_dieta`

CREATE TABLE `horario_dieta`
(
 `idHorario`  integer NOT NULL AUTO_INCREMENT ,
 `horaComida` varchar(45) NOT NULL ,
PRIMARY KEY (`idHorario`)
);






-- ************************************** `estatus`

CREATE TABLE `estatus`
(
 `idEstatus` integer NOT NULL AUTO_INCREMENT ,
 `nombre`    varchar(45) NOT NULL ,
PRIMARY KEY (`idEstatus`)
);






-- ************************************** `paciente`

CREATE TABLE `paciente`
(
 `idPaciente`      integer NOT NULL AUTO_INCREMENT ,
 `nombre`          varchar(45) NOT NULL ,
 `apellidoMaterno` varchar(45) NOT NULL ,
 `apellidoPaterno` varchar(45) NOT NULL ,
 `direccion`       varchar(100) NOT NULL ,
 `correo`          varchar(45) NOT NULL ,
 `password`        varchar(45) NOT NULL ,
 `telefono`        varchar(45) NOT NULL ,
 `fechaNacimiento` date NOT NULL ,
 `sexo`            varchar(45) NOT NULL ,
 `idEstatus`       integer NOT NULL ,
PRIMARY KEY (`idPaciente`),
KEY `fkIdx_30` (`idEstatus`),
CONSTRAINT `FK_30` FOREIGN KEY `fkIdx_30` (`idEstatus`) REFERENCES `estatus` (`idEstatus`)
);






-- ************************************** `dieta`

CREATE TABLE `dieta`
(
 `idDieta`       integer NOT NULL AUTO_INCREMENT ,
 `nombreDieta`   varchar(45) NOT NULL ,
 `totalCalorias` double NOT NULL ,
 `idMedico`      integer NOT NULL ,
PRIMARY KEY (`idDieta`),
KEY `fkIdx_108` (`idMedico`),
CONSTRAINT `FK_108` FOREIGN KEY `fkIdx_108` (`idMedico`) REFERENCES `medico` (`idMedico`)
);






-- ************************************** `alimento`

CREATE TABLE `alimento`
(
 `idAlimento`     integer NOT NULL AUTO_INCREMENT ,
 `nombreAlimento` varchar(45) NOT NULL ,
 `calorias`       double NOT NULL ,
 `idPorcion`      integer NOT NULL ,
PRIMARY KEY (`idAlimento`),
KEY `fkIdx_105` (`idPorcion`),
CONSTRAINT `FK_105` FOREIGN KEY `fkIdx_105` (`idPorcion`) REFERENCES `porcion` (`idPorcion`)
);






-- ************************************** `dieta_alimento`

CREATE TABLE `dieta_alimento`
(
 `idDietaAlimento` integer NOT NULL AUTO_INCREMENT ,
 `idAlimento`      integer NOT NULL ,
 `cantidad`        double NOT NULL ,
 `idDieta`         integer NOT NULL ,
 `idHorario`       integer NOT NULL ,
PRIMARY KEY (`idDietaAlimento`),
KEY `fkIdx_57` (`idAlimento`),
CONSTRAINT `FK_57` FOREIGN KEY `fkIdx_57` (`idAlimento`) REFERENCES `alimento` (`idAlimento`),
KEY `fkIdx_71` (`idDieta`),
CONSTRAINT `FK_71` FOREIGN KEY `fkIdx_71` (`idDieta`) REFERENCES `dieta` (`idDieta`),
KEY `fkIdx_78` (`idHorario`),
CONSTRAINT `FK_78` FOREIGN KEY `fkIdx_78` (`idHorario`) REFERENCES `horario_dieta` (`idHorario`)
);






-- ************************************** `consulta`

CREATE TABLE `consulta`
(
 `idConsulta`    integer NOT NULL AUTO_INCREMENT ,
 `idPaciente`    integer NOT NULL ,
 `idMedico`      integer NOT NULL ,
 `idDieta`       integer NOT NULL ,
 `observaciones` varchar(100) NOT NULL ,
 `fechaConsulta` date NOT NULL ,
PRIMARY KEY (`idConsulta`),
KEY `fkIdx_84` (`idPaciente`),
CONSTRAINT `FK_84` FOREIGN KEY `fkIdx_84` (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
KEY `fkIdx_87` (`idMedico`),
CONSTRAINT `FK_87` FOREIGN KEY `fkIdx_87` (`idMedico`) REFERENCES `medico` (`idMedico`),
KEY `fkIdx_90` (`idDieta`),
CONSTRAINT `FK_90` FOREIGN KEY `fkIdx_90` (`idDieta`) REFERENCES `dieta` (`idDieta`)
);






-- ************************************** `cita`

CREATE TABLE `cita`
(
 `idCita`     integer NOT NULL AUTO_INCREMENT ,
 `idPaciente` integer NOT NULL ,
 `idMedico`   integer NOT NULL ,
 `fecha`      date NOT NULL ,
 `hora`       varchar(45) NOT NULL ,
PRIMARY KEY (`idCita`),
KEY `fkIdx_36` (`idPaciente`),
CONSTRAINT `FK_36` FOREIGN KEY `fkIdx_36` (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
KEY `fkIdx_39` (`idMedico`),
CONSTRAINT `FK_39` FOREIGN KEY `fkIdx_39` (`idMedico`) REFERENCES `medico` (`idMedico`)
);






-- ************************************** `medidasConsulta`

CREATE TABLE `medidasConsulta`
(
 `idMedicion` integer NOT NULL AUTO_INCREMENT ,
 `talla`      varchar(45) NOT NULL ,
 `peso`       varchar(45) NOT NULL ,
 `estatura`   varchar(45) NOT NULL ,
 `imc`        varchar(45) NOT NULL ,
 `idConsulta` integer NOT NULL ,
PRIMARY KEY (`idMedicion`),
KEY `fkIdx_117` (`idConsulta`),
CONSTRAINT `FK_117` FOREIGN KEY `fkIdx_117` (`idConsulta`) REFERENCES `consulta` (`idConsulta`)
);





