/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.servico.ServicoComentario;
import api.servico.ServicoPostagem;
import core.servico.ServicoComentarioImpl;
import core.servico.ServicoPostagemImpl;
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
@WebServlet(name = "AdmComentario", urlPatterns = {"/AdmComentario"})
public class AdmComentario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Integer idExcluir = Integer.parseInt(req.getParameter("paramExcluir"));

        try {
            if (idExcluir != 0) {

                ServicoComentario sComentario = new ServicoComentarioImpl();

                boolean pBD = sComentario.excluir(idExcluir);

                res.sendRedirect("/Blog/gerente?param=7");
            }
        } catch (Exception e) {

        }
    }
}
