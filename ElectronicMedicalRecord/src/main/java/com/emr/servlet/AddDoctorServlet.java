package com.emr.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Clinic;

@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Clinic clinic=(Clinic) session.getAttribute("clinic");
		String doctorName=request.getParameter("doctorName");
		String regdNo=request.getParameter("regdNo");
		String department=request.getParameter("department");
		boolean isDoctorAdded= new ClinicModel().addDoctor(clinic.getClinicId(), doctorName, regdNo, department);
		try {
			response.getWriter().print(isDoctorAdded);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
