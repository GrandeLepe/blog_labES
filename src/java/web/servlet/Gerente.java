/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
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
@WebServlet(name = "gerente", urlPatterns = {"/gerente"})
public class Gerente extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext sc = req.getServletContext();
        String i = req.getParameter("param");
        try {
            if (i.equals("1")) {
                sc.getRequestDispatcher("/jsp/telaInicial.jsp").forward(req, resp);
            } else if (i.equals("2")) {
                sc.getRequestDispatcher("/jsp/sobre.jsp").forward(req, resp);
            } else if (i.equals("3")) {
                sc.getRequestDispatcher("/jsp/painel.jsp").forward(req, resp);
            }

        } catch (Exception e) {
        }
    }

}
