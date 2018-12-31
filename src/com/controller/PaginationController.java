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
 * Servlet implementation class PaginationController
 */
@WebServlet("/pagination")
public class PaginationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		List<Student> listOfStudent = new ArrayList<>();
		List<Student> listOfStudentFull = new ArrayList<>();
		int page = Integer.parseInt((String) request.getParameter("page"));
		try {
			listOfStudent = studentDao.getListStudentLimit((page-1)*8,8); 
			//listOfStudent = studentDao.getListStudentLimit(startPoint, numberRow); 
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
		request.getRequestDispatcher("/views/table_student.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
