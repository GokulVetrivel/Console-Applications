package com.emr.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Patient;

@SuppressWarnings("serial")
@WebServlet("/GetPatientServlet")
public class GetPatientServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int eMRNo = Integer.parseInt(request.getParameter("eMRNo"));
		Patient patient = new ClinicModel().getPatient(eMRNo);
		JSONObject patientJson = new JSONObject();
		//System.out.println(patient.getName()+" "+patient.getAge()+" "+patient.getGender());
		if (patient != null) {
			patientJson.put("patientName", patient.getName());
			patientJson.put("age", patient.getAge());
			patientJson.put("gender", patient.getGender());
			patientJson.put("fatherName", patient.getFatherName());
			patientJson.put("motherName", patient.getMotherName());
		}
		
		try {
			response.getWriter().print(patientJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
