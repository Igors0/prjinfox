/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ao.com.infox.dal;
import java.sql.*;

/**
 *
 * @author proresol
 */
public class Conexao {
    // Metodo responsavel por fazer a conexao com o bando de dados
    public static Connection conector(){
        java.sql.Connection conexao = null;
       // variavel que chamando o driver
 
       String driver ="com.mysql.jdbc.Driver";
       // variavel que armazena informacoes do banco
       String url="jdbc:mysql://localhost:3306/dbinfox";
       String user ="root";
       String senha="root";
       // estalecndo a conexao com o banco
        try {
            Class.forName(driver);
            conexao=DriverManager.getConnection(url,user,senha);
            return conexao;            
        } catch (Exception e) {
            System.out.println("Erro de driver ou Base de dados não encontrada --->"+e);
            return null;
        }
    
    }
    
}
