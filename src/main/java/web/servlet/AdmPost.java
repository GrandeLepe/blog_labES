/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.servico.ServicoPostagem;
import api.servico.ServicoUsuario;
import core.servico.ServicoPostagemImpl;
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
@WebServlet(name = "AdmPost", urlPatterns = {"/AdmPost"})
public class AdmPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer idExcluir = Integer.parseInt(req.getParameter("pExcluir"));
        Integer idEditar = Integer.parseInt(req.getParameter("pEditar"));

        try {
            if (idEditar > 0) {

                ServletContext sc = req.getServletContext();
//                sc.setAttribute("idEditar", idEditar);
                req.setAttribute("idPost", idEditar);
                
                sc.getRequestDispatcher("/jsp/editaPost.jsp").forward(req, resp);
//                ServicoPostagem sPostagem = new ServicoPostagemImpl();

            }
            if (idExcluir > 0) {

                ServicoPostagem sPostagem = new ServicoPostagemImpl();

                boolean pBD = sPostagem.excluir(idExcluir);
                
                resp.sendRedirect("/Blog/gerente?param=5");
            }
        } catch (Exception e) {

        }
    }

}
