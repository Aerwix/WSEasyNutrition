# WSEasyNutrition

Acuerdense de cambiar el puerto en las URLs.

## Total de Servicios
Alimentos | Citas | Consultas | Login |
--------- | ----- | ----------| ----- |
6         |   2   |     0     |   1   |

## Lista de Servicios Creados

### Login de Usuarios
   1. 
      1. Servicio: _LoginMedico_
      2. Desc: Recupera todos los datos de un usuario si es correcto.
      3. URL: http://localhost:8084/WSEN/api/auth/LoginMedico
      
   1. 
      1. Servicio: _LoginPaciente_
      2. Desc: Recupera todos los datos de un usuario si es correcto.
      3. URL: http://localhost:8084/WSEN/api/auth/LoginPaciente

### Servicio de Alimentos
   1. 
      1. Servicio: _getAllAlimentos_
      2. Desc: Recupera todos los alimentos de la base de datos.
      3. URL: http://localhost:8084/WSEN/api/alimentos/getAllAlimentos
      
   2. Servicio: _getAlimentoById_
      1. Desc: Recupera 1 solo alimento por el ID.
      2. URL: http://localhost:8084/WSEN/api/alimentos/getAlimentoById/idAlimento
      3. Ej: http://localhost:8084/WSEN/api/alimentos/getAlimentoById/2

   3. Servicio: _getAlimentoByName_
      1. Desc: Recupera 1 solo alimento por el nombre.
      2. URL: http://localhost:8084/WSEN/api/alimentos/getAlimentoByName/nombre
      3. Ej : http://localhost:8084/WSEN/api/alimentos/getAlimentoByName/Platano

   4. Servicio: _nuevoAlimento_
      1. Desc: Agrega un alimento al registro.
      2. URL: http://localhost:8084/WSEN/api/alimentos/nuevoAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"

   5. Servicio: _actualizarAlimento_
      1. Desc: Modifica un alimento.
      2. URL: http://localhost:8084/WSEN/api/alimentos/actualizarAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"

   6. Servicio: _eliminarAlimento_
      1. Desc: Elimina un alimento del registro, utilizando como parametro el ID.
      2. URL: http://localhost:8084/WSEN/api/alimentos/eliminarAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"
      
### Servicios de Citas
   1. Servicio: _nuevaCita_
      1. Desc: Agrega una cita al registro.
      2. URL: http://localhost:8084/WSEN/api/cambiarPorOtro/nuevaCita
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"
      
   2. Servicio: _actualizarCita_
      1. Desc: Modifica una cita, solicitando el idCita. (Posible modificación incluyendo la fecha + el id)
      2. URL: http://localhost:8084/WSEN/api/cambiarPorOtro/actualizarAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"

   3. Servicio: _eliminarCita_
      1. Desc: Elimina una cita del registro, utilizando como parametro el idCita.
      2. URL: http://localhost:8084/WSEN/api/cambiarPorOtro/eliminarAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"
