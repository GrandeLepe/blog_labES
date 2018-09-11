<%-- 
    Document   : login
    Created on : 10/09/2018, 19:39:22
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href ="estilos/estilo2.css" rel ="stylesheet" type ="text/css">
        <title>Blog-Login</title>
    </head>
    <body>
        <form class="baseForm" action="Autenticador.action" method="post">
            <label class="formLabel">
                Nome de Usuário:
                <input name="nomeUsuario" type="text" required class="formInput formTextInput">
            </label>
            <label class="formLabel">
                Senha:
                <input name="senha" type="password" required class="formInput formTextInput">
           </label>
                <input type="submit" value="Entrar" class="submitButton">                
        </form>       
    </body>
</html>
