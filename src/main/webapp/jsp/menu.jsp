<%-- 
    Document   : menu
    Created on : 14/09/2018, 21:42:12
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="api.modelo.Usuario"%>
<!DOCTYPE html>
<% Usuario u = (Usuario) session.getAttribute("usuarioLogado");%>
<link rel="shortcut icon" href="Blog/favicon.ico">
<header>
    <nav class="barraNavegacao">
        <ul>
            <li><a href="/Blog/gerente?param=1">Inicio</a></li>
            <li><a href="/Blog/gerente?param=2">Sobre o blog</a></li>
                <% if (u != null && u.getPapel() == 1) {%>
            <li><a href="/Blog/gerente?param=4">Usuários</a></li>
            <li><a href="/Blog/gerente?param=5">Posts</a></li>
            <li><a href="/Blog/gerente?param=7">Comentários</a></li>
                <% } else if (u != null && u.getPapel() == 0) {%>
            <li><a href="/Blog/gerente?param=5">Posts</a></li>
            <li><a href="/Blog/gerente?param=7">Comentários</a></li>
                <% }%>



            <%
                if (u != null) {

                    out.print("<li class='nome'>" + u.getNomeUsuario() + "</li>");
                    out.print("<li id='entrar'><a href='/Blog/Autenticador.action?param=invalidate'>Sair</a></li>");
                    
                } else {
                    out.print("<li id='entrar'><a href='/Blog/gerente?param=6'>Se cadastrar!</a></li>");
                    out.print("<li id='entrar'><a href='/Blog/Login'>Entrar </a></li>");
                }


            %>
       
        </ul>
    </nav>
            <div id="spacador"></div>


</header>