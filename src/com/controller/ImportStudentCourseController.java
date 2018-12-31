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

import com.dao.CourseDao;
import com.dao.StudentCourseDao;
import com.dao.StudentCourseImport;
import com.dao.StudentImport;
import com.dao.TeacherDao;
import com.entities.Course;
import com.entities.Student;

/**
 * Servlet implementation class ImportStudentCourseController
 */
@WebServlet("/import-studentcourse")
public class ImportStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportStudentCourseController() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentCourseImport studentCourseImport = new StudentCourseImport();
		CourseDao courseDao = new CourseDao();
		List<Course> listCourse = new ArrayList<>();
		TeacherDao teacherDao = new TeacherDao();
		
		String fileName = "D:\\classsurvey\\"+request.getParameter("fileName");
		
		System.out.println(fileName);
		try {
			studentCourseImport.importStudentCourse(fileName);
			listCourse = courseDao.getListCourse();
			request.setAttribute("listCourse", listCourse);
			request.setAttribute("teacherDao", teacherDao);
			request.setAttribute("studentCourseImport", studentCourseImport);
			request.getRequestDispatcher("/views/show_course.jsp").forward(request, response);
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
