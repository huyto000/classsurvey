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
import com.entities.Student;

/**
 * Servlet implementation class UpdateStudentController
 */
@WebServlet("/update-student")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String passWord = request.getParameter("passWord");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String className = request.getParameter("className");
		
		List<Student> listOfStudent = new ArrayList<>();
		
		List<Student> listOfStudentFull = new ArrayList<>();
		try {
			listOfStudent = studentDao.getListStudentLimit(0,8);
			listOfStudentFull = studentDao.getListStudent();
			studentDao.updateStudent(passWord, fullName, email, className,id);
			request.setAttribute("listOfStudent", listOfStudent);
			int rowPerPage = 8;
			int numberRow = listOfStudentFull.size();
			int numberPage;
			if(numberRow%rowPerPage==0) {
				 numberPage = numberRow/rowPerPage ;
			}
			else numberPage = (numberRow - numberRow % rowPerPage)/rowPerPage +1 ;
			request.setAttribute("listOfStudent", listOfStudent);
			request.setAttribute("numberRow", numberRow);
			request.setAttribute("numberPage", numberPage);
			request.setAttribute("listOfStudentFull", listOfStudentFull);
			request.getRequestDispatcher("/views/show_data_student.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
