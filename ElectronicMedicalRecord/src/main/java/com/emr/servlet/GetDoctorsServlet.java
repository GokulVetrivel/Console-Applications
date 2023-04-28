package com.emr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Clinic;
import com.emr.dto.Doctor;

@SuppressWarnings("serial")
@WebServlet("/GetDoctorsServlet")
public class GetDoctorsServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Clinic clinic=(Clinic) session.getAttribute("clinic");
		List<Doctor> doctors=new ClinicModel().getDoctors(clinic.getClinicId());
		//System.out.println(doctors.toString());
		JSONArray doctorsJson = new JSONArray();
		for(Doctor doctor:doctors) {
			JSONObject doctorJson = new JSONObject();
			doctorJson.put("doctorId", doctor.getDoctorId());
			doctorJson.put("doctorName", doctor.getDoctorName());
			doctorJson.put("doctorId", doctor.getDoctorId());
			doctorJson.put("department", doctor.getDepartment());
			doctorJson.put("regdNo", doctor.getRegdNo());
			
			doctorsJson.add(doctorJson);
		}
		try {
			response.getWriter().print(doctorsJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
