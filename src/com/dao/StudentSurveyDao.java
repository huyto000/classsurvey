package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Answer;
import com.entities.Course;
import com.entities.Member;

import com.entities.Question;

import com.entities.Survey;


public class StudentSurveyDao {
	public static ArrayList<Course> getListUserCourse(Connection conn, Member member) {
		ArrayList<Course> listUserCourse = new ArrayList<>();
		
		int memberId = member.getMemberId();
		
		String sql = "select c.* "
				+ "from (select c.course_id, c.course_name, t.fullname from classsurvey.course c, classsurvey.teacher t where c.teacher_id = t.teacher_id) c , "
				+ "(select * from classsurvey.studentcourse sc where sc.student_id = \" " + memberId + " \" ) cu "
						+ "where c.course_id = cu.course_id";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Course course = new Course(rs.getString("course_id"), rs.getString("course_name"), rs.getString("fullname"));
				System.out.println(course.getCourseId()+"\n");
				listUserCourse.add(course);
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listUserCourse;
	}
	
	public static ArrayList<Question> getListQuestion(Connection conn) {
		ArrayList<Question> listQuestion = new ArrayList<>();
		
		String sql = "select * from surveyform";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("sentence_id");
				String content = rs.getString("sentence_content");
				int type = rs.getInt("sentence_type");
				
				Question question = new Question(id, content, type);
				listQuestion.add(question);
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listQuestion;
	}
	
	// Thêm phiếu khảo sát vào CSDL
		public static boolean AddNewSurvey(Connection conn, String courseId, int  studentId, ArrayList<Answer> listAnswer) {
			
			boolean isExist = StudentSurveyDao.isExistSurvey(conn, courseId, studentId);
			if(isExist) {
				StudentSurveyDao.deleteSurvey(conn, courseId, studentId);
			}
			
			PreparedStatement ps = null;
			
			String sql = "insert into survey(course_id, student_id, result_sentence1, result_sentence2, "
					+ "result_sentence3, result_sentence4, result_sentence5, result_sentence6, result_sentence7, "
					+ "result_sentence8, result_sentence9, result_sentence10, result_sentence11, result_sentence12, "
					+ "result_sentence13, result_sentence14, result_sentence15, result_sentence16, result_sentence17, "
					+ "result_sentence18, result_sentence19) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, courseId);
				ps.setInt(2, studentId);
				
				int i = 3;
				for(Answer answer : listAnswer) {
					ps.setInt(i, answer.getAnswerContent());
					i++;
				}
				
				int resultAdd = ps.executeUpdate();
				
				if(resultAdd != 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return false;
		}
		
		//Xóa dữ liệu trong bảng bằng course_id và student_id
		public static void deleteSurvey(Connection conn, String courseId, int  studentId) {
			PreparedStatement ps = null;
			String sql = "delete from classsurvey.survey where (course_id = \""+courseId+"\") and (student_id = "+studentId+")";
			// reme: Uncheck "safe update mode" in mysqlworkbench
			try {
				ps = conn.prepareStatement(sql);
				ps.execute();
				
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//Kiểm tra đã tồn tại phiếu khảo sát của course_id và student_id chưa
		public static boolean isExistSurvey(Connection conn, String courseId, int studentId) {
			ArrayList<Survey> listSurvey = new ArrayList<>();
			
			String sql = "SELECT course_id, student_id FROM classsurvey.survey";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					String cId = rs.getString("course_id");
					int sId = rs.getInt("student_id");
					
					Survey survey = new Survey(cId, sId);
					listSurvey.add(survey);
				}
				
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			for(Survey survey : listSurvey) {
				if(survey.getCourseId().equals(courseId) && survey.getStudentId() == studentId) {
					return true;
				}
			}
			
			return false;
		}
}
