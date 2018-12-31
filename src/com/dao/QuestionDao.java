package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Course;
import com.entities.Question;
import com.utils.DatabaseUtils;

public class QuestionDao {
	public List<Question> getListQuestion() throws ClassNotFoundException, IOException, SQLException{
		  List<Question> listQuestion = new ArrayList<>();
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "SELECT * FROM surveyform";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   
		    ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      while(resultSet.next()) {
		        listQuestion.add(new Question(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
		      }
		      
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  return listQuestion;
	  }
	
	
	public void updateQuestion(String content,int id) throws ClassNotFoundException, IOException, SQLException {
		  Connection connection = DatabaseUtils.getConnection();
		    String sql = "update surveyform set sentence_content=? where sentence_id=? ";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   preparedStatement.setString(1,content);
		
		   
		   preparedStatement.setInt(2,id);
		  
		   preparedStatement.executeUpdate();
		      DatabaseUtils.closeConnection(connection);  
	  }
	
	
}
