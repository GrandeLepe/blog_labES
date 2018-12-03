/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.controle.ControleSessao;
import api.dao.UsuarioDAO;
import api.modelo.EnumPapeis;
import api.modelo.Papel;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.dao.UsuarioDAOMariaDB10;
import core.servico.ServicoUsuarioImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "Autenticador", urlPatterns = {"/Autenticador.action"})
public class Autenticador extends HttpServlet {

    HttpSession sessao;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String i = req.getParameter("param");
        System.out.println(i);
        try {
            sessao.invalidate();
            ServletContext sc = req.getServletContext();
            sc.getRequestDispatcher("/jsp/telaInicial.jsp").forward(req, resp);
        } catch (IOException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
        }

        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");

        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
        Usuario uBD = sUsuario.procurarPorNome(nomeUsuario);

        ServletContext sc = req.getServletContext();

        if (uBD.getNome() != null && uBD.getSenha() != null
                && uBD.getSenha().equals(senha) && uBD.getNome().equals(nomeUsuario)) {

            try {
                sessao = req.getSession();
                sessao.setAttribute("usuarioLogado", uBD);
                //req.setAttribute("usuarioLogado", uBD);
                //ControleSessao.adicionarSessao(uBD.getId().toString());
                sc.getRequestDispatcher("/jsp/telaInicial.jsp").forward(req, resp);
            } catch (Exception e) {

            }
        } else {
            try {
                req.setAttribute("falhaAutenticacao", true);
//                sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/Login?erro=true");

            } catch (Exception e) {
                System.out.println(e);
            }
        }//if-else 
    }//doPost
}//Autenticador.java
