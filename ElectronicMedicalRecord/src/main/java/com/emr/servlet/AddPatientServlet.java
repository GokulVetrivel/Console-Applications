package com.emr.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Clinic;

@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String patientName = request.getParameter("patientName");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		
		int eMRNo = new ClinicModel().addPatient(patientName, gender, Date.valueOf(dob), fatherName, motherName);
		try {
			response.getWriter().println(eMRNo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
