/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.usuarioDAO;
import api.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class usuarioDAOMariaDB10 implements usuarioDAO {

    private Connection conexao;

    public usuarioDAOMariaDB10() throws ClassNotFoundException {
        conexao = Fabrica.obterConexao();
    }

    @Override
    public int insert(Usuario usuario) {
        int retorno = 0;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO usuario VALUE(?,?,?,?,?)");
            comandoSQL.setString(1, usuario.getId().toString());
            comandoSQL.setString(2, usuario.getUsuario());
            comandoSQL.setString(3, usuario.getSenha());
            comandoSQL.setString(4, usuario.getNomeCompleto());
            comandoSQL.setString(5, usuario.getEmail());

            retorno = comandoSQL.executeUpdate();
            comandoSQL.close();
            return retorno;
        } catch (Exception e) {

            
        }
        return retorno;
    }

    @Override
    public Usuario findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByNomeUsuario(String nomeUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario update(Usuario usuarioAnt, Usuario usuarioAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
