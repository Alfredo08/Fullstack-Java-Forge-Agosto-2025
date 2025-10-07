<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Jugos </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
           <div class="row">
                <h1 class="col-8"> Jugos </h1>
                <nav class="col-4">
                    <div class="row">
                        <a class="col-4" href="/jugos"> Jugos </a>
                        <a class="col-4" href="/formulario/jugo"> Agregar jugo </a>
                        <a class="col-4" href="/logout"> Logout </a>
                    </div>
                </nav>
            </div>
            <div class="row">
                <h2> ${jugo.nombre} - agregado por ${jugo.usuario.nombre} ${jugo.usuario.apellido} </h2>
            </div>
            <div class="row">
                <div class="col-8">
                    <h4 class="subtitulo-detalle"> Descripción </h4>
                    <p> ${jugo.descripcion} </p>
                    <h4 class="subtitulo-detalle"> Ingredientes </h4>
                    <p> ${jugo.ingredientes} </p>
                    <h4 class="subtitulo-detalle"> Instrucciones </h4>
                    <p> ${jugo.instrucciones} </p>
                </div>
                <div class="col-4">
                    <img class="imagen-jugo" src="${jugo.imagen}" alt="${jugo.nombre}">
                </div>
            </div>
            <div class="row">
                <form action="/formulario/editar/jugo/${jugo.id}" method="GET">
                    <button class="btn btn-primary">
                        Editar
                    </button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>