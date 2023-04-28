package com.emr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.emr.clinic.ClinicModel;

/*

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/

import com.emr.dto.Medicine;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/AddMedicineServlet")
public class AddMedicineServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AddMedicineServlet");
		String medicineArray=request.getParameter("medicines");
		HttpSession session = request.getSession();
			int visitId=(int) session.getAttribute("visitId");
			JSONArray medicineJsonArray = new JSONArray(medicineArray);
			
				for (int i = 0; i < medicineJsonArray.length(); i++) {
					  JSONObject jsonObject = medicineJsonArray.getJSONObject(i);
					  String medicineName=jsonObject.getString("med");
					  String bfaf=jsonObject.getString("bfaf");
					  int morning=jsonObject.getInt("morning");
					  int noon=jsonObject.getInt("noon");
					  int night=jsonObject.getInt("night");
					  int days=jsonObject.getInt("days");
					  new ClinicModel().addMedication(visitId,medicineName, bfaf, morning, noon, night, days);
					}
				//session.removeAttribute("visitId");
				
	}
}
