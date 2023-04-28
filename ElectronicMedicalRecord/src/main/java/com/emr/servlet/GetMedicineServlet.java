package com.emr.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.emr.clinic.ClinicModel;
import com.emr.dto.Medicine;

@WebServlet("/GetMedicineServlet")
public class GetMedicineServlet extends HttpServlet{
		@SuppressWarnings("unchecked")
		protected void doGet(HttpServletRequest request, HttpServletResponse response) {
			System.out.println(request.getParameter("visitId"));
			int visitId = Integer.parseInt(request.getParameter("visitId"));
			List<Medicine> medicines = new ClinicModel().getMedicines(visitId);
			
			JSONArray medicineJsonArray = new JSONArray();
			
			for(Medicine medicine : medicines) {
				JSONObject medicineJson = new JSONObject();
				medicineJson.put("medicine", medicine.getMedicine());
				medicineJson.put("bfaf", medicine.getBfaf());
				medicineJson.put("morning", medicine.getMorning());
				medicineJson.put("noon", medicine.getNoon());
				medicineJson.put("night", medicine.getNight());
				medicineJson.put("days", medicine.getDays());
				medicineJsonArray.add(medicineJson);
			}
			try {
				response.getWriter().print(medicineJsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
