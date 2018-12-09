<%-- 
    Document   : admUsuario
    Created on : 28/09/2018, 15:27:09
    Author     : leonardo
--%>

<%@page import="java.util.List"%>
<%@page import="api.modelo.Usuario"%>
<%@page import="core.servico.ServicoUsuarioImpl"%>
<%@page import="api.servico.ServicoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" />
        <title>Adm Usuários-Blog</title>
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
                        <input type="radio" name="papel" value="1" checked> Administrador<br>
                        <input type="radio" name="papel" value="0"> Usuário comum<br>
                    </label>

                    <input type="submit" value="Adicionar" class="submitButton">                
                </form>
            </article>
            <article style="overflow-x:auto;">
                <h2 >Usuários cadastrados</h2>
                <hr>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Tipo de usuário</th>
                        <!--<th>Editar</th>-->
                        <th>Excluir</th>
                    </tr>
                    <%                        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
                        List<Usuario> uBD = sUsuario.procurarTudo();
                        for (Usuario usuario : uBD) {
                            out.print("<tr>");
                            out.print("<td>" + usuario.getId().toString() + "</td>");
                            out.print("<td>" + usuario.getNome() + "</td>");
                            out.print("<td>" + usuario.getNomeUsuario() + "</td>");
                            out.print("<td>" + usuario.getEmail() + "</td>");
                            out.print("<td>" + (usuario.getPapel() == 1 ? "Administrador" : "Comum") + "</td>");
                    %>

                    <td> <a href="AdmUsuario?paramExcluir=<%=usuario.getId().toString()%>">Excluir esse!</a>
                    </td>
                    <%
                            out.print("</tr>");
                        }
                    %>
                </table>
                <hr>
            </article>
        </section>
    </body>
</html>
