<?php
include("Conexion.php");

$curso_id = $_GET["curso_id"];

$consulta = "SELECT id_imagen, id_curso, ruta_imagen
             FROM imagenes_curso
             WHERE id_curso = $curso_id";

$resultado = $conexion->query($consulta);

$imagenes = array();

while ($fila = $resultado->fetch_assoc()) {
    $fila["id_imagen"] = (int)$fila["id_imagen"];
    $fila["id_curso"] = (int)$fila["id_curso"];
    $imagenes[] = $fila;
}

echo json_encode($imagenes);