<%-- 
    Document   : admComentarios
    Created on : 03/10/2018, 21:29:15
    Author     : leonardo
--%>

<%@page import="api.modelo.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="api.servico.ServicoComentario"%>
<%@page import="core.servico.ServicoComentarioImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Adm Comentario-Blog</title>
        <link href ="estilos/estiloAdmUsuario.css" rel ="stylesheet" type ="text/css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <section>
            <article> 
                <h2 >Comentários publicados</h2>
                <hr>
                <table>
                    <tr>
                        <th>ID Comentario</th>
                        <th>Título Post</th>
                        <th>Nome do Autor</th>
                        <th>Comentário</th>
                        <th>Data de postagem</th>
                        <!--<th>Editar</th>-->
                        <th>Excluir</th>
                    </tr>
                    <%
                        ServicoComentario sComentario = new ServicoComentarioImpl();
                        List<Comentario> sBD = sComentario.procurarTudo();
                        for (Comentario comentario : sBD) {

                            out.print("<tr>");
                            out.print("<td>" + comentario.getId_comentario().toString() + "</td>");
                            out.print("<td>" + comentario.getTituloPost() + "</td>");
                            out.print("<td>" + comentario.getNomeAutor() + "</td>");
                            out.print("<td>" + comentario.getComentario() + "</td>");
                            out.print("<td>" + comentario.getData() + "</td>");
                    %>
                    <td> <a href="AdmComentario?paramExcluir=<%=comentario.getId_comentario().toString()%>">Excluir esse!</a>
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
