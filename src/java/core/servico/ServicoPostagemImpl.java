/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.PostagemDAO;
import api.dao.UsuarioDAO;
import api.modelo.Postagem;
import api.modelo.Usuario;
import api.servico.ServicoPostagem;
import core.dao.PostagemDAOMariaDB10;
import core.dao.UsuarioDAOMariaDB10;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo
 */
public class ServicoPostagemImpl implements ServicoPostagem {

    @Override
    public void inserir(Postagem postagem) {
        PostagemDAO pDAO;
        try {
            pDAO = new PostagemDAOMariaDB10();
            pDAO.inserir(postagem);

        } catch (Exception e) {
            System.out.println("Erro ao inseir postagem...ServicoPostagemImpl");
            System.out.println(e);
        }
    }

    @Override
    public Postagem procurarPorId(Integer id) {
        try {
            PostagemDAO pDao = new PostagemDAOMariaDB10();
            Postagem p = pDao.procurarPorId(id);
            return p;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Postagem> procurarTudo() {
        try {
            PostagemDAO pDao = new PostagemDAOMariaDB10();
            List<Postagem> p = pDao.procurarTudo();
            return p;
        } catch (Exception e) {
            System.out.println("erro procurarTudo postagem \n" + e);
        }
        return null;
    }

    @Override
    public Usuario atualizar(Postagem postAnt, Postagem postAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) {
        try {
            PostagemDAO pDao = new PostagemDAOMariaDB10();
            boolean retorno = pDao.excluir(id);
            return retorno;
        }catch (Exception e) {
            System.out.println("Erro para excluir por id...ServiçoPostagemImpl");
            System.out.println(e);
            return false;
        }
    }

}
