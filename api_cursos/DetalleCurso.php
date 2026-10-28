<?php
include("Conexion.php");
$id_curso = $_GET["id_curso"];
$consulta = "SELECT * FROM cursos WHERE id_curso = $id_curso";
$resultado = $conexion->query($consulta);
$fila = $resultado->fetch_assoc();
echo json_encode($fila);