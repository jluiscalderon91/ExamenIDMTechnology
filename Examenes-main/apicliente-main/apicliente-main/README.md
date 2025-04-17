# api cliente
Creacion api para el registro y consulta de cliente - prueba tecnica para desarrollador java - Banco Azteca

- Al levantar el proyecto se debe configurar para ser ejecutado con JAVA 17 y MAVEN 3.8.7
- Se debe ejecutar el siguiente comando para instalar las liberias
```
nvm clean install
```
Para ingresar a visualizar el swagger se debe seguir la siguiente ruta: 
```
http://localhost:8181/gestion-requerimientos/swagger-ui/index.html
```
Para crear la base de datos se debe ejecutar en Mysql el siguiente script (usuario : root / password : root) :
```
CREATE DATABASE gestion-requerimientos;
use gestion-requerimientos;

CREATE TABLE `area` (
`idArea` int(11) NOT NULL AUTO_INCREMENT,
`descripcion` varchar(50) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `solicitante` (
`idSolicitante` int(11) NOT NULL AUTO_INCREMENT,
`nombres` varchar(50) NOT NULL,
`idArea` int(11) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idSolicitante`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `anexo` (
`idAnexo` int(11) NOT NULL AUTO_INCREMENT,
`descripcion` varchar(50) NOT NULL,
`guid` varchar(50) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `solicitud` (
`idSolicitud` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) NOT NULL,
`descripcion` varchar(50) NOT NULL,
`fechaSolicitud` date NOT NULL,
`idSolicitante` int(11) NOT NULL,
`idAnexo` int(11) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idSolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tipoEmpleado` (
`idTipoEmpleado` int(11) NOT NULL AUTO_INCREMENT,
`descripcion` varchar(50) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `empleado` (
`idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
`nombres` varchar(50) NOT NULL,
`apellidos` varchar(50) NOT NULL,
`idTipoEmpleado` int(11) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idSolicitante`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `asignacion` (
`idAsignacion` int(11) NOT NULL AUTO_INCREMENT,
`idSolicitud` int(11) NOT NULL,
`idEmpleado` int(11) NOT NULL,
`fechaAsignacion` date NOT NULL,
`comentarios` varchar(200) NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idSolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `evaluacion` (
`idEvaluacion` int(11) NOT NULL AUTO_INCREMENT,
`idSolicitud` int(11) NOT NULL,
`propuestaSolucion` varchar(200) NOT NULL,
`estimacionTiempo` varchar(50) NOT NULL,
`numeroProgramadores` int(11) NOT NULL,
`comentarios` varchar(200) NOT NULL,
`idAnexo` int(11) NOT NULL,
`idEmpleado` int(11) NOT NULL,
`fechaEvaluacion` date NOT NULL,
`estado` varchar(1) NOT NULL DEFAULT '1' COMMENT '1=Activo, 0=No Activo',
PRIMARY KEY (`idSolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

Para probar la solucion mediante postman:

Para crear un cliente se debe ejecutar la siguiente URL:
```
POST http://localhost:8181/gestion-requerimientos/api/solicitud/add
Requestbody:
{
    "nombre": "Solicitud de cambios",
    "descripcion": "Se solicita el cambio de controles obsoletos",
    "anexo": {
            descripcion : "Jimenez"
            guid: ""
    },
    "solicitante": {
        nombres : "Jose Luis"
        apellidos: "Jimenez"
        area: {
            descripcion : "Analista"
        }
    }
}

PUT http://localhost:8181/gestion-requerimientos/api/solicitud/update/1
Requestbody:
{
    "nombre": "Solicitud de cambios 2",
    "descripcion": "Se solicita el cambio de controles obsoletos",
    "anexo": {
            descripcion : "Jimenez" 
            guid: ""
    },
    "solicitante": {
        nombres : "Jose Luis"
        apellidos: "Jimenez"
        area: {
            descripcion : "Analista"
        }
    }
}

GET http://localhost:8181/gestion-requerimientos/api/solicitud/getAll/estado/1

DELETE http://localhost:8181/gestion-requerimientos/api/solicitud/delete/1

```

Para obtener un cliente por su estado se debe ejecutar la siguiente URL:
```
GET http://localhost:8181/gestion-requerimientos/api/solicitud/getAll/estado/1
```