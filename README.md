# Spring Boot REST API

Este proyecto es un ejemplo de una API RESTful utilizando Spring Boot. Incluye operaciones CRUD básicas para gestionar usuarios, con un mapeo entre entidades y DTOs usando ModelMapper y MapStruct. También incluye un manejo excepciones personalizadas.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- MySQL

## Configuración

1. Clona este repositorio:
    ```sh
    git clone https://github.com/AlexisMartinez1913/rest-api-user-management
    cd rest-api-user-management
    ```

2. Configura tu base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/human_resources_db?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=tu_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    server.port=8081
    ```

3. Compila y ejecuta la aplicación:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Uso de la API

### Crear Usuario

- **URL:** `/api/users`
- **Método:** `POST`
- **Cuerpo de la Solicitud:**
    ```json
    {
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
    }
    ```
- **Respuesta:**
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
    }
    ```

### Obtener Usuario por ID

- **URL:** `/api/users/{id}`
- **Método:** `GET`
- **Respuesta:**
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
    }
    ```

### Obtener Todos los Usuarios

- **URL:** `/api/users`
- **Método:** `GET`
- **Respuesta:**
    ```json
    [
        {
            "id": 1,
            "firstName": "John",
            "lastName": "Doe",
            "email": "john.doe@example.com"
        }
    ]
    ```

### Actualizar Usuario

- **URL:** `/api/users/{id}`
- **Método:** `PUT`
- **Cuerpo de la Solicitud:**
    ```json
    {
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
    }
    ```
- **Respuesta:**
    ```json
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
    }
    ```

### Eliminar Usuario

- **URL:** `/api/users/{id}`
- **Método:** `DELETE`
- **Respuesta:**
    ```json
    {
        "message": "User successfully deleted!"
    }
    ```
### Excepciones Personalizadas

Se han definido excepciones personalizadas para manejar casos específicos, como cuando un usuario no se encuentra o cuando un correo electrónico ya existe.

## Documentación con Swagger UI

Esta aplicación está integrada con Swagger UI para proporcionar documentación interactiva de la API. Para acceder a Swagger UI, ejecuta la aplicación y navega a `http://localhost:8081/swagger-ui.html`.


## Contribución

Si deseas contribuir a este proyecto, por favor realiza un fork del repositorio y envía un pull request con tus mejoras.

## Licencia

Este proyecto está licenciado bajo los términos de la Licencia MIT.
