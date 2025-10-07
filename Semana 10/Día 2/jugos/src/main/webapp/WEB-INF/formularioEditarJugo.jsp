<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Editar jugo </title>
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
                <form:form class="col-6" action="/actualizar/jugo/${jugo.id}" method="POST" modelAttribute="jugo">
                    <input type="hidden" name="_method" value="PUT">
                    <div>
                        <form:label class="form-label" path="nombre">
                            Nombre: 
                        </form:label>
                        <form:input class="form-control" path="nombre" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="nombre"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="descripcion">
                            Descripción: 
                        </form:label>
                        <form:input class="form-control" path="descripcion" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="descripcion"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="ingredientes">
                            Ingredientes: 
                        </form:label>
                        <form:input class="form-control" path="ingredientes" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="ingredientes"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="instrucciones">
                            Instrucciones: 
                        </form:label>
                        <form:input class="form-control" path="instrucciones" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="instrucciones"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="imagen">
                            URL a la imagen: 
                        </form:label>
                        <form:input class="form-control" path="imagen" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="imagen"/>
                    </div>
                    <button class="btn btn-primary mt-2">
                        Editar
                    </button>
                </form:form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>