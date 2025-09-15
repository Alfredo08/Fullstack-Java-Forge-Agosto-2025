<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> App de libros y autores </title>
    </head>
    <body>
        <h1> Lista de libros </h1>
        <nav>
            <a href="/formulario/libro"> Agregar libro </a>
        </nav>
        <div class="lista-libros">
        <c:forEach var="libro" items="${listaLibros}">
            <h2> ${libro.titulo} </h2>
            <div class="imagen-libro">
                <img src="${libro.imagen}" alt="${libro.titulo}" >
            </div>
            <p> Autor: ${libro.autor} </p>
            <p> Género: ${libro.genero} </p>
            <p> Año: ${libro.anio} </p>
        </c:forEach>
        </div>
    </body>
</html>