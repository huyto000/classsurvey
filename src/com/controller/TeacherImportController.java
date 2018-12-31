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
import com.dao.TeacherImport;

import com.entities.Student;
import com.entities.Teacher;

/**
 * Servlet implementation class TeacherImportController
 */
@WebServlet("/teacher-import")
public class TeacherImportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherImportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherImport teacherImport = new TeacherImport();
		List<Teacher> listOfTeacher = new ArrayList<>();
		
		TeacherDao teacherDao = new TeacherDao();
		/*String fileName = request.getParameter("fileName");*/
		String fileName = "D:\\classsurvey\\"+request.getParameter("fileName");
		System.out.println(fileName);
		try {
			
			teacherImport.importTeacher(fileName);
			listOfTeacher = teacherDao.getListTeacher();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("listOfTeacher", listOfTeacher);
		
		request.getRequestDispatcher("/views/show_data_teacher.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
