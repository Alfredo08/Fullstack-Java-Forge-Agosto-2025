<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Mi primera página JSP </title>
    </head>
    <body>
        <!-- <h1> <c:out value="${titulo}"/> </h1> -->
        <h1> ${titulo} </h1>

        <ul>
        <c:forEach var="estudiante" items="${estudiantes}">
            <li> ${estudiante} </li>
        </c:forEach>
        </ul>
    </body>
</html>