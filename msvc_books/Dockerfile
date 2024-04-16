# Nombre carpeta del microservicio (msvc). ARG global
ARG MSVC_NAME=msvc_books

# Se crea la imagen varias compilaciones (varios FROM) para lograr una imagen final mas pequeña
FROM openjdk:17-jdk-alpine as builder

# Para poder usar en esta construccion el ARG global MSVC_NAME
ARG MSVC_NAME

# Definiendo directorio de trabajo.
WORKDIR /app/$MSVC_NAME

# Se copia el pom.xml del parent
COPY ./pom.xml /app

# Se agrega estas capas para las dependencias
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .

# Dar permisos de ejecución al archivo mvnw
RUN chmod +x mvnw

# Se copia el pom.xml del microservicio
COPY ./$MSVC_NAME/pom.xml .

# Necesario para convertir el formato del fichero mvnw a windows a linux.
RUN sed -i 's/\r$//' mvnw

# Para saltar el test y la compilacion del test
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline # Alternativa al comando anterior


# Copia del codigo fuente
COPY ./$MSVC_NAME/src ./src
# Para generar el .jar dentro de la imagen.
RUN ./mvnw clean package -DskipTests




# imagen final, se usa la imagen anterior (builder)
# Esta imagen queda mas pequeña en tamaño al solo tener el .jar y no las dependencias de maven.
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Para guardar el log de la aplicacion
RUN mkdir ./logs

# Para poder usar en esta construccion el ARG global MSVC_NAME
ARG MSVC_NAME
# Ruta del la carpeta target
ARG TARGET_FOLDER=/app/$MSVC_NAME/target

# Copiamos de la compilacion de la imagen anterior el .jar
COPY --from=builder $TARGET_FOLDER/msvc_books-0.0.1-SNAPSHOT.jar .

# Puerto de la aplicacion, me va a permitir sobreescrbirlo al contruir la imagen desde el docker build --build-arg
ARG PORT_APP=8001

# Se define variable de ambiente para el puerto.
ENV PORT $PORT_APP

EXPOSE $PORT

CMD ["java","-jar","msvc_books-0.0.1-SNAPSHOT.jar"]