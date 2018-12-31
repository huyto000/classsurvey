package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.DatabaseUtils;

public class StudentCourseDao {
	public boolean checkNameStudentCourse(String courseId,int studentId) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
	    String sql = "select * from studentcourse where course_id = ? and student_id = ?;";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,courseId);
		   preparedStatement.setInt(2,studentId);
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
	
	public void insertStudentCourse(String courseId,int studentId) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "insert into studentcourse(course_id,student_id)values(?,?)";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,courseId);
		   preparedStatement.setInt(2,studentId);
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	
	public void deleteStudentCourse(String courseId) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from studentcourse where course_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setString(1,courseId);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	public void deleteStudentCourseByStudentId(int studentId) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from studentcourse where student_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setInt(1,studentId);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
}
