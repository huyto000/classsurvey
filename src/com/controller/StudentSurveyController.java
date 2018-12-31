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
import javax.servlet.http.HttpSession;

import com.dao.StudentSurveyDao;
import com.entities.Answer;
import com.entities.Member;
import com.entities.Question;
import com.utils.DatabaseUtils;

@WebServlet("/StudentSurveyController")
public class StudentSurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSurveyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		int studentId = member.getMemberId();
		
		String courseId = request.getParameter("course");
		boolean isFullAnswers = true;
		
		try {
			Connection conn = DatabaseUtils.getConnection();
			ArrayList<Question> listQuestion = StudentSurveyDao.getListQuestion(conn);
			ArrayList<Answer> listAnswer = new ArrayList<>();
			
			for(Question question : listQuestion) {
				int id = question.getQuestionId();
				String answerStr = request.getParameter("ques["+id+"]");
				
				if(answerStr != null) {
					int answerInt = Integer.parseInt(answerStr);
					
					Answer answer = new Answer(id, answerInt);
					listAnswer.add(answer);
				} else {
					isFullAnswers = false;
					break;
				}
			}
			
			if(isFullAnswers) {
				boolean result = StudentSurveyDao.AddNewSurvey(conn, courseId, studentId, listAnswer);
				
				if(result) {
					request.setAttribute("surveymess", "Câu trả lời đã được ghi nhận, chọn môn tiếp theo hoặc kết thúc.");
					
					RequestDispatcher rd = request.getRequestDispatcher("StudentSurveyForward");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("surveymess", "Yêu cầu trả lời hết tất cả các câu hỏi khảo sát.");
				RequestDispatcher rd = request.getRequestDispatcher("StudentSurveyForward");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
