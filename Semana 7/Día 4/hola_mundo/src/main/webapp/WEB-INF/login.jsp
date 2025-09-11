<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Login </title>
    </head>
    <body>
        <h1> Login </h1>
        <form method="POST" action="/procesa/login">
            <div>
                <label for="nombreUsuario">
                    Nombre de usuario:
                </label>
                <input type="text" id="nombreUsuario" name="nombreUsuario">
                <span> ${errorNombreUsuario} </span>
            </div>
            <div>
                <label for="contraseña">
                    Contraseña:
                </label>
                <input type="password" id="contraseña" name="contraseña">
                <span> ${errorContraseña} </span>
            </div> 
            <button>
                Login
            </button>
        </form>
    </body>
</html>