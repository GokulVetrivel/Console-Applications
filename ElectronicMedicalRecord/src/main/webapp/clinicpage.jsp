<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.emr.dto.Clinic"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>clinic page</title>
</head>
<style>
	.invalid{
		color:red;
	}
	#status{
		color:red;
	}
	.table th,td{
	border:2px solid black;
	padding:12px 14px;
	font-size:16px;
	}
	.table{
	border-collapse:collapse;
	display:none;
	}
</style>
<%
if(session.getAttribute("clinic")==null) response.sendRedirect("Authentication.jsp");
%>
<body onload="getDoctors()">
 	<div id="clinicpage">
 	<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
 	<input type="button" onclick="showAddPatientpage()" value="Add new patient">
 	<input type="button" onclick="showAddVisitpage()" value="Add visit">
 	<input type="button" onclick="showGetRecordsPage()" value="Get Records">
 	<input type="button" onclick="logout()"value="logout">
 	</div>
 	<table id="medtable" class="table">
 	<tr><th>Medicine Name</th><th>BF/AF</th><th>Morning</th><th>Noon</th><th>Night</th><th>Days</th><th>Remove</th></tr>
 	</table>
 	<div>
 	<table id="recordstable" class="table">
 	<tr><th>Clinic Id</th><th>Clinic Name</th><th>Visited On</th><th>Visited for</th><th>Clinical Notes</th><th>Doctor Name</th><th>REGD No</th><th>Medication</th></tr>
 	</table>
 	</div>
</body>
<script src="clinicpage.js"></script>
</html>