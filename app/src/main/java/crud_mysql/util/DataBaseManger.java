package crud_mysql.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static crud_mysql.main.App.environments;
import static crud_mysql.main.App.logger;
public class DataBaseManger {
    static String jdbcUrl = environments.get("URL");
    static String username = environments.get("USERNAME");
    static String password = environments.get("PASSWORD");
    public static Connection getConnection(){
        if (jdbcUrl.equals(null) || username.equals(null) || password.equals(null)) {
            logger.warning("Db creadentials are null");
        }
            Connection connection = null;
            try{
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            }catch(SQLException e){
            logger.warning("Error occurs : "+e.getMessage());
            e.printStackTrace();
            
        }
        return connection;
        }
}
