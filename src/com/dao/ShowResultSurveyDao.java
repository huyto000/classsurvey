package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Question;
import com.entities.ResultSurvey;

public class ShowResultSurveyDao {
	public static ArrayList<Question> getInfoCourseSurvey(Connection conn, String courseId) {
		
		ArrayList<ResultSurvey> listResultSurvey = new ArrayList<ResultSurvey>();
		String sql = "select * from classsurvey.survey where course_id = \""+courseId+"\"";
		int amount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ResultSurvey result = new ResultSurvey();
				result.setResult1(rs.getInt("result_sentence1"));
				result.setResult2(rs.getInt("result_sentence2"));
				result.setResult3(rs.getInt("result_sentence3"));
				result.setResult4(rs.getInt("result_sentence4"));
				result.setResult5(rs.getInt("result_sentence5"));
				result.setResult6(rs.getInt("result_sentence6"));
				result.setResult7(rs.getInt("result_sentence7"));
				result.setResult8(rs.getInt("result_sentence8"));
				result.setResult9(rs.getInt("result_sentence9"));
				result.setResult10(rs.getInt("result_sentence10"));
				result.setResult11(rs.getInt("result_sentence11"));
				result.setResult12(rs.getInt("result_sentence12"));
				result.setResult13(rs.getInt("result_sentence13"));
				result.setResult14(rs.getInt("result_sentence14"));
				result.setResult15(rs.getInt("result_sentence15"));
				result.setResult16(rs.getInt("result_sentence16"));
				result.setResult17(rs.getInt("result_sentence17"));
				result.setResult18(rs.getInt("result_sentence18"));
				result.setResult19(rs.getInt("result_sentence19"));
				
				listResultSurvey.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		double result1 = 0, result2 = 0, result3 = 0, result4 = 0, result5 = 0, result6 = 0,
				result7 = 0, result8 = 0, result9 = 0, result10 = 0, result11 = 0, result12 = 0,
				result13 = 0, result14 = 0, result15 = 0, result16 = 0, result17 = 0, result18 = 0, result19 = 0;
		
		for(ResultSurvey resu : listResultSurvey) {
			amount++;
			result1 += resu.getResult1();
			result2 += resu.getResult2();
			result3 += resu.getResult3();
			result4 += resu.getResult4();
			result5 += resu.getResult5();
			result6 += resu.getResult6();
			result7 += resu.getResult7();
			result8 += resu.getResult8();
			result9 += resu.getResult9();
			result10 += resu.getResult10();
			result11 += resu.getResult11();
			result12 += resu.getResult12();
			result13 += resu.getResult13();
			result14 += resu.getResult14();
			result15 += resu.getResult15();
			result16 += resu.getResult16();
			result17 += resu.getResult17();
			result18 += resu.getResult18();
			result19 += resu.getResult19();
		}
		result1 = (double) Math.round(result1 / amount * 100) / 100;
		result2 = (double) Math.round(result2 / amount * 100) / 100;
		result3 = (double) Math.round(result3 / amount * 100) / 100;
		result4 = (double) Math.round(result4 / amount * 100) / 100;
		result5 = (double) Math.round(result5 / amount * 100) / 100;
		result6 = (double) Math.round(result6 / amount * 100) / 100;
		result7 = (double) Math.round(result7 / amount * 100) / 100;
		result8 = (double) Math.round(result8 / amount * 100) / 100;
		result9 = (double) Math.round(result9 / amount * 100) / 100;
		result10 = (double) Math.round(result10 / amount * 100) / 100;
		result11 = (double) Math.round(result11 / amount * 100) / 100;
		result12 = (double) Math.round(result12 / amount * 100) / 100;
		result13 = (double) Math.round(result13 / amount * 100) / 100;
		result14 = (double) Math.round(result14 / amount * 100) / 100;
		result15 = (double) Math.round(result15 / amount * 100) / 100;
		result16 = (double) Math.round(result16 / amount * 100) / 100;
		result17 = (double) Math.round(result17 / amount * 100) / 100;
		result18 = (double) Math.round(result18 / amount * 100) / 100;
		result19 = (double) Math.round(result19 / amount * 100) / 100;
		
		ArrayList<Question> listQuestion = new ArrayList<>();
		
		listQuestion = StudentSurveyDao.getListQuestion(conn);
		
		listQuestion.get(0).setResult(result1);
		listQuestion.get(1).setResult(result2);
		listQuestion.get(2).setResult(result3);
		listQuestion.get(3).setResult(result4);
		listQuestion.get(4).setResult(result5);
		listQuestion.get(5).setResult(result6);
		listQuestion.get(6).setResult(result7);
		listQuestion.get(7).setResult(result8);
		listQuestion.get(8).setResult(result9);
		listQuestion.get(9).setResult(result10);
		listQuestion.get(10).setResult(result11);
		listQuestion.get(11).setResult(result12);
		listQuestion.get(12).setResult(result13);
		listQuestion.get(13).setResult(result14);
		listQuestion.get(14).setResult(result15);
		listQuestion.get(15).setResult(result16);
		listQuestion.get(16).setResult(result17);
		listQuestion.get(17).setResult(result18);
		listQuestion.get(18).setResult(result19);
		
		return listQuestion;
	}
	
}
