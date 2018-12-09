/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.ComentarioDAO;
import api.dao.PostagemDAO;
import api.modelo.Comentario;
import api.modelo.Postagem;
import api.servico.ServicoComentario;
import core.dao.ComentarioDAOMariaDB10;
import core.dao.PostagemDAOMariaDB10;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo
 */
public class ServicoComentarioImpl implements ServicoComentario {

    @Override
    public Integer inserir(Comentario comentario) {

        try {
            ComentarioDAO cDAO = new ComentarioDAOMariaDB10();
            cDAO.inserir(comentario);

        } catch (Exception e) {
            System.out.println("Erro ao inseir comentario...ServicoComentarioImpl");
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Comentario procurarPorId(Integer id) {
        try {
            ComentarioDAO cDAO = new ComentarioDAOMariaDB10();
            Comentario c = cDAO.procurarPorId(id);
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Comentario> procurarTudo() {
        try {
            ComentarioDAO cDAO = new ComentarioDAOMariaDB10();
            List<Comentario> c = cDAO.procurarTudo();
            return c;
        } catch (Exception e) {
            System.out.println("erro procurarTudo comentario...ServicoComentarioImpl \n" + e);
        }
        return null;
    }

    @Override
    public List<Comentario> procurarTudoId_post(Integer id) {
        try {
            ComentarioDAO cDAO = new ComentarioDAOMariaDB10();
            List<Comentario> c = cDAO.procurarTudoId_post(id);
            return c;
        } catch (Exception e) {
            System.out.println("erro procurarTudoId_post comentario...ServicoComentarioImpl \n" + e);
        }
        return null;
    }

    @Override
    public Comentario atualizar(Comentario comentarioAnt, Comentario comentarioAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) {
        try {
            ComentarioDAO cDAO = new ComentarioDAOMariaDB10();
            boolean retorno = cDAO.excluir(id);
            return retorno;
        } catch (Exception e) {
            System.out.println("Erro para excluir por id...ServicoComentarioImpl");
            System.out.println(e);
            return false;
        }

    }

    @Override
    public List<Comentario> procurarTudoIdAutor(Integer id) {
        try {
            ComentarioDAO cDAO = new ComentarioDAOMariaDB10();
            List<Comentario> c = cDAO.procurarTudoIdAutor(id);
            return c;
        } catch (Exception e) {
            System.out.println("erro procurarTudoId_post comentario...ServicoComentarioImpl \n" + e);
        }
        return null;
    }

}
