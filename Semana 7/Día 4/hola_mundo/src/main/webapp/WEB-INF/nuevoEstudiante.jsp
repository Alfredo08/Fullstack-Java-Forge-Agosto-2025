<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Estudiante nuevo </title>
    </head>
    <body>
        <h1> Agregar estudiante </h1>
        <form method="POST" action="/agregar/estudiante">
            <div>
                <label for="nombre">
                    Nombre:
                </label>
                <input type="text" id="nombre" name="nombre">
            </div>
            <div>
                <label for="apellidoPaterno">
                    Apellido paterno:
                </label>
                <input type="text" id="apellidoPaterno" name="apellidoPaterno">
            </div>
            <div>
                <label for="apellidoMaterno">
                    Apellido materno:
                </label>
                <input type="text" id="apellidoMaterno" name="apellidoMaterno">
            </div>
            <button>
                Agregar
            </button>
        </form>
        <a href="/estudiantes"> Volver a lista de estudiantes </a>
    </body>
</html>