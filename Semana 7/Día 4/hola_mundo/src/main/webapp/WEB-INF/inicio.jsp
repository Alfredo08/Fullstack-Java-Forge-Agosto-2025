<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Inicio </title>
    </head>
    <body>
        <h1> Bienvenid@ de vuelta ${nombreUsuario} </h1>
        <form method="POST" action="/procesa/logout">
            <button>
                Cerrar sesión
            </button>
        </form>
    </body>
</html>