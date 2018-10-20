CREATE DATABASE  nutricion;
USE  nutricion;


CREATE TABLE paciente(idPaciente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(35),correo VARCHAR(20),contrasenia VARCHAR(15),telefono VARCHAR(15),fechaNacimiento  VARCHAR(15),sexo VARCHAR(10),alergias VARCHAR(30),estatus VARCHAR(20));
CREATE TABLE domicilio_paciente(idPaciente INT NOT NULL PRIMARY KEY,calle VARCHAR(20),colonia VARCHAR(20),numero INT,cp VARCHAR(15),FOREIGN KEY(idPaciente) REFERENCES paciente(idpaciente));
CREATE TABLE estatus(idPaciente INT NOT NULL PRIMARY KEY , estatus VARCHAR(20),FOREIGN KEY(idPaciente) REFERENCES paciente(idPaciente));

CREATE TABLE cita(idCita INT NOT NULL PRIMARY KEY,idPaciente INT NOT NULL, idMedico INT NOT NULL,fecha_hora DATETIME, observaciones VARCHAR(50),FOREIGN KEY(idPaciente) REFERENCES paciente(idPaciente),FOREIGN KEY(idMedico) REFERENCES medico(idMedico));

CREATE TABLE medico(idMedico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,npersonal INT,nombre VARCHAR(35),correo VARCHAR(20),contrasenia VARCHAR(15),telefono VARCHAR(15),fechaNacimiento  VARCHAR(15),sexo VARCHAR(10));
CREATE TABLE domicilio_medico(idMedico INT NOT NULL PRIMARY KEY,calle VARCHAR(20),colonia VARCHAR(20),numero INT,cp VARCHAR(15),FOREIGN KEY(idMedico) REFERENCES medico(idMedico));

CREATE TABLE dieta(idDieta INT NOT NULL PRIMARY KEY AUTO_INCREMENT,idMedico INT NOT NULL,nombre VARCHAR(35),totalCalorias DOUBLE,alimento VARCHAR(20), FOREIGN KEY(idMedico) REFERENCES medico(idMedico));
CREATE TABLE horario_dieta(idHorario INT NOT NULL PRIMARY KEY AUTO_INCREMENT, desayuno VARCHAR(100), medioDia VARCHAR(100),comida VARCHAR(100), cena VARCHAR(100),fechaCreacion DATETIME);
CREATE TABLE alimento(idAlimento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(25),calorias DOUBLE,porcion VARCHAR(25));
CREATE TABLE dietaAlimento(idDieta INT NOT NULL PRIMARY KEY,idAlimento INT NOT NULL,FOREIGN KEY(idDieta) REFERENCES dieta(idDieta),cantidad INT,FOREIGN KEY(idAlimento) REFERENCES alimento(idAlimento));

CREATE TABLE porciones(idPorcion INT NOT NULL PRIMARY KEY AUTO_INCREMENT, gramos VARCHAR(20), piezas VARCHAR(20));

CREATE TABLE Medicion(idMedicion INT NOT NULL PRIMARY KEY AUTO_INCREMENT,idConsulta INT NOT NULL,talla VARCHAR(15),peso VARCHAR(15),estatura FLOAT,imc VARCHAR(15),FOREIGN KEY(idConsulta) REFERENCES consulta(idConsulta));
CREATE TABLE consulta(idConsulta  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,idPaciente INT NOT NULL, idMedico  INT NOT NULL,idDieta INT NOT NULL,dieta VARCHAR(20),observaciones VARCHAR(40),FOREIGN KEY (idPaciente) REFERENCES paciente(idPaciente),FOREIGN KEY (idMedico) REFERENCES medico(idMedico),FOREIGN KEY(idDieta) REFERENCES dieta(idDieta));