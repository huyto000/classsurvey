package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Course;

public class HomeTeacherDao {
	public static ArrayList<Course> getListCourseOfTeacher(Connection conn, int teacherId){
		ArrayList<Course> listCourseOfTeacher = new ArrayList<>();
		
		String sql = "select c.course_id, c.course_name, t.teacher_id, t.fullName "
				+ "from course c, (select teacher_id, fullName from classsurvey.teacher where teacher_id = \" "+teacherId+" \") t "
				+ "where c.teacher_id = t.teacher_id";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getString("course_id"));
				course.setCourseName(rs.getString("course_name"));
				course.setTeacherId(rs.getInt("teacher_id"));
				course.setTeacherName(rs.getString("fullName"));
				
				listCourseOfTeacher.add(course);
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCourseOfTeacher;
	}
}
