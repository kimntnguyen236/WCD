/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThienKim
 */
public class LoginDAO {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public LoginDAO() {
        setConnect();
    }
    private Connection setConnect(){
        try {
        String url = "jdbc:sqlserver://localhost:1433;database=Sem4DB";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, "sa", "123");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    public boolean checkLogin(String uname, String upass) {
        
        return uname.equals("FPT") && upass.equals("123");
    }
}
