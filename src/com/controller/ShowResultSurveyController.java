package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.HomeTeacherDao;
import com.dao.ShowResultSurveyDao;
import com.entities.Course;
import com.entities.Member;
import com.entities.Question;
import com.utils.DatabaseUtils;

@WebServlet("/ShowResultSurveyController")
public class ShowResultSurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowResultSurveyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("memberTeacher");
		
		ArrayList<Course> listCourseOfTeacher = new ArrayList<>();
		ArrayList<Question> listQuestion = new ArrayList<>();
		
		int teacherId = member.getMemberId();
		
		String courseId = request.getParameter("course");

		try {
			Connection conn = DatabaseUtils.getConnection();
			listCourseOfTeacher = HomeTeacherDao.getListCourseOfTeacher(conn, teacherId);
			listQuestion = ShowResultSurveyDao.getInfoCourseSurvey(conn, courseId);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listCourseOfTeacher", listCourseOfTeacher);
		request.setAttribute("listQuestion", listQuestion);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/showresultsurvey.jsp");
		rd.forward(request, response);
	}

}
