package com.emr.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Clinic;
@SuppressWarnings("serial")
@WebServlet("/AddVisitServlet")
public class AddVisitServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Clinic clinic = (Clinic)session.getAttribute("clinic");
		System.out.println(request.getParameter("eMRNo"));
		int eMRNo =Integer.parseInt(request.getParameter("eMRNo"));
		
		String vivsitedFor = request.getParameter("visitedFor");
		String clinicalNotes = request.getParameter("clinicalNotes");
		String doctor = request.getParameter("doctor");
		
		String[] docArr = doctor.split(" ");
		
		int visitId = new ClinicModel().addVisit(clinic.getClinicId(), eMRNo, vivsitedFor, clinicalNotes, docArr[2]);
		session.setAttribute("visitId", visitId);
		
	}
}
