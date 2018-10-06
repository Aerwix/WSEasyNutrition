CREATE DATABASE  nutricion;
USE  nutricion;


CREATE TABLE pacientes(IdPaciente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(35),fechaNacimiento  VARCHAR(15),sexo VARCHAR(10),alergias VARCHAR(30));
CREATE TABLE telefono_paciente(IdPaciente INT NOT NULL PRIMARY KEY, telefono VARCHAR(15),FOREIGN KEY(IdPaciente) REFERENCES pacientes(Idpaciente));
CREATE TABLE correo_paciente(IdPaciente INT NOT NULL PRIMARY KEY, correo VARCHAR(20),contrasenia VARCHAR(15),FOREIGN KEY(IdPaciente) REFERENCES pacientes(Idpaciente));
CREATE TABLE domicilio_paciente(IdPaciente INT NOT NULL PRIMARY KEY,calle VARCHAR(20),colonia VARCHAR(20),numero INT,cp VARCHAR(15),FOREIGN KEY(IdPaciente) REFERENCES pacientes(Idpaciente));

CREATE TABLE citas(IdCita INT NOT NULL PRIMARY KEY,IdPaciente INT NOT NULL,fecha_hora DATETIME,FOREIGN KEY(IdPaciente) REFERENCES pacientes(IdPaciente));

CREATE TABLE medicos(IdMedico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,npersonal INT,nombre VARCHAR(35),fechaNacimiento  VARCHAR(15),sexo VARCHAR(10));
CREATE TABLE telefono_medicos(IdMedico INT NOT NULL PRIMARY KEY, telefono VARCHAR(15),FOREIGN KEY(IdMedico) REFERENCES medicos(IdMedico));
CREATE TABLE correo_medico(IdMedico INT NOT NULL PRIMARY KEY, correo VARCHAR(20),contrasenia VARCHAR(15),FOREIGN KEY(IdMedico) REFERENCES medicos(IdMedico));
CREATE TABLE domicilio_medico(IdMedico INT NOT NULL PRIMARY KEY,calle VARCHAR(20),colonia VARCHAR(20),numero INT,cp VARCHAR(15),FOREIGN KEY(IdMedico) REFERENCES medicos(IdMedico));

CREATE TABLE dietas(IdDieta INT NOT NULL PRIMARY KEY AUTO_INCREMENT,IdMedico INT NOT NULL,nombre VARCHAR(35),horario VARCHAR(20),totalCalorias DOUBLE,alimento VARCHAR(20),cantidad INT,FOREIGN KEY(IdMedico) REFERENCES medicos(IdMedico));
CREATE TABLE alimentos(IdAlimento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(25),calorias DOUBLE,porcion VARCHAR(25));
CREATE TABLE dietaAlimentos(IdDieta INT NOT NULL PRIMARY KEY,IdAlimento INT NOT NULL,FOREIGN KEY(IdDieta) REFERENCES dietas(IdDieta),FOREIGN KEY(IdAlimento) REFERENCES alimentos(IdAlimento));


CREATE TABLE consulta_datos(IdPaciente INT NOT NULL PRIMARY KEY,talla VARCHAR(15),peso VARCHAR(15),estatura FLOAT,imc VARCHAR(15));
CREATE TABLE consultas(FolioConsulta  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,IdPaciente INT NOT NULL, IdMedico  INT NOT NULL,IdDieta INT NOT NULL,dieta VARCHAR(20),observaciones VARCHAR(40),FOREIGN KEY (IdPaciente) REFERENCES pacientes(IdPaciente),FOREIGN KEY (IdMedico) REFERENCES medicos(IdMedico),FOREIGN KEY(IdDieta) REFERENCES dietas(IdDieta));


