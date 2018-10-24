# WSEasyNutrition

Acuerdense de cambiar el puerto en las URLs.

## Total de Servicios
Alimentos | Citas | Consultas |
--------- | ----- | ----------|
1         |   0   |     0     |

## Lista de Servicios Creados
### Servicio de Alimentos
   1. 
      1. Servicio: _getAllAlimentos_
      1. Desc: Recupera todos los alimentos de la base de datos.
      2. URL: http://localhost:8084/WSEN/webresources/api/getAllAlimentos
      
   2. Servicio: _getAlimentoById_
      1. Desc: Recupera 1 solo alimento por el ID.
      2. URL: http://localhost:8084/WSEN/webresources/api/getAlimentoById/idAlimento
      3. URL: http://localhost:8084/WSEN/webresources/api/getAlimentoById/2

   3. Servicio: _getAlimentoByName_
      1. Desc: Recupera 1 solo alimento por el nombre.
      2. URL: http://localhost:8084/WSEN/webresources/api/getAlimentoByName/nombre
      3. Ej : http://localhost:8084/WSEN/webresources/api/getAlimentoByName/Platano

   4. Servicio: _nuevoAlimento_
      1. Desc: Agrega un alimento al registro.
      2. URL: http://localhost:8084/WSEN/webresources/api/nuevoAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"

   5. Servicio: _actualizarAlimento_
      1. Desc: Modifica un alimento.
      2. URL: http://localhost:8084/WSEN/webresources/api/actualizarAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"

   6. Servicio: _eliminarAlimento_
      1. Desc: Elimina un alimento del registro, utilizando como parametro el ID.
      2. URL: http://localhost:8084/WSEN/webresources/api/eliminarAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"
2. ### Servicios de Citas
   1. Servicio: _nuevaCita_
      1. Desc: Agrega una cita al registro.
      2. URL: http://localhost:8084/WSEN/webresources/api/nuevoAlimento
      3. Ej: Usar POSTMAN en BODY con "x-www-form-urlencoded"
