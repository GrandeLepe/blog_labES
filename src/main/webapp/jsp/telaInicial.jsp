<%-- 
    Document   : telaInicial
    Created on : 14/09/2018, 21:48:04
    Author     : Leonardo
--%>

<%@page import="api.modelo.Comentario"%>
<%@page import="core.servico.ServicoComentarioImpl"%>
<%@page import="api.servico.ServicoComentario"%>
<%@page import="api.servico.ServicoComentario"%>
<%@page import="api.modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="core.servico.ServicoPostagemImpl"%>
<%@page import="api.servico.ServicoPostagem"%>
<%@page import="api.servico.ServicoUsuario"%>
<%@page import="core.servico.ServicoUsuarioImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tela Inicial-Blog</title>
        <link href="estilos/estilo.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <%@include file="menu.jsp" %>


        <%
            ServicoPostagem sPostagem = new ServicoPostagemImpl();
            List<Postagem> pBD = sPostagem.procurarTudo();
            ServicoComentario sComentario = new ServicoComentarioImpl();
            ServicoUsuario sUsuario = new ServicoUsuarioImpl();
            Usuario usr;
            for (Postagem post : pBD) {
                usr = sUsuario.procurarPorId(post.getId_autor());
                List<Comentario> cBD = sComentario.procurarTudoId_post(post.getId_post());
                out.print("<section>");
                out.print("<article>");
                out.print("<h1 class='h1Titulo'>" + post.getTitulo() + "</h1>");
                out.print("<section>" + post.getPublicacao() + "</section>");
                out.print("<h4>Publicado em: " + post.getData() + "</h4>");
                out.print("<h3 class='autorFont'>Autor: " + usr.getNome() + "</h3>");

                if (u != null) {
                    //TODO corrigir para pegar o id do usuario que postou
                    out.print("<form class='baseForm' action='AdmComentarioAdicionar?idAutor=" + u.getId() + "&idPost=" + post.getId_post() + "' method='post'>"
                            + "<hr>"
                            + "<label for='fcomentario'>Comentar:</label><br>"
                            + "<textarea id='comentario' name='comentario' placeholder='Digite seu comentario aqui...'rows='10' cols='30'></textarea><br>"
                            + "<input type='submit' value='Comentar'>"
                            + "<hr>"
                            + "</form>");
                }
                out.print("<div class='div_comentarios'>"
                        + "<h3 class='labelCometar'>Comentarios:</h3>");
                for (Comentario comentario : cBD) {
                    usr = sUsuario.procurarPorId(comentario.getId_autor());
                    out.print("<div class='div_comentario'><hr><p>");
                    out.print(comentario.getComentario());
                    out.print("</p><br>");
                    out.print("Data do comentario: " + comentario.getData());
                    out.print("<br><span class='autorFont'>Autor: " + usr.getNome());
                    out.print("</span><hr></div>");

                }
                out.print("</section>");
                out.print("</article>");

            }

        %>

        <div class="footer">
            <p>Blog de aprendizado.</p>
        </div>
    </body>

</html>