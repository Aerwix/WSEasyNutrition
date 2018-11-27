## Alimentos
INSERT INTO `nutricion`.`alimento` (`idAlimento`, `nombreAlimento`, `calorias`, `idPorcion`) VALUES ('1', 'Manzana', '20', '1');
INSERT INTO `nutricion`.`alimento` (`idAlimento`, `nombreAlimento`, `calorias`, `idPorcion`) VALUES ('2', 'Pera', '50', '1');
INSERT INTO `nutricion`.`alimento` (`idAlimento`, `nombreAlimento`, `calorias`, `idPorcion`) VALUES ('3', 'Uva', '300', '1');

## Citas
INSERT INTO `nutricion`.`cita` (`idCita`, `idPaciente`, `idMedico`, `fecha`, `hora`) VALUES ('1', '1', '1', '2018-11-28', '10:00');
INSERT INTO `nutricion`.`cita` (`idCita`, `idPaciente`, `idMedico`, `fecha`, `hora`) VALUES ('2', '1', '2', '2018-11-28', '11:00');
INSERT INTO `nutricion`.`cita` (`idCita`, `idPaciente`, `idMedico`, `fecha`, `hora`) VALUES ('3', '2', '1', '2018-11-28', '12:00');
INSERT INTO `nutricion`.`cita` (`idCita`, `idPaciente`, `idMedico`, `fecha`, `hora`) VALUES ('4', '2', '2', '2018-11-28', '13:00');

## Consultas
INSERT INTO `nutricion`.`consulta` (`idConsulta`, `idPaciente`, `idMedico`, `idDieta`, `observaciones`, `fechaConsulta`) VALUES ('1', '1', '1', '1', 'Paciente tiene azúcar.', '2018-11-14');
INSERT INTO `nutricion`.`consulta` (`idConsulta`, `idPaciente`, `idMedico`, `idDieta`, `observaciones`, `fechaConsulta`) VALUES ('2', '2', '1', '2', 'Tiene Gastroenteritis', '2018-11-07');

## Dietas
INSERT INTO `nutricion`.`dieta` (`idDieta`, `nombreDieta`, `totalCalorias`, `idMedico`) VALUES ('1', 'Sin Azucar', '2000', '1');
INSERT INTO `nutricion`.`dieta` (`idDieta`, `nombreDieta`, `totalCalorias`, `idMedico`) VALUES ('2', 'Problemas Estomacales', '1500', '1');

## Dieta Alimento
INSERT INTO `nutricion`.`dieta_alimento` (`idDietaAlimento`, `idAlimento`, `cantidad`, `idDieta`, `idHorario`) VALUES ('1', '1', '1', '1', '1');
INSERT INTO `nutricion`.`dieta_alimento` (`idDietaAlimento`, `idAlimento`, `cantidad`, `idDieta`, `idHorario`) VALUES ('2', '2', '2', '2', '1');

## Estatus
INSERT INTO `nutricion`.`estatus` (`idEstatus`, `nombre`) VALUES ('1', 'Activo');
INSERT INTO `nutricion`.`estatus` (`idEstatus`, `nombre`) VALUES ('2', 'Inactivo');

## horario_Dietas
INSERT INTO `nutricion`.`horario_dieta` (`idHorario`, `horaComida`) VALUES ('1', 'Desayuno');
INSERT INTO `nutricion`.`horario_dieta` (`idHorario`, `horaComida`) VALUES ('2', 'Comida');
INSERT INTO `nutricion`.`horario_dieta` (`idHorario`, `horaComida`) VALUES ('3', 'Cena');

## Medico
INSERT INTO `nutricion`.`medico` (`idMedico`, `nombre`, `apellidoMaterno`, `apellidoPaterno`, `direccion`, `correo`, `password`, `telefono`, `fechaNacimiento`, `sexo`) VALUES ('1', 'Usuario', 'Medico', 'Uno', 'Agua Clara # 25', 'medico@dominio.com', '123', '2283343487', '1992-11-13', 'H');
INSERT INTO `nutricion`.`medico` (`idMedico`, `nombre`, `apellidoMaterno`, `apellidoPaterno`, `direccion`, `correo`, `password`, `telefono`, `fechaNacimiento`, `sexo`) VALUES ('2', 'Usuario', 'Medico', 'Dos', 'Argentina # 50', 'medico@dominio.com', '123', '2283343487', '1990-01-08', 'M');

## MedidasConsulta
INSERT INTO `nutricion`.`medidasconsulta` (`idMedicion`, `talla`, `peso`, `estatura`, `imc`, `idConsulta`) VALUES ('1', 'Grande', '80', '1.75', '1.5 %', '1');
INSERT INTO `nutricion`.`medidasconsulta` (`idMedicion`, `talla`, `peso`, `estatura`, `imc`, `idConsulta`) VALUES ('2', 'Grande', '70', '1.75', '1.5 %', '1');

## Paciente
INSERT INTO `nutricion`.`paciente` (`idPaciente`, `nombre`, `apellidoMaterno`, `apellidoPaterno`, `direccion`, `correo`, `password`, `telefono`, `fechaNacimiento`, `sexo`, `idEstatus`) VALUES ('1', 'Usuario', 'Paciente', 'Uno', 'Unknown', 'paciente@dominio.com', '123', '2283343487', '1995-11-06', 'H', '1');
INSERT INTO `nutricion`.`paciente` (`idPaciente`, `nombre`, `apellidoMaterno`, `apellidoPaterno`, `direccion`, `correo`, `password`, `telefono`, `fechaNacimiento`, `sexo`, `idEstatus`) VALUES ('2', 'Usuario', 'Paciente', 'Dos', 'Unknown', 'pacienteDos@dominio.com', '123', '2283343487', '1995-11-06', 'M', '1'); 

## Porcion
INSERT INTO `nutricion`.`porcion` (`idPorcion`, `Tipo`) VALUES ('1', 'Gramos');
INSERT INTO `nutricion`.`porcion` (`idPorcion`, `Tipo`) VALUES ('2', 'Mililitros');