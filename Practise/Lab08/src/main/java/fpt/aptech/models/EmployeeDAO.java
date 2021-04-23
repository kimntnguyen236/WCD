package fpt.aptech.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThienKim
 */
public class EmployeeDAO {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public EmployeeDAO() {
        setConn();
    }

    private Connection setConn() {
        String url = "jdbc:sqlserver://localhost:1433;database=Sem04DB";
        String user = "sa";
        String password = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public boolean checkLogin(String id, String pass) {
        String query = "SELECT * FROM Employees WHERE id=? AND password=? AND role=1";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employees WHERE role=0";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("password"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setRole(rs.getBoolean("role"));

                list.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void resetPassword(String id) {
        try {
        String sql = "UPDATE Employees SET password='Password' WHERE id=?";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
