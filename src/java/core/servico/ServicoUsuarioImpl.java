/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

/**
 *
 * @author leonardo
 */
import api.dao.UsuarioDAO;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.dao.UsuarioDAOMariaDB10;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoUsuarioImpl implements ServicoUsuario {

    @Override
    public Usuario insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByNome(String nome){
        try {
            UsuarioDAO uDao = new UsuarioDAOMariaDB10();
            Usuario u = uDao.procurarPorNome(nome);
            return u;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicoUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
