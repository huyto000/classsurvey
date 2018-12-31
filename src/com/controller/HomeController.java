package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.entities.Member;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Member member = new Member(username, password);
		
		try {
			member = LoginDao.AuthenticationMember(member);
			
			if(member.getRole() == 0) {
				request.setAttribute("msgLogin", "Sai tên đăng nhập hoặc mật khẩu");
				RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
				rd.forward(request, response);
			} else {
				if(member.getRole() == 1) {
					HttpSession session = request.getSession(true);
					session.setAttribute("member", member);
					RequestDispatcher rd = request.getRequestDispatcher("HomeStudentForward");
					rd.forward(request, response);
				}
				else if(member.getRole() == 2) {
					HttpSession session = request.getSession(true);
					session.setAttribute("memberTeacher", member);
					RequestDispatcher rd = request.getRequestDispatcher("HomeTeacherForward");
					rd.forward(request, response);
				}
				else {
					HttpSession session = request.getSession(true);
					session.setAttribute("memberAdmin", member);
					RequestDispatcher rd = request.getRequestDispatcher("views/home_admin.jsp");
					rd.forward(request, response);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
