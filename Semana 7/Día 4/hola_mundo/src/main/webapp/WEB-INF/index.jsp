<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Mi primera página JSP </title>
    </head>
    <body>
        <h1> Mi primera página JSP </h1>
        <%!
            String nombre = "Alex Miller";
            int edad = 25;
        %>
        <h2> Nombre: <%= nombre %> Edad: <%= edad %></h2>

        <ul>
            <% for(int i = 1; i <= 5; i ++){ %>
                <li> <%= Math.random() %> </li>
            <% } %>
        </ul>

    </body>
</html>