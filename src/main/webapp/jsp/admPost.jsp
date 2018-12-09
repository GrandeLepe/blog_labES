<%-- 
    Document   : admPost
    Created on : 30/09/2018, 11:29:42
    Author     : leonardo
--%>


<%@page import="core.servico.ServicoComentarioImpl"%>
<%@page import="api.servico.ServicoComentario"%>
<%@page import="api.servico.ServicoUsuario"%>
<%@page import="api.modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page import="core.servico.ServicoPostagemImpl"%>
<%@page import="api.servico.ServicoPostagem"%>
<%@page import="core.servico.ServicoUsuarioImpl"%>
<%@page import="api.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" />
        <title>Adm Post-Blog</title>
        <link href="estilos/estiloAdmUsuario.css" rel="stylesheet" type="text/css">
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
                        <textarea name="publicacao" rows="10" cols="30"></textarea>
                    </label>
                    <input hidden type="radio" name="id_autor" value=<%=u.getId()%> checked>
                    <input type="submit" value="Postar" class="submitButton">
                </form>
            </article>


            <article style="overflow-x:auto;">
                <h2>Publicações</h2>
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
                        ServicoComentario sComentario = new ServicoComentarioImpl();

                        System.out.println(u.getNome());

                        List<Postagem> sBD = null;

                        if (u.getPapel() == 1) {
                            sBD = sPostagem.procurarTudo();
                        } else {
                            sBD = sPostagem.procurarTudoDoAutor(u.getId());
                        }

                        for (Postagem postagem : sBD) {
                            ServicoUsuario uBD = new ServicoUsuarioImpl();

                            out.print("<tr>");
                            out.print("<td>" + postagem.getId_post().toString() + "</td>");
                            out.print("<td>" + postagem.getTitulo() + "</td>");
                            out.print("<td>" + uBD.procurarPorId(postagem.getId_autor()).getNome() + "</td>");
                            out.print("<td>" + postagem.getData() + "</td>");
                            if (sComentario.procurarTudoId_post(postagem.getId_post()).isEmpty()) {
                                out.print("<td> <a href='AdmPost?pExcluir=-1&pEditar=" + postagem.getId_post().toString() + "'>Editar</a></td>");
                            } else {
                                out.print("<td> <a>-</a></td>");
                            }
                            out.print("<td> <a href='AdmPost?pExcluir=" + postagem.getId_post().toString() + "&pEditar=-1'>Excluir</a></td>");
                            out.print("</tr>");
                        }
                    %>
                </table>
                <hr>
            </article>
        </section>
    </body>

</html>