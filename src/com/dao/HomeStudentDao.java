package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Course;

public class HomeStudentDao {
	public static ArrayList<Course> getListCourse(Connection conn) {
		ArrayList<Course> listCourse = new ArrayList<>();
		
		String sql = " select c.course_id, c.course_name, t.fullname from classsurvey.course c, classsurvey.teacher t where c.teacher_id = t.teacher_id";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				
				course.setCourseId(rs.getString("course_id"));
				course.setCourseName(rs.getString("course_name"));
				course.setTeacherName(rs.getString("fullname"));
				
				listCourse.add(course);
			}
			
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCourse;
	}
}
