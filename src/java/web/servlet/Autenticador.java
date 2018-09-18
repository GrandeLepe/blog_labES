/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.EnumPapeis;
import api.modelo.Papel;
import api.modelo.Usuario;
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
    private List<Usuario> usuarios;
    private List<Papel> papeis;
    
    public Autenticador(){
        usuarios = new ArrayList();
        papeis = new ArrayList();
        papeis.add(new Papel(EnumPapeis.ADMINISTRADOR));
        papeis.add(new Papel(EnumPapeis.USUARIO_COMUM));
        //Criação do primeiro usuário do sistema
        Usuario u1 = new Usuario();
        u1.setEmail("grande@lepe.com");
        u1.setNomeCompleto("Grande Lepe");
        u1.setSenha("1");
        u1.setNomeUsuario("1");
        u1.setPapeis(papeis);        
        usuarios.add(u1);
        //Criação do segundo usuário do sistema
        papeis = new ArrayList();
        papeis.add(new Papel(EnumPapeis.USUARIO_COMUM));
        u1 = new Usuario();
        u1.setEmail("pequena@mimi.com");
        u1.setNomeCompleto("Pequena Mimi");
        u1.setSenha("2");
        u1.setNomeUsuario("2");
        u1.setPapeis(papeis);
        usuarios.add(u1);  
        //hard code para teste
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServletContext sc = req.getServletContext();
        Usuario uLogado = null;
        for(Usuario u: usuarios){
            if ( nomeUsuario.equals(u.getNomeUsuario()) 
                 && senha.equals(u.getSenha()) ){
                uLogado = u;
                break;
            }
        }
        if ( uLogado!= null){ //Login efetuado com sucesso
            req.setAttribute("usuarioLogado", uLogado);
            try {
                sc.getRequestDispatcher("/jsp/telaInicial.jsp").forward(req, resp);  
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }                       
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }    
    }
}