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
import com.dao.TeacherDao;
import com.entities.Teacher;
/**
 * Servlet implementation class UpdateTeacherController
 */
@WebServlet("/update-teacher")
public class UpdateTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> listOfTeacher = new ArrayList<>();
		TeacherDao teacherDao = new TeacherDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String passWord = request.getParameter("passWord");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		
		
		try {
			listOfTeacher = teacherDao.getListTeacher();
			teacherDao.updateTeacher(passWord, fullName, email, id);
			request.setAttribute("listOfTeacher", listOfTeacher);
			request.getRequestDispatcher("/views/show_data_teacher.jsp").forward(request, response);
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
