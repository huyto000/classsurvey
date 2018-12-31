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
import com.dao.StudentImport;
import com.entities.Student;

/**
 * Servlet implementation class StudentImportController
 */
@WebServlet("/student-import")
public class StudentImportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentImportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentImport studentImport = new StudentImport();
		List<Student> listOfStudent = new ArrayList<>();
		List<Student> listOfStudentFull = new ArrayList<>();
		StudentDao studentDao = new StudentDao();
		/*String fileName = request.getParameter("fileName");*/
		String fileName = "D:\\classsurvey\\"+request.getParameter("fileName");
		System.out.println(fileName);
		try {
			
			studentImport.importStudent(fileName);
			listOfStudent = studentDao.getListStudentLimit(0,8);
			listOfStudentFull = studentDao.getListStudent();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		request.getRequestDispatcher("/views/show_data_student.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
