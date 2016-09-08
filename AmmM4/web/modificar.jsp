<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Modificazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jorge Sanchez">
        <meta name="keywords" content="Milestone 4, modificar">
        <meta name="description" content="Pagina de modificar">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css" media="screen">
    </head>
    <body>
        <div class="web">
            <header>
            
                    <h1>Movil mania</h1>
                    <p>Modificazione</p>
           
            </header>

                <nav class="navegacion">
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="login.html">Link a pagina login</a></li>
                    </ul>
                </nav>
            

            <div class="contenido">
                 
                      <c:if test="${modificado==true}">
                          
                        <h2>Producto modificato</h2>
                        <a href="vendedores.html">Torna alla pagina venditore</a>
                        <br> <br> <br>
                        </c:if>

                <c:if test="${modificado==false}">
                    <h1>Modifica Producto</h1>
                    <div id="form">
                        <form method="POST" action="vendedores.html">
                                    <input type="hidden" name="idProductoCambiar" value="${producto.getId()}">
                                    <label for="nombe">Nome dello Oggeto : </label>
                                     <br> <br>
                                    <input type="text" name="nombre" 
                                           id="nombre" value="${producto.getNombre()}"/>
                                 <br> <br>
                              
                                    <label for="img">URL della foto: : </label>
                                     <br> <br>
                                    <input type="text" name="img" 
                                           id="img" value="${producto.getImagen()}"/>
                                <br> <br>
                             
                                    <label for="descripcion">Descrizione : </label>
                                     <br> <br>
                                    <textarea rows="5" cols="40" name="descripcion" id="descripcion">${producto.getDescripcion()}</textarea>
                               <br> <br>
                                <li>
                                    <label for="precio">Prezzo del disco: </label>
                                     <br> <br>
                                    <input type="number" name="precio" 
                                           id="precio" value="${producto.getPrecio()}">
                                <br> <br>
                                    <label for="cantidad">Quantità : </label>
                                     <br> <br>
                                    <input type="number" name="cantidad" id="cantidad" value="${producto.getDisponibilidad()}">
                                <br> <br>
                              
                                    <input type="submit" name="Cambiar" value="Cambiar" />
                                    <br>      <br>                  
                            
                        </form>
                    </div>
                </c:if>
            </div>
     
        </div>
    </body>
</html>
