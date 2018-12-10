<%-- 
    Document   : sobre
    Created on : 14/09/2018, 22:14:41
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" />
    <title>Sobre-Blog</title>
    <link href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
    <script src="./roteiro/sobre.js"></script>
    <script src="roteiro/jquery-3.3.1.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
    <%@include file="menu.jsp" %>
    <section id="s1" style="margin-top: 60px">
        <article>
            <h1 class="h1Titulo" id=1 onmouseover="trocaCor()">Sobre o Blog</h1>
            <p>
                Blog para aplicar e demostrar os conhecimentos adquiridos nas diciplinas de Engenharia de Software; 
            </p>
        </article>
        <article id='art02' onload="avaliacao()" >
            <div>Se você gostou do blog click em gostei!</div>
            <div>Gostei: <span id='spanGostei'></span></div>
               
            
        </article>
    </section>
    
</body>    