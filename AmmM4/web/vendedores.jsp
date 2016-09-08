<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Venditore/title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jorge Sanchez">
        <meta name="keywords" content="Milestone 4, vendedores">
        <meta name="description" content="vendedores">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css" media="screen">
    </head>
    <body>
        <div class="web">
            <header>

                    <h1>Movil Mania</h1>
                    <p>Pagina venditore</p>
                
            </header>

            
                <nav id="navegacion">
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                    </ul>
                </nav>
            
            
            <div class="contenido">
                <h1>${vendedores.getNombre()} ${vendedores.getApellido()}</h1> 
                <p>Nickname: ${vendedores.getUsername()}</p>
                <p>Il tuo saldo e di ${vendedores.getSaldo()} €</p>
        <br>
        
        

                        <c:if test="${insertado==true}">
                        <h2>Producto insertato</h2>
                        <a href="vendedores.html">Torna alla pagina venditore</a>
                        <br> <br> <br>
                         </c:if>
                          <c:if test="${insertado==false}">
                              <h2>Oggetti in vendita</h2>
                        <table>
                            <tr class="encabezado">
                                <th>Titolo</th>
                                <th>Copertina</th>
                                <th>Disponibilità</th>
                                <th>Prezzo</th>
                                <th>Modifica</th>
                            </tr>
                            
                            <c:forEach var="producto" items="${productos}">
                                <tr>
                                    <td>${producto.getNombre()}</td>
                                    <td><img src="${producto.getImagen()}" title="${producto.getNombre()}" 
                                             alt="${producto.getNombre()}"></td>
                                    <td>${producto.getDisponibilidad()}</td>
                                    <td>${producto.getPrecio()}</td>
                                    <td><a href="vendedores.html?idProductoBorrar=${producto.getId()}">Elimina</a><br>
                                        <a href="vendedores.html?idProductoCambiar=${producto.getId()}">Modifica</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
            
            <br><hr><br>
            <h2> Insertare nuovo oggeto</h2>
            <br>
        <form action="vendedores.html" method="post">
            <label for="nombre">Nome dello Oggeto: </label>
            <br>
            <input type="text" name="nombre" id="nombre">
            <br><br>
            <label for="img">URL della foto: </label>
            <br>
            <input type="img" name="img" id="img">
            <br><br>
            <label for="descripcion">Descrizione </label>
            <br>
            <textarea rows="5" cols="40" name="descripcion" id="descripcion" ></textarea>
            <br><br>
            <label for="precio">Prezzo </label>
            <br>
            <input type="number" name="precio" id="precio">
            <br><br>
            <label for="cantidad">Quantità </label>
            <br>
            <input type="number" name="cantidad" id="cantidad">
            <br><br>
            <input type="submit" value="Inserire" name="Insertar">
            <input type="reset" value="Cancellare">
            <br><br>
        </form>
   
            </c:if>
        </div>
        </div>
    </body>
</html>