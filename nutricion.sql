CREATE DATABASE  nutricion;
USE  nutricion;


CREATE TABLE pacientes(idPaciente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(35),fechaNacimiento  VARCHAR(15),sexo VARCHAR(10),alergias VARCHAR(30));
CREATE TABLE telefono_paciente(idPaciente INT NOT NULL PRIMARY KEY, telefono VARCHAR(15),FOREIGN KEY(idPaciente) REFERENCES pacientes(idpaciente));
CREATE TABLE correo_paciente(idPaciente INT NOT NULL PRIMARY KEY, correo VARCHAR(20),contrasenia VARCHAR(15),FOREIGN KEY(idPaciente) REFERENCES pacientes(idpaciente));
CREATE TABLE domicilio_paciente(idPaciente INT NOT NULL PRIMARY KEY,calle VARCHAR(20),colonia VARCHAR(20),numero INT,cp VARCHAR(15),FOREIGN KEY(idPaciente) REFERENCES pacientes(idpaciente));

CREATE TABLE citas(idCita INT NOT NULL PRIMARY KEY,idPaciente INT NOT NULL,fecha_hora DATETIME,FOREIGN KEY(idPaciente) REFERENCES pacientes(idPaciente));

CREATE TABLE medicos(idMedico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,npersonal INT,nombre VARCHAR(35),fechaNacimiento  VARCHAR(15),sexo VARCHAR(10));
CREATE TABLE telefono_medicos(idMedico INT NOT NULL PRIMARY KEY, telefono VARCHAR(15),FOREIGN KEY(idMedico) REFERENCES medicos(idMedico));
CREATE TABLE correo_medico(idMedico INT NOT NULL PRIMARY KEY, correo VARCHAR(20),contrasenia VARCHAR(15),FOREIGN KEY(idMedico) REFERENCES medicos(idMedico));
CREATE TABLE domicilio_medico(idMedico INT NOT NULL PRIMARY KEY,calle VARCHAR(20),colonia VARCHAR(20),numero INT,cp VARCHAR(15),FOREIGN KEY(idMedico) REFERENCES medicos(idMedico));

CREATE TABLE dietas(idDieta INT NOT NULL PRIMARY KEY AUTO_INCREMENT,idMedico INT NOT NULL,nombre VARCHAR(35),horario VARCHAR(20),totalCalorias DOUBLE,alimento VARCHAR(20),cantidad INT,FOREIGN KEY(idMedico) REFERENCES medicos(idMedico));
CREATE TABLE alimentos(idAlimento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(25),calorias DOUBLE,porcion VARCHAR(25));
CREATE TABLE dietaAlimentos(idDieta INT NOT NULL PRIMARY KEY,idAlimento INT NOT NULL,FOREIGN KEY(idDieta) REFERENCES dietas(idDieta),FOREIGN KEY(idAlimento) REFERENCES alimentos(idAlimento));


CREATE TABLE consulta_datos(idPaciente INT NOT NULL PRIMARY KEY,talla VARCHAR(15),peso VARCHAR(15),estatura FLOAT,imc VARCHAR(15));
CREATE TABLE consultas(FolioConsulta  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,idPaciente INT NOT NULL, idMedico  INT NOT NULL,idDieta INT NOT NULL,dieta VARCHAR(20),observaciones VARCHAR(40),FOREIGN KEY (idPaciente) REFERENCES pacientes(idPaciente),FOREIGN KEY (idMedico) REFERENCES medicos(idMedico),FOREIGN KEY(idDieta) REFERENCES dietas(idDieta));
