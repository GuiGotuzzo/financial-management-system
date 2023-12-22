package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/financial_management_system";
    private static final String user = "root";
    private static final String password = "behappy";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException e){
            throw new SQLException("Driver JDBC wasn't found", e);
        }
    }

}
