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

import com.dao.QuestionDao;
import com.dao.TeacherDao;
import com.entities.Question;
import com.entities.Teacher;

/**
 * Servlet implementation class UpdateQuestionController
 */
@WebServlet("/update-question")
public class UpdateQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> listOfQuestion = new ArrayList<>();
		QuestionDao questionDao = new QuestionDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String content = request.getParameter("content");
		
		
		
		try {
			listOfQuestion = questionDao.getListQuestion();
			questionDao.updateQuestion(content, id);
			request.setAttribute("listOfQuestion", listOfQuestion);
			request.getRequestDispatcher("/views/show_question.jsp").forward(request, response);
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
