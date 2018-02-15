package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginForCalculator")
public class LoginCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	String username ="user";
	private	String password="calculator";
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       doPost(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getCalculator(request, response);
    }
	private void getCalculator(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("password");
		if(userName.equals(username)&&userPassword.equals(password)) {
			request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
		}
		else {
			 request.setAttribute("errormessage", "invalidUser");
			 request.getRequestDispatcher("/loginForCalculator.jsp").forward(request, response);
		}
	}
	

}
