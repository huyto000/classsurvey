package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Student;
import com.entities.Teacher;
import com.utils.DatabaseUtils;

public class TeacherDao {
	public void insertTeacher(String userName,String passWord,String fullName,String email) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "insert into teacher(userName,passWord,fullName,email) values(?,?,?,?)";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,userName);
		   preparedStatement.setString(2,passWord);
		   preparedStatement.setString(3,fullName);
		   preparedStatement.setString(4,email);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	public boolean checkName(String userName) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
	    String sql = "select * from teacher where userName = ?;";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,userName);
		   preparedStatement.executeQuery();
		   ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      if(resultSet.next()) {
		    	  System.out.print("Da bi trung!");
		        return false;
		      }
		      System.out.println("Chua bi trung!");
		      return true;
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		
	}
	public List<Teacher> getListTeacher() throws ClassNotFoundException, IOException, SQLException{
		  List<Teacher> listTeacher = new ArrayList<>();
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT * FROM teacher";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		    ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      while(resultSet.next()) {
		        listTeacher.add(new Teacher(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
		      }
		      
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  return listTeacher;
	  }
	
	public void updateTeacher(String passWord,String fullName,String email,int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "update teacher set passWord = ? , fullName = ?,email=? where teacher_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,passWord);
		   preparedStatement.setString(2,fullName);
		   preparedStatement.setString(3,email);
		   
		   preparedStatement.setInt(4,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	public void deleteTeacher(int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from teacher where teacher_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setInt(1,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	public int getIdByUserName(String userName ) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT teacher_id from teacher where userName=?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setString(1,userName);
		   ResultSet resultSet = preparedStatement.executeQuery();
		   try {
			      if (resultSet.next()) {
			        return resultSet.getInt(1);
			      }
			      return 0;
			    } finally {
			      DatabaseUtils.closeConnection(connection);
			    }
	
}
	
	public String getUserNameById(int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT fullName from teacher where teacher_id=?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setInt(1,id);
		   ResultSet resultSet = preparedStatement.executeQuery();
		   try {
			      if (resultSet.next()) {
			        return resultSet.getString(1);
			      }
			      return null;
			    } finally {
			      DatabaseUtils.closeConnection(connection);
			    }
	
}
}
