/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Postagem;
import api.modelo.Usuario;
import api.servico.ServicoPostagem;
import api.servico.ServicoUsuario;
import core.servico.ServicoPostagemImpl;
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
@WebServlet(name = "AdmPostagemAdicionar", urlPatterns = {"/AdmPostagemAdicionar"})
public class AdmPostagemAdicionar extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            String titulo = req.getParameter("titulo");
            String publicacao = req.getParameter("publicacao");
            Integer id_autor = Integer.parseInt(req.getParameter("id_autor"));
            
            
            Postagem postagem = new Postagem();
            postagem.setTitulo(titulo);
            postagem.setPublicacao(publicacao);
            postagem.setId_autor(id_autor);
                 
            ServicoPostagem sPostagem = new ServicoPostagemImpl();
            sPostagem.inserir(postagem);
            res.sendRedirect("/Blog/gerente?param=5");
        } catch (Exception e) {
            System.out.println("erro adicionar postagem...AdmPostagemAdicionar");
            System.out.println(e);
        }

    }
}
