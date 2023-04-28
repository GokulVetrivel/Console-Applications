<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	.invalid{
		color:red;
	}
	#status{
		color:red;
	}
	#click{
		color:red;
	}
	#click:hover{
		color:blue;
	}
</style>
<body>
	<div id="homepage">
		<div class="login">
			<label>clinic login</label><br>
			<input type="text" id="clinic_name" placeholder="clinic Name" name="clinic_name"><br>
			<input type="password" id="password" placeholder="password" name="password"><br>
			<p id="status"></p>
			<input type="button" onclick="checkClinicCredentials()" id="login" value="login">
		</div>
	
		<div class="signup">
			<span>new clinic Registration</span>
			<span id="click" onclick="showSignUpPage()">click here</span>
		</div>
	</div>
</body>
<script src="Authentication.js">
	
</script>
</html>