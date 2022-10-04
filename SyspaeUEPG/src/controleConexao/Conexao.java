/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleConexao;
import java.sql.*;
/**
 *
 * @author Lucas
 */
public class Conexao {
    private String url;
    private String user;
    private String password;
    private Connection con;
    
    public Conexao(){
        url = "jdbc:postgresql://localhost:5432/postgres";
        user = "postgres";
        password = "1219";
        
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
