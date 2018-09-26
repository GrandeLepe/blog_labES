/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author leonardo
 */
public class Fabrica {
    private static Connection conexao;
    private static final String CAMINHO_DB = "jdbc:mariadb://127.0.0.1/blog";
    private static final String USUARIO_DB = "root";
    private static final String SENHA_DB = "root";
    
    private Fabrica(){};
    
    
    
    public static Connection obterConexao() throws ClassNotFoundException{
        if(conexao == null){
            try{
                 Class.forName("org.mariadb.jdbc.Driver");
                conexao = DriverManager.getConnection(CAMINHO_DB, USUARIO_DB, SENHA_DB);
            }
            catch(Exception excecao){
                System.out.println(excecao);
                System.out.println("Erro de conexão com o banco de dados");
            }
        }
        return conexao;
    }
}
