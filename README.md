# API REST de Gestión de Juegos (`api_juegos`)

API RESTful desarrollada para la gestión de un catálogo de videojuegos, utilizando persistencia en una base de datos en memoria.

---

## ⚙️ Funcionamiento y Arquitectura

El proyecto sigue el patrón de diseño por capas estándar de Spring Boot:

* **Capa de Presentación (`JuegoController`):** Expone los endpoints REST (`GET`, `POST`, `PUT`, `DELETE`), procesa las peticiones HTTP y maneja las respuestas con códigos de estado semánticos (`200 OK`, `201 Created`, `204 No Content`, `404 Not Found`).
* **Capa de Datos (`JuegoRepository`):** Interfaz que extiende de `JpaRepository`, permitiendo operaciones CRUD automáticas sobre la base de datos sin escribir SQL manual. Incluye un método derivado (`findByGeneroIgnoreCase`) para consultas personalizadas con `@RequestParam`.
* **Capa de Modelo (`Juego`):** Clase mapeada con JPA (`@Entity`) que define la estructura de la tabla en la base de datos (`id`, `titulo`, `genero`, `precio`, `plataforma`).

---

## 🛠️ Tecnologías Implementadas

* **Java 21:** Lenguaje de programación base.
* **Spring Boot 3.x:** Framework para la creación de la API REST (módulo Spring Web).
* **Spring Data JPA & Hibernate:** ORM para el mapeo objeto-relacional y persistencia de datos.
* **H2 Database:** Base de datos relacional en memoria para desarrollo y pruebas rápidas.
* **Maven:** Gestión de dependencias y construcción del proyecto.

---

## 🚀 Ejecución Rápida

1. Ejecuta la clase principal `ApiJuegosApplication.java` en tu IDE (IntelliJ IDEA).
2. La API se levantará en `http://localhost:8080`.
3. Accede a la consola de la base de datos en `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:juegosdb`, Usuario: `sa`, sin contraseña).

---

## 📌 Resumen de Endpoints

* **POST** `/juegos` : Crea un nuevo juego (requiere JSON).
* **GET** `/juegos` : Lista todos los juegos.
* **GET** `/juegos/{id}` : Busca un juego específico.
* **GET** `/juegos/buscar?genero={genero}` : Filtra juegos por género.
* **PUT** `/juegos/{id}` : Actualiza los datos de un juego (requiere JSON).
* **DELETE** `/juegos/{id}` : Elimina un juego.