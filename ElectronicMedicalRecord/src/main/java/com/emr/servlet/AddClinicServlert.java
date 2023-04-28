package com.emr.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emr.dto.Clinic;
import com.emr.login.LoginModel;

@WebServlet("/addClinicServlet")
public class AddClinicServlert extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String clinicName = request.getParameter("clinic_name");
		String clinicAddress = request.getParameter("clinic_address");
		String clinicPhoneNo = request.getParameter("phone_no");
		String eMailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		boolean isClinicNameValid = new LoginModel().addClinic(clinicName, clinicAddress, clinicPhoneNo, eMailId, password);
		if(isClinicNameValid) {
			Clinic clinic=new LoginModel().isClinic(clinicName, password);
			HttpSession session=request.getSession();
			session.setAttribute("clinic", clinic);
		}
		try {
			response.getWriter().print(isClinicNameValid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
