/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import api.dao.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author leonardo
 */
public class UsuarioDAOMariaDB10 implements UsuarioDAO {

    private Connection conexao;

    public UsuarioDAOMariaDB10() throws ClassNotFoundException {
        conexao = Fabrica.obterConexao();

    }

    @Override
    public int inserir(Usuario usuario) {
        int retorno = 0;
        try {
            //PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO usuario VALUE(?,?,?,?,?,?)");
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO blog.usuario (nome,senha,nomeUsuario,email,papel) VALUES (?,?,?,?,?)");
            System.out.println(usuario);
            //comandoSQL.setString(1, usuario.getId().toString());
            comandoSQL.setString(1, usuario.getNome());
            comandoSQL.setString(2, usuario.getSenha());
            comandoSQL.setString(3, usuario.getNomeUsuario());
            comandoSQL.setString(4, usuario.getEmail());
            comandoSQL.setString(5, usuario.getPapel().toString());
            
            retorno = comandoSQL.executeUpdate();
            comandoSQL.close();
            if(retorno != 1 ){
                System.out.println("Erro ao adicionar usuario");
            }
            else if(retorno == 1){
                System.out.println("Adicionado com sucesso!");
            }
            return retorno;
        } catch (Exception e) {
            System.out.println(e);

        }
        return retorno;
    }

    @Override
    public Usuario procurarPorId(Integer id) {
        Usuario u = null;
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from blog.usuario where id = ?");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado...(metodo procurar por id)");
            rs.next();
            u = new Usuario();
            u.setId(rs.getLong(1));
            u.setNome(rs.getString(2));
            u.setSenha(rs.getString(3));
            u.setNomeUsuario(rs.getString(4));
            u.setEmail(rs.getString(5));
            u.setPapel(rs.getInt(6));
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;

        } catch (SQLException ex) {
            System.out.print("\nErro de conexão... procurar por id");
            return u;
        }

    }

    @Override
    public Usuario procurarPorNome(String nomeUsuario) {
        Usuario u = null;
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from blog.usuario where nome = ?");
            comandoSQLp.setString(1, nomeUsuario);
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado...(metodo procurar por nome)");
            rs.next();
            u = new Usuario();
            u.setId(rs.getLong(1));
            u.setNome(rs.getString(2));
            u.setSenha(rs.getString(3));
            u.setNomeUsuario(rs.getString(4));
            u.setEmail(rs.getString(5));
            u.setPapel(rs.getInt(6));
            /* Se utilizar o padrão singleton, não fechar a conexão. */
            comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;

        } catch (SQLException ex) {
            System.out.print("\nErro de conexão... procurar por nome");
            System.out.println(ex);
        }
        return u;
    }

    @Override
    public Usuario procurarPorNomeUsuario(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> procurarTudo() {

        List<Usuario> usuarios = new ArrayList<>();
        try {
            //PreparedStatement comandoSQLp = conexao.prepareStatement("select count(*) from blog.usuario");
            PreparedStatement comandoSQLp = conexao.prepareStatement("SELECT id FROM blog.usuario");
            ResultSet rs = comandoSQLp.executeQuery();

            while (rs.next()) {
                usuarios.add(procurarPorId(rs.getInt(1)));
                System.out.println(rs.getInt(1));
            }
            return usuarios;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario atualizar(Usuario usuarioAnt, Usuario usuarioAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) {
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("delete from blog.usuario where id = ?");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println(rs.getBoolean(0));
            return rs.getBoolean(0);
        } catch (Exception e) {
            System.out.println("Erro para excluir por id... usuarioDAOMariaDB10");
            System.out.println(e);
        }
        return false;
    }

}
