# API de Videojuegos

Este proyecto consiste en una API web desarrollada con Java y Spring Boot, cuyo objetivo es realizar operaciones básicas relacionadas con videojuegos. La API permite consultar información, buscar videojuegos, consultar un videojuego mediante un identificador y recibir información mediante solicitudes POST en formato JSON. El proyecto utiliza Java, Spring Boot, Maven, Spring Web, Postman y GitHub. Además, se implementa un `record` como DTO llamado `VideojuegoDTO` para representar los datos recibidos en las solicitudes y se utiliza `ResponseEntity` para retornar códigos HTTP coherentes con las operaciones realizadas.

## Endpoints

### 1. Obtener videojuegos

**Método:** GET

**Ruta:** `/videojuegos`

Este endpoint permite realizar una consulta general de videojuegos. Al realizar una solicitud GET a `http://localhost:8080/videojuegos`, la API responde con un mensaje indicando que se está obteniendo la lista de videojuegos.

### 2. Obtener videojuego por ID

**Método:** GET

**Ruta:** `/videojuegos/{id}`

Este endpoint utiliza `@PathVariable` para recibir el identificador del videojuego directamente desde la URL. Por ejemplo, al realizar una solicitud GET a `http://localhost:8080/videojuegos/5`, la API recibe el valor `5` como identificador y responde indicando que se encontró un videojuego con ese ID.

### 3. Buscar videojuego por nombre

**Método:** GET

**Ruta:** `/buscar?nombre=FIFA`

Este endpoint utiliza `@RequestParam` para recibir el nombre del videojuego como parámetro de consulta. Por ejemplo, al realizar una solicitud GET a `http://localhost:8080/buscar?nombre=FIFA`, la API recibe el valor `FIFA` y responde indicando que se está buscando ese videojuego.

### 4. Crear videojuego

**Método:** POST

**Ruta:** `/videojuegos`

Este endpoint permite recibir información de un videojuego mediante una solicitud POST utilizando `@RequestBody`. Los datos son enviados en formato JSON y representados mediante el `record` `VideojuegoDTO`. Un ejemplo de la información enviada es:

```json
{
    "nombre": "FIFA 26",
    "genero": "Deportes",
    "precio": 250000
}

