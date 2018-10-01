<%-- 
    Document   : cadastroUsuario
    Created on : 01/10/2018, 07:44:27
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Autocadastro-Blog</title>
        <link href ="estilos/estiloAdmUsuario.css" rel ="stylesheet" type ="text/css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <section>
            <article> 
                <h2>Adicionar usuário</h2>
                <hr>
                <form class="baseForm" action="AdmUsusarioAdicionar" method="post">
                    <label class="formLabel">
                        Nome de Usuário(Apelido):
                        <input name="nome" type="text" required class="formInput formTextInput">
                    </label>
                    <label class="formLabel">
                        Senha:
                        <input name="senha" type="password" required class="formInput formTextInput">
                    </label>
                    <label class="formLabel">
                        Nome completo:
                        <input name="nomeUsuario" type="text" required class="formInput formTextInput">
                    </label>
                    <label class="formLabel">
                        Email de contato:
                        <input name="email" type="email" required class="formInput formTextInput">
                    </label>
                    <label class="formLabel">
                        Tipo de usuário:<br>
                        <input type="radio" name="papel" value="0"> Usuário comum<br>
                    </label>

                    <input type="submit" value="Adicionar" class="submitButton">                
                </form>
            </article>
        </section>
    </body>
</html>
