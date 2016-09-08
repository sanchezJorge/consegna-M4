<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Confirmazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jorge Sanchez Gomez">
        <meta name="keywords" content="Milestone 4, confirmacion">
        <meta name="description" content="Pagina de confirmacion">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css" media="screen">
    </head>
    <body>
        <div class="web">
            <header>
                
                    <h1>Movil Mania</h1>
                              
            </header>

                <nav class="navegacion">
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="cliente.html">Torna alla pagina Cliente</a></li>
                    </ul>
                </nav>


            <div class="contenido">
               
                    <h1>Riepilogo acquisto</h1>
                    
                    <h2>Nombre: </h2> ${producto.getNombre()}
                    <h2>Descrizione: </h2> ${producto.getDescripcion()}
                        
                        <img src="${producto.getImagen()}" title="${producto.getNombre()}" 
                                     alt="${producto.getNombre()}">
                        <h2>Precio: </h2> ${producto.getPrecio()}
                        <form method="post" action="cliente.html">
                            <input type="hidden" name="idProductoAdq" value="${producto.getId()}">
                            <input type="hidden" name="idProducto" value="0">
                            <br>
                            <input type="submit" name="Adquirido" value="Conferma">
                            <br>
                        </form>
                    
              
            </div>
        </div>
    </body>
</html>
