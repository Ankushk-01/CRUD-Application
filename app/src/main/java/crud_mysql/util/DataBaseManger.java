package crud_mysql.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManger {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/books";
    static String username = "root";
    static String password = "Ankush@123";
    public static Connection getConnection(){
            Connection connection = null;
            try{
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            }catch(SQLException e){
            System.out.println("Error occurs : ");
            e.printStackTrace();
        }
        return connection;
        }
}
