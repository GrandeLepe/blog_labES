<%-- 
    Document   : painel
    Created on : 27/09/2018, 11:20:15
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Painel de controle - Blog</title>
        <title>Tela Inicial-Blog</title>
        <link href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <section>
            <article>
                <h1>Painel de controle</h1>
                <nav>
        <ul>
            <li><a href="/Blog/gerente?param=">Usuarios</a></li>
            <li><a href="/Blog/gerente?param=">Postagens</a></li>    
            <li><a href="/Blog/Login">Sair </a></li>
                
        </ul>
    </nav>
            </article>
        </section>
    </body>
</html>
