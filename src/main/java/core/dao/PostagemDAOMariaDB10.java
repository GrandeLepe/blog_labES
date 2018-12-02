/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.modelo.Postagem;
import api.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import api.dao.PostagemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leonardo
 */
public class PostagemDAOMariaDB10 implements PostagemDAO {

    private Connection conexao;

    public PostagemDAOMariaDB10() throws ClassNotFoundException {
        conexao = Fabrica.obterConexao();
    }

    @Override
    public int inserir(Postagem postagem) {
        int retorno = 0;
        try {
            // PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO usuario
            // VALUE(?,?,?,?,?,?)");
            PreparedStatement comandoSQL = conexao
                    .prepareStatement("INSERT INTO blog.postagem (titulo, publicacao, id_autor) VALUES (?, ?, ?)");

            comandoSQL.setString(1, postagem.getTitulo());
            comandoSQL.setString(2, postagem.getPublicacao());
            comandoSQL.setString(3, postagem.getId_autor().toString());

            retorno = comandoSQL.executeUpdate();
            comandoSQL.close();
            if (retorno != 1) {
                System.out.println("Erro ao adicionar postagem");
            } else if (retorno == 1) {
                System.out.println("Adicionado com sucesso!");
            }
            return retorno;
        } catch (Exception e) {
            System.out.println(e);

        }
        return retorno;
    }

    @Override
    public Postagem procurarPorId(Integer id) {
        Postagem p = null;
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from blog.postagem where id_post = ?");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
//            System.out.println("Conectado postagem...(metodo procurar por id)");
            rs.next();
            p = new Postagem();
            p.setId_post(rs.getInt(1));
            p.setTitulo(rs.getString(2));
            p.setPublicacao(rs.getString(3));
            p.setId_autor(rs.getInt(4));
            p.setData(rs.getString(5));

            comandoSQLp.close();
            rs.close();

            return p;

        } catch (SQLException ex) {
            System.out.print("\nErro de conexão... procurar por id");
            return p;
        }
    }

    @Override
    public List<Postagem> procurarTudo() {

        List<Postagem> postagens = new ArrayList<>();
        Postagem postagem;
        try {

            PreparedStatement comandoSQLp = conexao.prepareStatement("SELECT * FROM blog.postagem ORDER BY id_post DESC");
            ResultSet rs = comandoSQLp.executeQuery();

            while (rs.next()) {

                postagem = new Postagem(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                postagens.add(postagem);
            }
            return postagens;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Postagem> procurarTudoDoAutor(Integer id) {
        List<Postagem> postagens = new ArrayList<>();
        Postagem postagem;
        try {

            PreparedStatement comandoSQLp = conexao.prepareStatement("SELECT * FROM blog.postagem WHERE id_autor = ?");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();

            while (rs.next()) {

                postagem = new Postagem(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                postagens.add(postagem);
            }
            return postagens;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Postagem atualizar(Postagem postAnt, Postagem postAt) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) {
        try {
            //TODO Melhorar essa parte de exclusão 
            PreparedStatement comandoSQLp = conexao.prepareStatement("DELETE FROM blog.comentario WHERE id_post = ?");
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            comandoSQLp = conexao.prepareStatement("DELETE FROM blog.postagem WHERE id_post = ?");
            comandoSQLp.setString(1, id.toString());
            rs = comandoSQLp.executeQuery();
            System.out.println(rs.getBoolean(0));
            return rs.getBoolean(0);
        } catch (Exception e) {
            System.out.println("Erro para excluir por id... PostagemDAOMariaDB10");
            System.out.println(e);
        }
        return false;
    }

}
