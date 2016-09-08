<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Confirmazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jorge Sanchez Gomez">
        <meta name="keywords" content="Milestone 4, confirmacion">
        <meta name="description" content="Confirmacion Vendedor">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css" media="screen">
    </head>
    <body>
        <div class="web">
            <header>
                    <h1>Movil Mania</h1>
                    <p>Conferma del Venditore</p>

            </header>
        
                <nav class="navegacion">
                    <ul>
                        <li><a href="descrizione.jsp">Link a Descrizione</a></li>
                    </ul>
                </nav>
 
            <div class="contenido">
                
                <h1>Conferma:</h1>
                
                    <c:if test="${error==true}">
                        <p>Error</p>
                        <a href="vendedores.html">Torna alla pagina anteriore</a>
                        </c:if>
                        <c:if test="${error==false}">
                        <h2>Nome dello Oggeto:</h2> 
                        <p>${nombre}</p>
                        <h2>URL della foto: </h2> 
                        <p>${img}</p>
                        <h2>Descrizione: </h2> 
                        <p>${descripcion}</p>
                        <h2>Prezzo: </h2> 
                        <p>${precio}</p>
                        <h2>Quantità: </h2> 
                        <p>${cantidad}</p>
                        
                        <form method="post" action="vendedores.html">
                                    <input type="hidden" name="nombre" value="${nombre}">
                                    <input type="hidden" name="foto" value="${foto}">
                                    <input type="hidden" name="descripcion" value="${descripcion}">
                                    <input type="hidden" name="precio" value="${precio}">
                                    <input type="hidden" name="cantidad" value="${cantidad}">
                                    
                           <button type="submit" name="Entrar" value=true>Conferma</button>
                           
                           <button type="submit" name="Entrar" value=false>Reset</button>
                                      
                        </form>
              </c:if>
            </div>
        </div>
    </body>
</html>

