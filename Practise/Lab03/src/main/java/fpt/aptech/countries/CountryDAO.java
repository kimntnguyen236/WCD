package fpt.aptech.countries;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryDAO {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public CountryDAO() {
        setConnect();
    }

    private Connection setConnect() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;database=Sem4DB";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, "sa", "123");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public int addCountry(Country country) {
        int status = 0;
        String query = "INSERT INTO Country VALUES(?,?)";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, country.countryname);
            pstmt.setInt(2, country.getPopulation());
            status = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public List<Country> findAll() {
        List<Country> listCountries = new ArrayList<Country>();
        String query = "SELECT * FROM Country";
        try {
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setCountryname(rs.getString("countryname"));
                country.setPopulation(rs.getInt("population"));
                
                listCountries.add(country);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCountries;
    }
}
