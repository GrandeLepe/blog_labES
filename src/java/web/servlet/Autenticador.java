/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.dao.UsuarioDAO;
import api.modelo.EnumPapeis;
import api.modelo.Papel;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.dao.UsuarioDAOMariaDB10;
import core.servico.ServicoUsuarioImpl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "Autenticador", urlPatterns = {"/Autenticador.action"})
public class Autenticador extends HttpServlet {   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
        Usuario uBD = sUsuario.findByNome(nomeUsuario); 
        System.out.println(uBD);
        ServletContext sc = req.getServletContext();
        if (uBD!= null && uBD.getSenha().equals(senha)){
            try{
                req.setAttribute("usuarioLogado",uBD);
                sc.getRequestDispatcher("/jsp/telaInicial.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }            
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }//if-else 
    }//doPost
}//Autenticador.java