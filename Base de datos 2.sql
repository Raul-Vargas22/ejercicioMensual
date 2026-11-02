
CREATE DATABASE cursos;

USE `cursos`;

DROP TABLE IF EXISTS `alumnos`;

CREATE TABLE `alumnos` (
  `id_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(30) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `id_carrera` int(11) NOT NULL,
  `estado` enum('Activo','Inactivo') NOT NULL,
  `fecha_inscripcion` date DEFAULT NULL,
  PRIMARY KEY (`id_alumno`),
  KEY `id_carrera` (`id_carrera`),
  CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


insert  into `alumnos`(`id_alumno`,`matricula`,`nombre`,`apellidos`,`correo`,`id_carrera`,`estado`,`fecha_inscripcion`) values (1,'2022020','Raul Arturo','Vargas Morales','raul@edu.mx',1,'Activo','2023-06-08');

DROP TABLE IF EXISTS `carreras`;

CREATE TABLE `carreras` (
  `id_carrera` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_carrera` varchar(120) NOT NULL,
  `estado_carrera` enum('Activo','Inactivo') NOT NULL,
  PRIMARY KEY (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


insert  into `carreras`(`id_carrera`,`nombre_carrera`,`estado_carrera`) values (1,'Ofimatica','Activo'),(2,'medicina','Activo');


DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `Id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(200) NOT NULL,
  PRIMARY KEY (`Id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


insert  into `categorias`(`Id_categoria`,`categoria`) values (1,'Software'),(2,'Diseño');

DROP TABLE IF EXISTS `cursos`;

CREATE TABLE `cursos` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_curso` varchar(50) NOT NULL,
  `nombre_curso` varchar(100) NOT NULL,
  `descripcion_curso` text NOT NULL,
  `id_carrera` int(11) NOT NULL,
  `edificio` varchar(50) NOT NULL,
  `salon` varchar(20) NOT NULL,
  `total_horas` int(11) NOT NULL,
  `cupo_maximo` int(11) NOT NULL,
  `imagen_principal` varchar(255) DEFAULT NULL,
  `estado` enum('Activo','Inactivo') NOT NULL,
  PRIMARY KEY (`id_curso`),
  KEY `id_carrera` (`id_carrera`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


insert  into `cursos`(`id_curso`,`codigo_curso`,`nombre_curso`,`descripcion_curso`,`id_carrera`,`edificio`,`salon`,`total_horas`,`cupo_maximo`,`imagen_principal`,`estado`) values (1,'D-110','Base de datos','Curso que ayuda a desarrollar el trabajo implemnentado por IA',1,'D','K-10',300,44,'IA.png','Activo');


DROP TABLE IF EXISTS `imagenes_curso`;

CREATE TABLE `imagenes_curso` (
  `id_imagen` int(11) NOT NULL AUTO_INCREMENT,
  `id_curso` int(11) NOT NULL,
  `numero_imagen` int(11) NOT NULL,
  `ruta_imagen` varchar(255) NOT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `id_curso` (`id_curso`),
  CONSTRAINT `imagenes_curso_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


insert  into `imagenes_curso`(`id_imagen`,`id_curso`,`numero_imagen`,`ruta_imagen`) values (1,1,1,'/imagenes/principal/basedatos.jpg');


DROP TABLE IF EXISTS `inscripciones`;

CREATE TABLE `inscripciones` (
  `id_inscripcion` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_alumno` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `estado` enum('Inscrito','Cancelado','Finalizado') NOT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_inscripcion`),
  KEY `id_alumno` (`id_alumno`),
  KEY `id_curso` (`id_curso`),
  CONSTRAINT `inscripciones_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumnos` (`id_alumno`),
  CONSTRAINT `inscripciones_ibfk_2` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert  into `inscripciones`(`id_inscripcion`,`id_alumno`,`id_curso`,`fecha_registro`,`estado`,`observaciones`) values (1,1,1,'2026-09-08 23:41:44','Inscrito',NULL);
