/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Comentario;
import api.modelo.Postagem;
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
import uteis.Sanitizador;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "AdmComentarioAdicionar", urlPatterns = {"/AdmComentarioAdicionar"})
public class AdmComentarioAdicionar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            //TODO Corrigir os parametrod que vem do jsp
            Integer idAutor = Integer.parseInt(req.getParameter("idAutor"));
            Integer idPost = Integer.parseInt(req.getParameter("idPost"));
            String comentario = req.getParameter("comentario");
            
            String comentarioLimpo;
            
            System.out.println(comentario);
            
            Sanitizador s = new Sanitizador();
            comentarioLimpo = s.verificaPalavra(comentario);
            
            System.out.println(comentarioLimpo);
            
            Comentario comentarioObj =  new Comentario();
            comentarioObj.setId_autor(idAutor);
            comentarioObj.setId_post(idPost);
            comentarioObj.setComentario(comentarioLimpo);
            
            ServicoComentario sComentario = new ServicoComentarioImpl();
            sComentario.inserir(comentarioObj);
            res.sendRedirect("/Blog/gerente?param=1");
        } catch (Exception e) {
            System.out.println("erro adicionar postagem...AdmComentarioAdicionar");
            System.out.println(e);
        }

    }

}
