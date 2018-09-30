/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.servico.ServicoUsuarioImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "admUsusarioAdicionar", urlPatterns = {"/admUsusarioAdicionar"})
public class admUsusarioAdicionar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            String nome = req.getParameter("nome");
            String senha = req.getParameter("senha");
            String nomeUsuario = req.getParameter("nomeUsuario");
            String email = req.getParameter("email");
            Integer papel = Integer.parseInt(req.getParameter("papel"));
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setNomeUsuario(nomeUsuario);
            usuario.setEmail(email);
            usuario.setPapel(papel);
            ServicoUsuario sUsuario = new ServicoUsuarioImpl();
            sUsuario.inserir(usuario);
            res.sendRedirect("/Blog/gerente?param=4");
        } catch (Exception e) {
            System.out.println("erro adicionar usuario...admUsusarioAdicionar");
            System.out.println(e);
        }

    }

}