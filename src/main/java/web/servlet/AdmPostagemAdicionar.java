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

        if (req.getParameter("param") != null && req.getParameter("param").equals("editar")) {
            String i = req.getParameter("param");
            System.out.println(i);
            try {
                String titulo = req.getParameter("titulo");
                String publicacao = req.getParameter("publicacao");
                Integer idAutor= Integer.parseInt(req.getParameter("idAutor"));
                Integer idPost = Integer.parseInt(req.getParameter("idPost"));
                
                Postagem postagem = new Postagem();
                postagem.setTitulo(titulo);
                postagem.setPublicacao(publicacao);
                postagem.setId_autor(idAutor);
                
                ServicoPostagem sPostagem = new ServicoPostagemImpl();
                sPostagem.atualizar(idPost, postagem);
                
                res.sendRedirect("/Blog/gerente?param=5");
                
                
            } catch (Exception e) {
                System.out.println("erro ao auterar postagem...AdmPostagemAdicionar");
                System.out.println(e);
            }
        } else {

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
}
