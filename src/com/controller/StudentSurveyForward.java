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

import com.dao.StudentSurveyDao;
import com.entities.Course;
import com.entities.Member;
import com.entities.Question;
import com.utils.DatabaseUtils;

@WebServlet("/StudentSurveyForward")
public class StudentSurveyForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSurveyForward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy danh sách các môn học của người dùng
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		ArrayList<Course> listUserCourse = new ArrayList<>();
		
		try {
			Connection conn = DatabaseUtils.getConnection();
			listUserCourse = StudentSurveyDao.getListUserCourse(conn, member);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listUserCourse", listUserCourse);
		// /Lấy danh sách các môn học của người dùng
		
		// Lấy danh sách câu hỏi khảo sát
		ArrayList<Question> listQuestion = new ArrayList<>();
		try {
			Connection conn = DatabaseUtils.getConnection();
			listQuestion = StudentSurveyDao.getListQuestion(conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listQuestion", listQuestion);
		// /Lấy danh sách câu hỏi khảo sát
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/student_survey.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
