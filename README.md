# Microservicio "library"
## Desarrollado en Java 17 y Spring Boot 3

Se compone de dos microservicios:
- msvc_books: API REST para gestionar libros y sus autores.
- msvc_partners: API REST con socios y prestamos/devolucion de libros.

La comunicacion se realiza con openfeign desde msvc_partners a msvc_books.

### En el proyecto se usa
- Java 17
- Spring Boot 3
- Spring Data JPA
- Base de datos MySQL y H2 para test
- Swagger: endpoint http://localhost:8001/swagger-ui/index.html
- Pruebas Unitarias con JUnit5 y Mockit (de momento solo en msvc_books para repository, service y controller).
- Lombok
- Maven