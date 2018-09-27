<%-- 
    Document   : menu
    Created on : 14/09/2018, 21:42:12
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="api.modelo.Usuario"%>
<!DOCTYPE html>
<% Usuario u = (Usuario) session.getAttribute("usuarioLogado");%>
<header>
    <nav>
        <ul>
            <li><a href="/Blog/gerente?param=1">Inicio</a></li>
            <li><a href="/Blog/gerente?param=2">Sobre o blog</a></li>

            <% if (u != null) {%>
            <li class="nomeUsuario"><a href="/Blog/gerente?param=3">Olá! <%= u.getNomeUsuario()%></a></li>
                <% } else { %>
            <li  class="nomeUsuario"><a>Olá! Visitante</a></li>
                <% }%>
                <% if (u != null) {%>
                <% session.setAttribute("usuarioLogado", null);%>
            <li><a href="/Blog/gerente?param=1">Sair</a></li>
                <% } else { %>
            <li><a href="/Blog/Login">Entrar</a></li>
                <% }%>
        </ul>
    </nav>
</header>
