<?php
include("Conexion.php");
$consulta = "SELECT * FROM cursos";
$resultado = $conexion->query($consulta);
$cursos = array();

while ($fila = $resultado->fetch_assoc()) {
    $cursos[] = $fila;
}

echo json_encode($cursos);