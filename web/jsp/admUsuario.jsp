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
        <title>Adm Usuarios-Blog</title>
        <link href ="estilos/estilo.css" rel ="stylesheet" type ="text/css">
        <link href ="estilos/admUsuarioTabela.css" rel ="stylesheet" type ="text/css">
    </head>
    <body>
        <section>
            <article> 
                <%
                    ServicoUsuario sUsuario = new ServicoUsuarioImpl();
                    List<Usuario> uBD = sUsuario.procurarTudo();
                    for (Usuario usuario : uBD) {
                        out.print(usuario.getNomeUsuario());
                        out.print("<br>");
                    }
                %>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Nome</th>
                    </tr>
                    <tr>
                        <td>Alfreds Futterkiste</td>
                        <td>Maria Anders</td>
                        <td>Germany</td>
                    </tr>
                    <tr>
                        <td>Centro comercial Moctezuma</td>
                        <td>Francisco Chang</td>
                        <td>Mexico</td>
                    </tr>
                    <tr>
                        <td>Ernst Handel</td>
                        <td>Roland Mendel</td>
                        <td>Austria</td>
                    </tr>
                    <tr>
                        <td>Island Trading</td>
                        <td>Helen Bennett</td>
                        <td>UK</td>
                    </tr>
                    <tr>
                        <td>Laughing Bacchus Winecellars</td>
                        <td>Yoshi Tannamuri</td>
                        <td>Canada</td>
                    </tr>
                    <tr>
                        <td>Magazzini Alimentari Riuniti</td>
                        <td>Giovanni Rovelli</td>
                        <td>Italy</td>
                    </tr>
                </table>
            </article>
        </section>
    </body>
</html>
