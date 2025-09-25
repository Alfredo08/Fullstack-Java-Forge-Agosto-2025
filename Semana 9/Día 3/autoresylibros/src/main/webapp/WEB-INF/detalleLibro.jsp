<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> App de libros y autores </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="col-8"> Detalle del libro: ${libro.titulo}</h1>
                <nav class="col-4">
                    <form method="GET" action="/libros">
                        <button class="btn btn-primary">
                            Lista de libros
                        </button>
                    </form>
                </nav>
            </div>
            <div class="row">
                <div class="col-6 tarjeta-libro">
                    <img class="imagen-libro" src="${libro.imagen}" alt="${libro.titulo}">
                    <p> Autor: ${libro.autor.nombre} </p>
                    <p> Año: ${libro.anio} </p>
                    <p> Género: ${libro.genero} </p>
                    <c:if test="${id_autor == libro.autor.id}">
                    <form method="GET" action="/formulario/actualizar/libro/${libro.id}">
                        <button class="btn btn-info">
                            Actualizar
                        </button>
                    </form>
                    </c:if>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>