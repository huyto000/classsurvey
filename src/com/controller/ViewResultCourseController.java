package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDao;
import com.dao.ShowResultSurveyDao;
import com.dao.TeacherDao;
import com.entities.Question;
import com.utils.DatabaseUtils;

/**
 * Servlet implementation class ViewResultCourseController
 */
@WebServlet("/view-result-course")
public class ViewResultCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResultCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseId = request.getParameter("id");
		CourseDao courseDao = new CourseDao();
		TeacherDao teacherDao = new TeacherDao();
		System.out.println(courseId);
		
		ArrayList<Question> listQuestion = new ArrayList<>();
		
		try {
			String courseName = courseDao.getCourseNameByCourseId(courseId);
			Connection conn = DatabaseUtils.getConnection();
			listQuestion = ShowResultSurveyDao.getInfoCourseSurvey(conn, courseId); 
			String teacherName = teacherDao.getUserNameById(courseDao.getTeacherIdByCourseId(courseId));
			System.out.println(listQuestion.size());
			request.setAttribute("courseId", courseId);
			request.setAttribute("listQuestion", listQuestion);
			request.setAttribute("courseName", courseName);
			request.setAttribute("teacherName", teacherName);
			request.getRequestDispatcher("/views/show_result_admin.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
