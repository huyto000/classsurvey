package com.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.dao.StudentDao;
import com.dao.StudentImport;



public class DatabaseUtils {
  static final String FILE_NAME = "/DBConfig.properties";

  public static Connection getConnection()
      throws IOException, ClassNotFoundException, SQLException {
	
    Properties properties = new Properties();
    properties.load(DatabaseUtils.class.getResourceAsStream(FILE_NAME));
    String driver = properties.getProperty("driver");
    String server = properties.getProperty("server");
    String dbName = properties.getProperty("dbname");
    String user = properties.getProperty("user");
    String pass = properties.getProperty("pass");

    Class.forName(driver);
    Connection con = DriverManager.getConnection(server + "/" + dbName, user,
            pass);
  
    
    return con; 
  }

  
  public static void closeConnection(Connection connection)
      throws SQLException {
    if (connection != null) {
      connection.close();
    }
  }
  public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		if(getConnection()!=null) {
			System.out.println("Success!");
		}
		
	}

}
