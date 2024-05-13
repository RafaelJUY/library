# Microservicio "library"

## Autor: Rafael Enrique Cortez

***
## Para probar la aplicación
Cuenta con las siguientes instrucciones

### Mendiante Docker, Kubernetes y Minikube
> https://github.com/RafaelJUY/library/tree/kubernetes_project

### Mediante Docker y Docker-Compose
> https://github.com/RafaelJUY/library/tree/docker-compose

***
## Explicación del proyecto

**Proyecto Maven** cuyo dominio a tratar es de una librería, préstamo de libros a socios, contiene dos microservicios
desarrollados con **Java 17** y **Spring Boot 3**.
- **Microservicio de Socios (msvc_partners):** Manejo de socios y registro de los préstamos de libros realizados.
  Interactúa con una base de datos MySQL.
- **Microservicio de Libros (msvc_books):** Relación entre libros y autores, así como también el stock de libros.
  Interactúa con una base de datos PostgreSQL.


- Además, para el proyecto se usó:
  - Spring Data JPA
  - Base de datos MySQL y H2 para test
  - Pruebas Unitarias con JUnit5 y Mockit (de momento solo en msvc_books para repository, service y controller).
  - Lombok
  - Maven
  - DTO
  - Manejo de excepciones globales: paquete exception
  - Programacion Funcional, API Stream, lambda.
  - Comunicación entre microservicios mediante openfeign.
  - Genericos: IGenericCRUD, IGenericCRUDImpl, IGenericRepository.