<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Nuevo libro </title>
    </head>
    <body>
        <h1> Nuevo libro </h1>

        <form:form action="/agregar/libro" method="POST" modelAttribute="nuevoLibro">
            <div>
                <form:label path="titulo">
                    Título: 
                </form:label>
                <form:input path="titulo" type="text"/>
                <form:errors path="titulo"/>
            </div>
            <div>
                <form:label path="autor">
                    Autor: 
                </form:label>
                <form:input path="autor" type="text"/>
                <form:errors path="autor"/>
            </div>
            <div>
                <form:label path="genero">
                    Género: 
                </form:label>
                <form:input path="genero" type="text"/>
                <form:errors path="genero"/>
            </div>
            <div>
                <form:label path="anio">
                    Año: 
                </form:label>
                <form:input path="anio" type="date"/>
                <form:errors path="anio"/>
            </div>
            <div>
                <form:label path="imagen">
                    Imagen: 
                </form:label>
                <form:input path="imagen" type="text"/>
                <form:errors path="imagen"/>
            </div>
            <button>
                Agregar
            </button>
        </form:form>
        <nav>
            <a href="/libros"> Lista de libros </a>
        </nav>
    </body>
</html>