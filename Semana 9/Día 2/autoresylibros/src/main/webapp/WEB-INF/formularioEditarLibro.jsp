<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Actualizar libro </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="col-8"> Actualizar libro </h1>  
                <nav class="col-4">
                    <form method="GET" action="/libros">
                        <button class="btn btn-primary">
                            Lista de libros
                        </button>
                    </form>
                </nav>
            </div> 
            <div class="row">
                <form:form class="col-6" action="/editar/libro/${libro.id}" method="POST" modelAttribute="libro">
                    <input type="hidden" name="_method" value="PUT">
                    <div>
                        <form:label class="form-label" path="titulo">
                            Título: 
                        </form:label>
                        <form:input class="form-control" path="titulo" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="titulo"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="autor">
                            Autor: 
                        </form:label>
                        <form:input class="form-control" path="autor" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="autor"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="genero">
                            Género: 
                        </form:label>
                        <form:input class="form-control" path="genero" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="genero"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="anio">
                            Año: 
                        </form:label>
                        <form:input class="form-control" path="anio" type="date"/>
                        <form:errors class="alert alert-danger mensaje-error" path="anio"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="imagen">
                            Imagen: 
                        </form:label>
                        <form:input class="form-control" path="imagen" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="imagen"/>
                    </div>
                    <button class="btn btn-success mt-2">
                        Actualizar
                    </button>
                </form:form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>