package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Course;
import com.entities.Student;
import com.utils.DatabaseUtils;

public class CourseDao {
	public void insertCourse(String courseId,String courseName,int teacherId) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "insert into course values(?,?,?)";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,courseId);
		   preparedStatement.setString(2,courseName);
		   preparedStatement.setInt(3,teacherId);  
		   preparedStatement.executeUpdate();
		   System.out.println("Them thanh cong!");
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	
	
	public List<Course> getListCourse() throws ClassNotFoundException, IOException, SQLException{
		  List<Course> listCourse = new ArrayList<>();
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT * FROM course";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		    ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      while(resultSet.next()) {
		        listCourse.add(new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3)));
		      }
		      
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  return listCourse;
	  }
	
	public void deleteCourseByTeacherId(int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from course where teacher_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setInt(1,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	public void deleteCourse(String id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from course where course_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setString(1,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	public String getCourseIdByTeacherId(int teacherId ) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "select course_id from course where teacher_id = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setInt(1,teacherId);
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
	
	public String getCourseNameByCourseId(String courseId ) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "select course_name from course where course_id = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setString(1,courseId);
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
	public int getTeacherIdByCourseId(String courseId ) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "select teacher_id from course where course_id = ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setString(1,courseId);
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
	
}
