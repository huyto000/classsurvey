package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entities.Student;
import com.entities.Teacher;

/**
 * Servlet implementation class AddTeacherController
 */
@WebServlet("/add-teacher")
public class AddTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> listOfTeacher= new ArrayList<>();
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		
		try {
			teacherDao.insertTeacher(userName, passWord, fullName, email);
			listOfTeacher = teacherDao.getListTeacher();
			
			
			request.setAttribute("listOfTeacher", listOfTeacher);
			
			request.getRequestDispatcher("/views/show_data_teacher.jsp").forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
