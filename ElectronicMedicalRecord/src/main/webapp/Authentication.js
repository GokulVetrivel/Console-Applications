/**
 * 
 */

let xhr = new XMLHttpRequest();

function checkClinicCredentials() {
	let clinicName = document.getElementById("clinic_name").value;
	console.log(clinicName);
	let password = document.getElementById("password").value;
	//alert("test");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let response = JSON.parse(xhr.responseText);
			if (response)
				location.replace("clinicpage.jsp");
			else
				document.getElementById("status").innerHTML = "<h6>invalid credentials</h6>";
		}
	};
	xhr.open("POST", "LoginServlet", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("clinicName=" + clinicName + "&password=" + password);
}

function showSignUpPage() {
	let homePage = document.getElementById("homepage");
	homePage.innerHTML = "";

	let signupPage = `<div id="signuppage">
	 	
		<label>SignUp</label><br>
		
		<input type="text" id="clinic_name" placeholder="Clinic name" name="clinic_name"><br>
		<p id="invalidclinic_name" class="invalid"> </p>
		<input type="text" id="clinic_address" placeholder="Address" name="clinic_address"><br>
		<p id="invalidclinic_address" class="invalid"> </p>
		<input type="text" id="phone_no" placeholder="Phone number" name="phone_no"><br>
		<p id="invalidphone_no" class="invalid"> </p>
		<input type="text" id="emailid" placeholder="E-Mail Id" name="emailid" oninput="this.value = this.value.toLowerCase()" ><br>
		<p id="invalidemailid" class="invalid"> </p>
		<input type="password" id="password" placeholder="Password" name="password"><br>
		<p id="invalidpassword" class="invalid"> </p>
		<input type="password" id="reenterpassword" placeholder="Re-Enter Password" name="reenterpassword"><br>
		<p id="invalidreenterpassword" class="invalid"> </p>
		<input type="button" value="sign up" onclick="clinicValidation()"><br>
		<span>Existing clinic</span>
		<span id ="click" onclick="showLoginPage()">click here</span>
		
	</div>`

	homePage.innerHTML = signupPage;
}

function showLoginPage(){
	let homePage = document.getElementById("homepage");
	homePage.innerHTML = "";
	
	let loginPage = `<div class="login">
			<label>clinic login</label><br> <input type="text"
			id="clinic_name" placeholder="clinic Name" name="clinic_name"><br>
			<input type="password" id="password" placeholder="password" name="password"><br>
			<p id="status" style="color: red"></p>
			<input type="button" onclick="checkClinicCredentials()" id="login" value="login">
			</div>

			<div class="signup">
			<label>new clinic Registration</label> <input type="button" onclick="showSignUpPage()" value="click here">
			</div>`
			
			homePage.innerHTML = loginPage;
}


function clinicValidation() {
	let nameRegex = /^[a-zA-Z0-9\-]+$/;
	let addressRegex = /^[a-zA-Z0-9\s//,'-]{10,50}$/;
	let emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	let phonenoRegex = /^[6789]\d{9}$/;
	let passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;

	let validName = document.getElementById("clinic_name").value.match(nameRegex);
	let validAddress = document.getElementById("clinic_address").value.match(addressRegex);
	let validPhone = document.getElementById("phone_no").value.match(phonenoRegex);
	let validEmail = document.getElementById("emailid").value.match(emailRegex)[0];
	let validPassword = document.getElementById("password").value.match(passwordRegex);
	let reEnterPassword = document.getElementById("reenterpassword").value;

	document.getElementById("invalidclinic_name").innerHTML = "";
	document.getElementById("invalidclinic_address").innerHTML = "";
	document.getElementById("invalidphone_no").innerHTML = "";
	document.getElementById("invalidemailid").innerHTML = "";
	document.getElementById("invalidpassword").innerHTML = "";

	let check = true;
	if (validName == null) {
		document.getElementById("invalidclinic_name").innerHTML = "<h6>* only contain upper case, lower case, numbers</h6>";
		check = false;
	}
	else if (validAddress == null) {
		document.getElementById("invalidclinic_address").innerHTML = "<h6>* length should be 10-50 and only ,/ ' special characters are allowed</h6>";
		check = false;
	}
	else if (validAddress == null) {
		document.getElementById("invalidclinic_address").innerHTML = "<h6>* lenth should be 10-50</h6>";
		check = false;
	}
	else if (validPhone == null) {
		document.getElementById("invalidphone_no").innerHTML = "<h6>* enter valid phone number</h6>";
		check = false;
	}
	else if (validEmail == null) {
		document.getElementById("invalidemailid").innerHTML = "<h6>* enter valid email id</h6>";
		check = false;
	}
	else if (validPassword == null) {
		document.getElementById("invalidpassword").innerHTML = "<h6>* must contain atleast one lower case, one upper case, one number and minimum 8 characters</h6>";
		check = false;
	}
	else if (reEnterPassword != validPassword) {
		document.getElementById("invalidreenterpassword").innerHTML = "<h6>* password mismatch</h6>";
		check = false;
	}


	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let res = JSON.parse(xhr.responseText);
			if(res){
				alert("registration success");
				location.replace("clinicpage.jsp");
			}
			else{
				document.getElementById("invalidclinic_name").innerHTML = "<h6>* clinic name already exist </h6>";
			}
		}
	};
	
	if(check){
	xhr.open("POST", "addClinicServlet", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("clinic_name="+validName+"&clinic_address="+validAddress+"&phone_no="+validPhone+"&emailid="+validEmail+"&password="+validPassword);
	}
}