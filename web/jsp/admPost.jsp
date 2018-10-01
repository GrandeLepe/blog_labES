<%-- 
    Document   : admPost
    Created on : 30/09/2018, 11:29:42
    Author     : leonardo
--%>

<%@page import="api.servico.ServicoUsuario"%>
<%@page import="api.modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page import="core.servico.ServicoPostagemImpl"%>
<%@page import="api.servico.ServicoPostagem"%>
<%@page import="core.servico.ServicoUsuarioImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Adm Post-Blog</title>
        <link href ="estilos/estiloAdmUsuario.css" rel ="stylesheet" type ="text/css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <section>
            <article> 
                <h2>Adicionar postagem</h2>
                <hr>
                <form class="baseForm" action="AdmPostagemAdicionar" method="post">
                    <label class="formLabel">
                        Titulo:
                        <input name="titulo" type="text" required class="formInput formTextInput">
                    </label>
                    <label class="formLabel">
                        Texto:
                        <%-- <input name="publicacao" type="text" required class="formInput formTextInput"> --%>
                        <textarea name="publicacao" rows="10" cols="30"></textarea>
                    </label>
                    <input type="submit" value="Postar" class="submitButton">                
                </form>
            </article>


            <article style="overflow-x:auto;">
                <h2 >Usuários cadastrados</h2>
                <hr>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Nome do Autor</th>
                        <th>Data de postagem</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                    <%
                        ServicoPostagem sPostagem = new ServicoPostagemImpl();
                        List<Postagem> sBD = sPostagem.procurarTudo();
                        for (Postagem postagem : sBD) {
                            ServicoUsuario uBD = new ServicoUsuarioImpl();
                            
                            out.print("<tr>");
                            out.print("<td>" + postagem.getId_post().toString() + "</td>");
                            out.print("<td>" + postagem.getTitulo()+ "</td>");
                            out.print("<td>" + uBD.procurarPorId(postagem.getId_autor()).getNome() + "</td>");
                            out.print("<td>" + postagem.getData() + "</td>");
                    %>
                    <td> <a href="AdmPost?paramEditar=<%=postagem.getId_post().toString()%>">Editar esse!</a>
                    <td> <a href="AdmPost?paramExcluir=<%=postagem.getId_post().toString()%>">Excluir esse!</a>
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
