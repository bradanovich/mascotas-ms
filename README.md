# Mascotas MS

Microservicio encargado de la gestión de mascotas del sistema de Registro y Gestión de Cuidados para Mascotas.

Desarrollado con Java, Spring Boot, Maven, Spring Data JPA y MySQL.

## Tecnologías utilizadas

- Java 21
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git y GitHub

## Funcionalidades

El microservicio permite realizar operaciones CRUD sobre las mascotas:

- Crear una mascota.
- Listar todas las mascotas.
- Buscar una mascota por ID.
- Actualizar una mascota.
- Eliminar una mascota.

## Estructura del proyecto

El proyecto está organizado en capas:

```text
src/main/java/cl/duoc/mascotas

├── controller
│   └── MascotaController.java
│
├── model
│   └── Mascota.java
│
├── repository
│   └── MascotaRepository.java
│
├── service
│   └── MascotaService.java
│
└── MascotasApplication.java