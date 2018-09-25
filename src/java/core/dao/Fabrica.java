/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author leonardo
 */
public class Fabrica {
    private static Connection conexao;
    private static final String caminhoDB = "jdbc:mariadb://127.0.0.1/blog";
    private static final String usuarioDB = "root";
    private static final String senhaDB = "root";
    
    private Fabrica(){};
    
    public static Connection obterConexao() throws ClassNotFoundException{
        if(conexao == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                conexao = DriverManager.getConnection(caminhoDB, usuarioDB, senhaDB);
            }
            catch(Exception excecao){
                System.out.println("Erro de conexão com o banco de dados");
            }
        }
        return conexao;
    }
}
