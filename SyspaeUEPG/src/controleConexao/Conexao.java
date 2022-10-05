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
        password = "syspae";
        
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int executaInsert(String SQL){
        try {
            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate(SQL);
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }    
    
    public ResultSet executaBusca(String SQL){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            con.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
