package com.emr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Doctor;
import com.emr.dto.Record;
@WebServlet("/GetRecordsServlet")
public class GetRecordsServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		int eMRNo = Integer.parseInt(request.getParameter("eMRNo"));
		List<Record> records = new ClinicModel().getRecords(eMRNo);
		JSONArray recordsJson = new JSONArray();
		for(int i=records.size()-1;i>=0;i--) {
			JSONObject recordJson = new JSONObject();
			recordJson.put("clinicId", records.get(i).getClinicId());
			recordJson.put("clinicName", records.get(i).getClinicName());
			String visitedDate =  records.get(i).getVisitedOn().toString();
			recordJson.put("visitedOn", visitedDate);
			recordJson.put("visitedFor", records.get(i).getVisitedFor());
			recordJson.put("clinicalNotes", records.get(i).getClinicalNotes());
			recordJson.put("doctorName", records.get(i).getDoctorName());
			recordJson.put("regdNo", records.get(i).getRegdNo());
			recordJson.put("visitId", records.get(i).getVisitId());
			recordsJson.add(recordJson);
		}
		try {
			response.getWriter().print(recordsJson);
			System.out.println("thi is json records :"+recordsJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Record rec:records) {
			System.out.println(rec.getClinicId()+"\t"+rec.getClinicName()+"\t"+rec.getVisitedOn()+"\t"+rec.getVisitedFor()+"\t"+rec.getClinicalNotes()+"\t"+rec.getDoctorName());
		}
	}
}
