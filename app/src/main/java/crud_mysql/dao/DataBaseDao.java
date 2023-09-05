package crud_mysql.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud_mysql.util.DataBaseManger;
import static crud_mysql.main.App.logger;
public class DataBaseDao {
    String database = "book";
    String tableName = "books";
    
    public DataBaseDao() {
        Connection connection = DataBaseManger.getConnection();
        try {
            Statement statement = connection.createStatement();
            String Query = "CREATE DATABASE IF NOT EXISTS " + database;
            int rowsAffected = statement.executeUpdate(Query);
            if (rowsAffected > 0) {
//                System.out.println("DataBase Created Successfully");
            } else {
                System.out.println("Query Failed");
            }
            // String dummy = "CREATE TABLE new_one.book (\n" + //
            // "title int8,\n" + //
            // "author varchar(200),\n" + //
            // "genre varchar(200),\n" + //
            // "avail varchar(200),\n" + //
            // "checkoutby varchar(500)\n" + //
            // ");";
            String query = "CREATE TABLE IF NOT EXISTS " + database + "." + tableName + " ( \n " +
            		"bookId int8 AUTO_INCREMENT primary key,\n"+
                    "title varchar(200),\n" + //
                    "author varchar(200),\n" + //
                    "genre varchar(200),\n" + //
                    "avail varchar(200),\n" + //
                    "checkoutby varchar(500)\n" + //
                    ");";
//            System.out.println("query : " + query);
            int result = statement.executeUpdate(query);
            if (result == 0) {
//                System.out.println("Table created successfully");
            } else {
                System.out.println("Query failed for Table creation ");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error Occures at Database creation method");
            e.printStackTrace();
        }
    }

    Connection connection = DataBaseManger.getConnection();
    public void insertBook(String title, String author, String Genre, int option) {
        String avail = "";
        if (option == 1) {
            avail = "Available Soon";
        } else if (option == 2) {
            avail = "Available Now";
        } else {
            avail = "Not Available";
        }
        String query = "insert into "+database+"."+tableName+" (title, author, genre, avail, checkoutby) value (?,?,?,?,?)";
//        System.out.println("insert query : "+query);
        try {
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,title);
            statement.setString(2,author);
            statement.setString(3,Genre);
            statement.setString(4,avail);
            statement.setString(5,"");
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Data is inserted susseccfully");

            } else {
                System.out.println("Data is not inserted successfully");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);
                    System.out.println("Generated ID: " + generatedId);
                    
                    // Perform further conversions or operations with the generated ID
                } else {
                    System.out.println("No generated keys.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurs while insertion ");
            e.printStackTrace();
        }
    }
    public int deleteBook(String tittle) {
    	String query = "SELECT bookId FROM "+database+"."+tableName+" WHERE title = "+'"'+tittle+'"';
    	try(PreparedStatement statement = connection.prepareStatement(query);){
    		ResultSet rs = statement.executeQuery();
    		int bookId = 0;
    		while(rs.next()) {
    			bookId = rs.getInt(1);
    		}
    		statement.close();
    		if(bookId ==0) {
    			return 0;
    		}
    	query = "DELETE FROM "+database+"."+tableName+" WHERE bookId = "+bookId;
    	try(Statement stmt = connection.createStatement();){
    		int rowsAffected = stmt.executeUpdate(query);
//    		logger.info("The Number of books deleted is : "+rowsAffected);
    		stmt.close();
    	}
    	}catch (SQLException e) {
            System.out.println("Error occurs while insertion ");
            e.printStackTrace();
        }
    	return 1;
    }
}
