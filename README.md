# WSEasyNutrition

Acuerdense de cambiar el puerto en las URLs.

## Total de Servicios
Alimentos | Citas | Consultas |
--------- | ----- | ----------|
1         |   0   |     0     |

## Nomenclatura para UI
*Label = lb
*TextField = txtNombreAcción
*Button = btnNombreAcción
## Lista de Servicios Creados
### Ya hecho
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