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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "AdmUsuario", urlPatterns = {"/AdmUsuario"})
public class AdmUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        Integer idExcluir = Integer.parseInt(req.getParameter("paramExcluir"));
        //Integer idEditar = Integer.parseInt(req.getParameter("paramEditar"));

        try {
            if (idExcluir != 0) {
                ServicoUsuario sUsuario = new ServicoUsuarioImpl();
                boolean uBD = sUsuario.excluir(idExcluir);
                res.sendRedirect("/Blog/gerente?param=4");
            }
        } catch (Exception e) {

        }

    }

}
