<%-- 
    Document   : editaPost
    Created on : 03/12/2018, 21:39:49
    Author     : leonardo
--%>

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
        <title>Adm Post-Blog</title>
        <link href="estilos/estiloAdmUsuario.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <%@include file="menu.jsp" %>
        <%            Integer idPost = (Integer) request.getAttribute("idPost");
            System.out.println("editar o id: " + idPost);
            ServicoPostagem sPostagem = new ServicoPostagemImpl();
            Postagem post = sPostagem.procurarPorId(idPost);

        %>
        <section>
            <article>
                <h2>Adicionar postagem</h2>
                <hr>
                <form class="baseForm" action="AdmPostagemAdicionar?param=editar" method="post">
                    <label class="formLabel">
                        Titulo:
                        <input name="titulo" type="text" value="<%=post.getTitulo()%>" required class="formInput formTextInput">
                    </label>
                    <label class="formLabel">
                        Texto:
                        <textarea name="publicacao" rows="10" cols="30"><%=post.getPublicacao()%></textarea>
                    </label>
                        <input  hidden type="radio" name="idPost" value=<%=idPost%> checked>
                        <input  hidden type="radio" name="idAutor" value=<%=post.getId_autor()%> checked>
                    <input type="submit" value="Postar" class="submitButton">
                </form>
            </article>
        </section>
    </body>
</html>