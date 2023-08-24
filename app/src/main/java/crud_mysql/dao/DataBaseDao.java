package crud_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import crud_mysql.util.DataBaseManger;
public class DataBaseDao {
    Connection connection = DataBaseManger.getConnection();
    public void insertBook(String title,String author,String Genre,int option){
        String query = "";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            int  rowsAffected = statement.executeUpdate();
        } catch (Exception e) {
           
        }
    }
}
