<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Carro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jorge Sanchez">
        <meta name="keywords" content="Milestone 4, carro">
        <meta name="description" content="Pagina di carro">
        <link rel="stylesheet" type="text/css" href="css/mystyle.css" media="screen">
    </head>
    <body>
        <div class="web">
            <header>
                   <h1>Movil Mania</h1>
                    <p>Acquisto</p>
                
            </header>

                <nav class="navegacion">
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="cliente.html">Torna alla pagina Cliente</a></li>
                    </ul>
                </nav>

            <div class="contenido">
                <h2>Conferma</h2>
                <div id="form">
                    <c:if test="${exito==true}">
                        <p>l'acquisto del prodotto "${producto.getNombre()}" è stata confermata </p>
                    </c:if>
                    <c:if test="${exito==false}">
                        <p>l'acquisto del prodotto "${producto.getNombre()}" non è stata confermata </p>
                        <p>controllare il suo saldo</p>
                    </c:if>    
                        
                </div>
            </div>
        </div>
    </body>
</html>