/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ComentarioDAO;
import api.modelo.Comentario;
import api.modelo.Postagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class ComentarioDAOMariaDB10 implements ComentarioDAO {

    private Connection conexao;

    public ComentarioDAOMariaDB10() throws ClassNotFoundException {
        conexao = Fabrica.obterConexao();
    }

    @Override
    public Integer inserir(Comentario comentario) {

        Integer retorno = 0;
        try {
            //PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO usuario VALUE(?,?,?,?,?,?)");
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO blog.comentario(id_autor, id_post, comentario) VALUES( ?,  ?,  ?)");

            comandoSQL.setString(1, comentario.getId_autor().toString());
            comandoSQL.setString(2, comentario.getId_post().toString());
            comandoSQL.setString(3, comentario.getComentario());

            retorno = comandoSQL.executeUpdate();
            comandoSQL.close();
            if (retorno != 1) {
                System.out.println("Erro ao adicionar comentario");
            } else if (retorno == 1) {
                System.out.println("Comentario adicionado com sucesso!");
            }
            return retorno;
        } catch (Exception e) {
            System.out.println(e);

        }
        return retorno;
    }

    @Override
    public Comentario procurarPorId(Integer id) {
        Comentario c = null;
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("select c.*, u.nomeUsuario, p.titulo "
                    + "from blog.comentario c,blog.usuario u, blog.postagem p "
                    + "where c.id_comentario = ? "
                    + "and c.id_autor = u.id "
                    + "and c.id_post = p.id_post");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado comentario...(metodo procurar por id_comentario)");
            rs.next();
            c = new Comentario();
            c.setId_comentario(rs.getInt(1));
            c.setId_autor(rs.getInt(2));
            c.setId_post(rs.getInt(3));
            c.setComentario(rs.getString(4));
            c.setData(rs.getString(5));
            c.setNomeAutor(rs.getString(6));
            c.setTituloPost(rs.getString(7));

            comandoSQLp.close();
            rs.close();

            return c;

        } catch (SQLException ex) {
            System.out.print("\nErro de conexão... procurar por id");
            return c;
        }
    }

    @Override
    public List<Comentario> procurarTudo() {
        List<Comentario> comentarios = new ArrayList<>();
        try {

            PreparedStatement comandoSQLp = conexao.prepareStatement("SELECT id_comentario FROM blog.comentario");
            ResultSet rs = comandoSQLp.executeQuery();

            while (rs.next()) {
                comentarios.add(procurarPorId(rs.getInt(1)));
                System.out.println(rs.getInt(1));
            }
            return comentarios;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Comentario> procurarTudoId_post(Integer id) {
        List<Comentario> comentarios = new ArrayList<>();
        Comentario comentario;
        try {

            PreparedStatement comandoSQLp = conexao.prepareStatement("SELECT id_comentario FROM blog.comentario");
            ResultSet rs = comandoSQLp.executeQuery();

            while (rs.next()) {
                comentario = procurarPorId(rs.getInt(1));
                if (comentario.getId_post() == id) {
                    comentarios.add(comentario);
                }

            }
            return comentarios;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Comentario atualizar(Comentario comentarioAnt, Comentario comentarioAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) {
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("delete from blog.comentario where id_comentario = ?");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println(rs.getBoolean(0));
            return rs.getBoolean(0);
        } catch (Exception e) {
            System.out.println("Erro para excluir por id... ComentarioDAOMariaDB10");
            System.out.println(e);
        }
        return false;
    }

}
