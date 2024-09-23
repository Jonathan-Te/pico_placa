# pico_placa
##Evaluación Grupo Advance Latam.


# Requisitos para ejecutar el proyecto.


### Frontend

Node version

    * 20.10.0 (Currently using 64-bit executable)

Angular

    angular/cli": "^17.0.8"




### Backend

java version "17.0.9" 2023-10-17 LTS

Java(TM) SE Runtime Environment (build 17.0.9+11-LTS-201)

Java HotSpot(TM) 64-Bit Server VM (build 17.0.9+11-LTS-201, mixed mode, sharing)




### Base de datos.
Mysql en Docker .

Docker version 20.10.21, build baeda1f

    GOSU_VERSION
    1.16

    MYSQL_MAJOR
    innovation

    MYSQL_VERSION
    8.3.0-1.el8

    MYSQL_SHELL_VERSION
    8.3.0-1.el8


## Como ejecutar.

Crear la base de datos con el archivo CreacioBD.mysql.
1. Descargar la imagen para el contenedor.
   
        docker pull mysql
2. Crear el contenedor mysql

        docker run -p 3306:3306 --name picoplaca_mysql_db -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
3. Abrir el bash del contenedor.

        docker exec -it picoplaca_mysql_db bash
4. Entrar a mysql

        mysql -u root -p
        la clave es: root
5. Ejecutar el comando para la creacion de la base de datos.
        create database RestriccionVehicular;

### Como ejecutar SpringBoot :
   En el directorio backend/ ejecutar el siguiente comando
   
        mvnw spring-boot:run
    
### Como ejecutar Angular.
   En el direcorio froentend
    
    npm i
    ng serve --open

## Cambios

Ya no se requieren los scripts de la creación de las tablas de la base de datos.
Ni cargar datos a la base de datos desde script sql.

Ahora la base se crea con JPA e Hibernate

La aplicacion cuenta con un manejo básico de usuarios, lo que permite registrar el historial de consultas de acuerdo al usuario.

Además cuando un ussario inicia sesion puede acceder a la pestaña de administración y puede crear las restricciones y excepciones.

Para poder comparar los nuevos cambios, se inicio los trabajos en el siguiente repositorio:

https://github.com/Jonathan-Te/pico_y_placa_v.2.0

Luego se copió la carpeta al repositorio original