package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Student;
import com.utils.DatabaseUtils;

public class StudentDao {
	public void insertStudent(String userName,String passWord,String fullName,String email,String className) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "insert into student(userName,passWord,fullName,email,class)values(?,?,?,?,?)";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,userName);
		   preparedStatement.setString(2,passWord);
		   preparedStatement.setString(3,fullName);
		   preparedStatement.setString(4,email);
		   preparedStatement.setString(5,className);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	public boolean checkName(String userName) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DatabaseUtils.getConnection();
	    StudentDao studentDao = new StudentDao();
		String sql = "select * from student where userName = ?;";
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
	
	public List<Student> getListStudent() throws ClassNotFoundException, IOException, SQLException{
		  List<Student> listStudent = new ArrayList<>();
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT * FROM student";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		    ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      while(resultSet.next()) {
		        listStudent.add(new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
		      }
		      
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  return listStudent;
	  }
	
	public void updateStudent(String passWord,String fullName,String email,String className,int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "update student set passWord = ? , fullName = ?,email=?,class=? where student_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,passWord);
		   preparedStatement.setString(2,fullName);
		   preparedStatement.setString(3,email);
		   preparedStatement.setString(4,className);
		   preparedStatement.setInt(5,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	public void deleteStudent(int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from student where student_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		   preparedStatement.setInt(1,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	public List<Student> getListStudentLimit(int startPoint,int numberRow) throws ClassNotFoundException, IOException, SQLException{
		  List<Student> listStudent = new ArrayList<>();
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT * FROM student limit ?,?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(1,startPoint);
		    preparedStatement.setInt(2,numberRow);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      while(resultSet.next()) {
		        listStudent.add(new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
		      }
		      
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  return listStudent;
	  }
	
	
	public String getUserNameByStudentId(int id ) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT userName from student where student_id=?";
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
	public int getIdNameByStudentName(String userName ) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT student_id from student where userName=?";
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
}
