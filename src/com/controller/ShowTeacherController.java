package com.controller;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TeacherDao;
import com.entities.Teacher;

/**
 * Servlet implementation class ShowStudentController
 */
@WebServlet("/show-teacher")
public class ShowTeacherController extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			TeacherDao teacherDao = new TeacherDao();
		List<Teacher> listOfTeacher = new ArrayList<>();
		try {
			listOfTeacher = teacherDao.getListTeacher();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listOfTeacher", listOfTeacher);
		request.getRequestDispatcher("/views/show_data_teacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
