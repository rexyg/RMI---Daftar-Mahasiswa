package Utilities;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//utk koneksi dg databse 
public class DatabaseMhs {
    private static Connection connection; 
    
    public static Connection getConnection(){
        if (connection == null ){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                //utk membuat koneksi dg localhost ke db'mhs' dg user root 
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mhs", "root", "");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }
        return connection;
    }
}
