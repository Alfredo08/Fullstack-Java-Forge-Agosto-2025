<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Registro </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="col-8"> Registro </h1>  
                <nav class="col-4">
                    <form method="GET" action="/login">
                        <button class="btn btn-primary">
                            Ir a login
                        </button>
                    </form>
                </nav>
            </div> 
            <div class="row">
                <form:form class="col-6" action="/agregar/autor" method="POST" modelAttribute="nuevoAutor">
                    <div>
                        <form:label class="form-label" path="nombre">
                            Nombre: 
                        </form:label>
                        <form:input class="form-control" path="nombre" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="nombre"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="correo">
                            Correo: 
                        </form:label>
                        <form:input class="form-control" path="correo" type="text"/>
                        <form:errors class="alert alert-danger mensaje-error" path="correo"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="contrasenia">
                            Contraseña: 
                        </form:label>
                        <form:input class="form-control" path="contrasenia" type="password"/>
                        <form:errors class="alert alert-danger mensaje-error" path="contrasenia"/>
                    </div>
                    <div>
                        <form:label class="form-label" path="confirmarContrasenia">
                            Confirmar contraseña: 
                        </form:label>
                        <form:input class="form-control" path="confirmarContrasenia" type="password"/>
                        <form:errors class="alert alert-danger mensaje-error" path="confirmarContrasenia"/>
                    </div>
                    <button class="btn btn-success mt-2">
                        Registro
                    </button>
                </form:form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>