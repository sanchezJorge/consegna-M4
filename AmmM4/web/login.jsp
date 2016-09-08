<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Milestone 4">
        <meta name="author" content="Jorge Sánchez Gómez">
        <meta name="keywords" content=" Milestone 4, AMM, eror">
        <link rel="stylesheet"  type="text/css" href="css/mystyle.css"  media="screen" />
    </head>
    <body>
        <div class="web">
            <header>
                <h1>Movil Mania</h1>
                <p>Login</p>
            </header>

            <nav id="navegacion">
                 <h3> Menu di navigazione</h3>
                <ul>
                    <li><a href="descrizione.jsp">Link a Descripcion</a></li>
                    <li><a href="vendedores.html">Link a Vendedor</a></li>
                    <li><a href="cliente.html">Link a Cliente</a></li>
                </ul>
            </nav>

            <div class="contenido">
                <br><br>
                <form action="login.html" method="POST">
                    <label>Username: </label>
                    <input type="text" name="Username" value="Username">
                    <br>
                    <label>Password: </label>
                    <input type="password" name="Password" id="pswd" value="Password">
                    <br>
                    <br>
                    <input type="submit" name="Login" value="Inviare">
                    <input type="reset" value="Cancellare">
                </form>
                <br>
                <br>
            </div>
        </div>
    </body>
</html>

