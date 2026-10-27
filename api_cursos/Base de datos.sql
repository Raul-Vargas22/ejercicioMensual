CREATE DATABASE IF NOT EXISTS cursos;
USE cursos;

CREATE TABLE carreras (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    estado ENUM('Activo','Inactivo') NOT NULL
);

CREATE TABLE alumnos (
    id_alumno INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(30) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    id_carrera INT NOT NULL,
    estado ENUM('Activo','Inactivo') NOT NULL,
    fecha_inscripcion DATE,
    FOREIGN KEY (id_carrera) REFERENCES carreras(id_carrera)
);

CREATE TABLE cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    codigo_curso VARCHAR(50) NOT NULL,
    nombre_curso VARCHAR(100) NOT NULL,
    descripcion_curso TEXT NOT NULL,
    id_carrera INT NOT NULL,
    edificio VARCHAR(50) NOT NULL,
    salon VARCHAR(20) NOT NULL,
    total_horas INT NOT NULL,
    cupo_maximo INT NOT NULL,
    imagen_principal VARCHAR(255),
    estado ENUM('Activo','Inactivo') NOT NULL,
    fecha_creacion DATETIME,
    FOREIGN KEY (id_carrera) REFERENCES carreras(id_carrera)
);

CREATE TABLE horarios_curso (
    id_horario INT AUTO_INCREMENT PRIMARY KEY,
    id_curso INT NOT NULL,
    dia_semana ENUM('Lunes','Martes','Miércoles','Jueves','Viernes') NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);`alumnos``cursos`

CREATE TABLE imagenes_curso (
    id_imagen INT AUTO_INCREMENT PRIMARY KEY,
    id_curso INT NOT NULL,
    numero_imagen INT NOT NULL,
    ruta_imagen VARCHAR(255) NOT NULL,
    texto_alternativo VARCHAR(255),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

CREATE TABLE inscripciones (
    id_inscripcion BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT NOT NULL,
    id_curso INT NOT NULL,
    fecha_registro DATETIME NOT NULL,
    estado ENUM('Inscrito','Cancelado','Finalizado') NOT NULL,
    observaciones VARCHAR(500),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id_alumno),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);