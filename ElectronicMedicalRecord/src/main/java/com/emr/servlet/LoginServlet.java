package com.emr.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emr.dto.Clinic;
import com.emr.login.LoginModel;


@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String clinicName=request.getParameter("clinicName");
		String password=request.getParameter("password");
		Clinic clinic=new LoginModel().isClinic(clinicName, password);
		//System.out.println(clinic);
		if(clinic!=null) {
			try {
				HttpSession session=request.getSession();
				session.setAttribute("clinic", clinic);
				response.getWriter().print(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				response.getWriter().print(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
}
