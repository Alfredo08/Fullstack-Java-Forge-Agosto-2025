<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> App de libros y autores </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="col-8"> Lista de libros </h1>
                <nav class="col-4">
                    <form method="GET" action="/formulario/libro">
                        <button class="btn btn-primary">
                            Agregar libro
                        </button>
                    </form>
                </nav>
            </div>
            <div class="lista-libros row">
            <c:forEach var="libro" items="${listaLibros}">
                <div class="col-3 tarjeta-libro">
                    <h2> ${libro.titulo} </h2>
                    <img class="imagen-libro" src="${libro.imagen}" alt="${libro.titulo}" >
                    <form method="GET" action="/detalle/libro/${libro.id}">
                        <button class="btn btn-secondary">
                            Detalle
                        </button>
                    </form>
                </div>
            </c:forEach>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>