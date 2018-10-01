<%-- 
    Document   : telaInicial
    Created on : 14/09/2018, 21:48:04
    Author     : Leonardo
--%>

<%@page import="api.modelo.Postagem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="core.servico.ServicoPostagemImpl"%>
<%@page import="api.servico.ServicoPostagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tela Inicial-Blog</title>
        <link href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
    </head>
    <body>
        <%@include file="menu.jsp" %>


        <%
            ServicoPostagem sPostagem = new ServicoPostagemImpl();
            List<Postagem> pBD = sPostagem.procurarTudo();
            for (Postagem post : pBD) {
                out.print("<section>");
                out.print("<article>");
                out.print("<h1 class='h1Titulo'>" + post.getTitulo() + "</h1>");
                out.print("<section>" + post.getPublicacao() + "</section>");
                out.print("");
                if (u != null) {
                    out.print("<form>"
                            + "<hr>"
                            + "<label for='fcomentario'>Comentar:</label><br>"
                            + "<textarea id='fcomentario' name='fcomentario' placeholder='Digite seu comentario aqui...'rows='10' cols='30'></textarea><br>"
                            + "<input type='submit' value='Comentar'>"
                            + "<hr>"
                            + "</form>");
                }
                out.print("</section>");
                out.print("</article>");

            }

        %>





        <section>
            <article>
                <h1 class="h1Titulo">Primeiro post do blog</h1>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>


                <% if (u != null) {%>
                <form>
                    <hr>
                    <label for="fcomentario">Comentar:</label><br>
                    <textarea id="fcomentario" name="fcomentario" placeholder="Digite seu comentario aqui..."rows="10" cols="30"></textarea><br>
                    <input type="submit" value="Comentar">
                    <hr>
                </form>
                <% }%>
                <div class="div_comentarios">
                    <h3 class="labelCometar">Comentarios:</h3>
                    <div class="div_comentario">
                        <hr>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                        <hr>
                    </div>

                    <div class="div_comentario">
                        <hr>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                        <hr>
                    </div>

                </div>
            </article>

        </section>
    </body>
</html>
