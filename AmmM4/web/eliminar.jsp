<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Eliminazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jorge Sanchez">
        <meta name="keywords" content="Milestone 4, eliminacion">
        <meta name="description" content="Pagina de eliminacion">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css" media="screen">
    </head>
    <body>
        <div class="web">
            <header>
            
                    <h1>Movil mania</h1>
                    <p>Eliminazione</p>
           
            </header>

                <nav class="navegacion">
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="login.html">Link a pagina login</a></li>
                    </ul>
                </nav>
            

            <div class="contenido">
                <c:if test="${eliminado==true}">
                        <p>Producto eliminato</p>
                        <a href="vendedores.html">Torna alla pagina anteriore</a>
                </c:if>
                <c:if test="${eliminado==false}">
                    
                   
                        <h1>Conferma la eliminazione</h1>
                        <p>
                            <h2>Nome: </h2> ${producto.getNombre()}
                            <h2>Descrizione:</h2> ${producto.getDescripcion()}
                            <img src="${producto.getImagen()}" title="${producto.getNombre()}" 
                                 alt="${producto.getNombre()}">
                            <h2>Prezzo:</h2> ${producto.getPrecio()}
                            
                            <form method="post" action="vendedores.html">
                                <input type="hidden" name="idProductoBorrar" value="${producto.getId()}">
                                
                                <input type="submit" name="Elimina" value="Elimina">
                                <input type="submit" name="Cancelare" value="Cancelare">

                            </form>
                        </p>    
                   
                </c:if> 
            </div>
        </div>
    </body>
</html>
