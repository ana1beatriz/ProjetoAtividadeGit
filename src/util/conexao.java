/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana Beatriz
 */
public class conexao {
    
    private static Connection conexao;
   
    private conexao(){}
    
    public static Connection getConexao(){
        
        if (conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/papelaria", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
        
   
    }
}
