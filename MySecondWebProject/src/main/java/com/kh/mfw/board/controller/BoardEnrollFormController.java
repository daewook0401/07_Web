package com.kh.mfw.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/enrollForm.board")
public class BoardEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardEnrollFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			request.getRequestDispatcher("WEB-INF/views/board/enroll_form.jsp").forward(request, response);
		}
		session.setAttribute("message", "로그인해주세요!");
		response.sendRedirect(request.getContextPath() + "/boards");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
