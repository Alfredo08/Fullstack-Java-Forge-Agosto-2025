<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Jugos </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="css/estilos.css" rel="stylesheet">
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
                <h1> Bienvenid@ de vuelta ${nombre} </h1>
            </div>
            <div class="row">
                <c:forEach var="jugo" items="${listaJugos}">
                <div class="col-4 tarjeta-jugo">
                    <h2> ${jugo.nombre} </h2>
                    <img src="${jugo.imagen}" alt="${jugo.nombre}" class="imagen-jugo">
                    <div class="opciones">
                        <form>
                            <button class="btn btn-primary">
                                Detalle
                            </button>
                        </form>
                        <form method="POST" action="/eliminar/jugo/${jugo.id}">
                            <input type="hidden" name="_method" value="DELETE"> 
                            <button class="btn btn-danger">
                                Eliminar
                            </button>
                        </form>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>