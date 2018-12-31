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

import com.entities.Course;

import com.dao.HomeStudentDao;
import com.utils.DatabaseUtils;

@WebServlet("/HomeStudentForward")
public class HomeStudentForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeStudentForward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Course> listCourse = new ArrayList<>();
		
		try {
			Connection conn = DatabaseUtils.getConnection();
			listCourse = HomeStudentDao.getListCourse(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listCourse", listCourse);
		RequestDispatcher rd = request.getRequestDispatcher("views/home_student.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
