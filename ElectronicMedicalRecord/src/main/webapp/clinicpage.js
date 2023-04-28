/**
 * 
 */
let xhr = new XMLHttpRequest();
let doctors;
var medDetails = [];
function getDoctors() {
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			doctors = JSON.parse(xhr.responseText);
			//console.log(doctors);
		}
	}
	xhr.open("GET", "GetDoctorsServlet", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}

function showAddDoctorpage() {
	recordstable.style.display= "none";
	let clinicPage = document.getElementById("clinicpage");
	clinicPage.innerHTML = "";
	addDoctorPage = `<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
 					<input type="button" onclick="showAddPatientpage()" value="Add new patient">
 					<input type="button" onclick="showAddVisitpage()" value="Add visit">
 					<input type="button" onclick="showGetRecordsPage()" value="Get Records">
 					<input type="button" onclick="logout()"value="logout"><br>
 					
 					<div id="doctor_details">
 					<input type="text" id="doctor_name" placeholder="doctor Name" name="doctor_name">
	 				<p id="invalid_name" class="invalid"></p>
					<input type="text" id="regd_no" placeholder="Regd No" name="regd_no"><br>
					<select id="department"><option>Select department</option><option>Cardiologist</option><option>Gastreologist</option><option>Gastreologist</option>Nephrologist<option>Endocrinologist</option><option>Diabetologist</option><option>Pulmonologist</option><option>ENT</option><option>General Physician</option><option>Gynaecologist</option><option>Neurologist</option><option>Oncologist</option><option>Opthalmologist</option><option>Orthopedician</option><option>Paediatrician</option><option>Psychiatrist</option><option>Rhematologist</option><option>Urologist</option></select><br>
					<p id="status" class="invalid"></p>
					<button onclick="doctorVaidation()">submit</button>
					</div>`
	clinicPage.innerHTML = addDoctorPage;

}

function doctorVaidation() {
	let doctorName = document.getElementById("doctor_name").value;
	let regdNo = document.getElementById("regd_no").value;
	let department = document.getElementById("department").value;

	let nameRegex = /^[a-zA-Z\-]{3,}$/;

	let validName = doctorName.match(nameRegex);
	if (validName == null) {
		document.getElementById("invalid_name").innerHTML = "<h6>*Name must contain inly lowercase ,uppercase,atleast 3 letter</h6>";
		return;
	}
	if (department == "Select department" || regdNo=="") return;
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let response = JSON.parse(xhr.responseText);

			if (response) {
				//alert("doctor is added");
				let clinicPage = document.getElementById("clinicpage");
				clinicPage.innerHTML = "";
				clinicHomePage = `<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
 								<input type="button" onclick="showAddPatientpage()" value="Add new patient">
 								<input type="button" onclick="showAddVisitpage()" value="Add visit">
 								<input type="button" onclick="showGetRecordsPage()" value="Get Records">
 								<input type="button" onclick="logout()"value="logout"><br>`

				clinicPage.innerHTML = clinicHomePage;
			}
			else
				document.getElementById("status").innerHTML = "<h6>*doctor is already working</h6>";
		}
	};
	xhr.open("POST", "AddDoctorServlet", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("doctorName=" + doctorName + "&regdNo=" + regdNo + "&department=" + department);
}

function showAddPatientpage() {
	recordstable.style.display= "none";
	let clinicPage = document.getElementById("clinicpage");
	clinicPage.innerHTML = "";
	addPatientPage = `<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
					<input type="button" onclick="showAddPatientpage()" value="Add new patient">
					<input type="button" onclick="showAddVisitpage()" value="Add visit">
					<input type="button" onclick="showGetRecordsPage()" value="Get Records">
					<input type="button" onclick="logout()"value="logout"><br>
					
	 				<input type="text" id="patient_name" placeholder="Patient Name" name="patient_name"><br>
	 				<p id="invalid_patientname" class="invalid"></p>
					<label>Gender :</label>
					<input type="radio" value="male" id="male" name="gender" class="gender">
					<label for="male">Male</label>
					<input type="radio" value="female" id="female" name="gender" class="gender">
					<label for="female">Female</label>
					<input type="radio" value="others" id="others" name="gender" class="gender">
					<label for="others">Others</label><br>
					<p id="invalid_gender" class="invalid"></p>
					<label>D.O.B :</label>
					<input type="date" id="dob" name="dob"><br>
					<p id="invalid_dob" class="invalid"></p>
					<input type="text" id="father_name" placeholder="Father's Name" name="father_name"><br>
					<p id="invalid_fathername" class="invalid"></p>
					<input type="text" id="mother_name" placeholder="Mother's Name" name="mother_name"><br>
					<p id="invalid_mothername" class="invalid"></p>
					<button onclick="patientValidation()">submit</button>`
	clinicPage.innerHTML = addPatientPage;
}

function patientValidation() {
	let nameRegex = /^[a-zA-Z\-]{3,}$/;
	var selectedGender;
	let patientName = document.getElementById("patient_name").value;
	let gender = document.querySelectorAll(".gender");
	for (let i = 0; i < gender.length; i++) {
		if (gender[i].checked)
			selectedGender = gender[i].value;
	}
	let dob = document.getElementById("dob").value;
	let fatherName = document.getElementById("father_name").value;
	let motherName = document.getElementById("mother_name").value;

	let validpatientName = patientName.match(nameRegex);
	let validFatherName = fatherName.match(nameRegex);
	let validMotherName = motherName.match(nameRegex);

	document.getElementById("invalid_patientname").innerHTML = "";
	document.getElementById("invalid_gender").innerHTML = "";
	document.getElementById("invalid_dob").innerHTML = "";
	document.getElementById("invalid_fathername").innerHTML = "";
	document.getElementById("invalid_mothername").innerHTML = "";

	if (validpatientName == null) {
		document.getElementById("invalid_patientname").innerHTML = "<h6>*Name must contain only lowercase ,uppercase,atleast 3 letter</h6>";
		return;
	}
	else if (selectedGender == null) {
		document.getElementById("invalid_gender").innerHTML = "<h6>*required</h6>";
		return;
	}
	else if (dob === "") {
		document.getElementById("invalid_dob").innerHTML = "<h6>*required</h6>";
		return;
	}
	else if (validFatherName == null) {
		document.getElementById("invalid_fathername").innerHTML = "<h6>*Name must contain only lowercase ,uppercase,atleast 3 letter</h6>";
		return;
	}
	else if (validMotherName == null) {
		document.getElementById("invalid_mothername").innerHTML = "<h6>*Name must contain only lowercase ,uppercase,atleast 3 letter</h6>";
		return;
	}


	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			let response = xhr.responseText;
			let clinicPage = document.getElementById("clinicpage");
			clinicPage.innerHTML = "";
			clinicHomePage = `<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
 								<input type="button" onclick="showAddPatientpage()" value="Add new patient">
 								<input type="button" onclick="showAddVisitpage()" value="Add visit">
 								<input type="button" onclick="showGetRecordsPage()" value="Get Patient Records">
 								<input type="button" onclick="logout()" value="logout"><br>
 								<span>Generated Patient's EMR No:</><span id="patient_emrno">${response}</span>`

			clinicPage.innerHTML = clinicHomePage;
		}
	}
	xhr.open("POST", "AddPatientServlet", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("patientName=" + validpatientName + "&gender=" + selectedGender + "&dob=" + dob + "&fatherName=" + validFatherName + "&motherName=" + validMotherName);
}

function showAddVisitpage() {
	recordstable.style.display= "none";
	let clinicPage = document.getElementById("clinicpage");
	clinicPage.innerHTML = "";
	const date = new Date();
	let day = date.getDate();
	let month = date.getMonth() + 1;
	let year = date.getFullYear();
	let today = `${day}-${month}-${year}`;
	addVisitPage = `<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
					<input type="button" onclick="showAddPatientpage()" value="Add new patient">
					<input type="button" onclick="showAddVisitpage()" value="Add visit">
					<input type="button" onclick="showGetRecordsPage()" value="Get Records">
					<input type="button" onclick="logout()"value="logout"><br>
					
	 				<span>Visited on :</span> <span>${today}</span><br>
	 				<input type="number" name="emrno" id="emrno" placeholder="EMR No"><button onclick="getPatient()">check EMR No</button><br>
	 				<div id="patient_details">
	 				</div>
					<input type="text" name="visited_for" id="visited_for" placeholder="visited_for"><br>
					<input type="text" name="clinical_notes" id="clinical_notes" placeholder="clinical_notes"><br>
					<select id="doctors"><option>Doctor Name</option>`;

	for (let i = 0; i < doctors.length; i++) {
		addVisitPage += `<option>dr.${doctors[i].doctorName} - ${doctors[i].regdNo} - ${doctors[i].department}</option>`;
	}

	addVisitPage += `</select><br>
					<button onClick="addVisit()">addVisit</button><br>`
	clinicPage.innerHTML = addVisitPage;
}

function getPatient() {
	let eMRNo = document.getElementById("emrno").value;
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let patientDetails = JSON.parse(xhr.responseText);
			let showPatientDetails = document.getElementById("patient_details");
			if (patientDetails.patientName != null)
				showPatientDetails.innerHTML = "<p id='patient_name'>Patient Name	:" + patientDetails.patientName + "</p><p id='age'> Age	:" + patientDetails.age + "</p><p id='gender'>Gender	:" + patientDetails.gender + "</p><p id='fathername'>Father's Name	:" + patientDetails.fatherName + "</p><p id='mothername'>Mother's Name	:" + patientDetails.motherName + "</p>";
			else
				showPatientDetails.innerHTML = "<h6 id=invaid class='invalid'>*incorrect EMR No</h6>";
		}
	}
	xhr.open("GET", "GetPatientServlet?eMRNo=" + eMRNo, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();

}

function addVisit() {
	let eMRNo = document.getElementById("emrno").value;
	let visitedFor = document.getElementById("visited_for").value;
	let clinicalNotes = document.getElementById("clinical_notes").value;
	let doctor = document.getElementById("doctors").value;


	//console.log(doctor);
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let clinicPage = document.getElementById("clinicpage");
			clinicPage.innerHTML = "";
			let addMedicinesPage=`<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
								<input type="button" onclick="showAddPatientpage()" value="Add new patient">
								<input type="button" onclick="showAddVisitpage()" value="Add visit">
								<input type="button" onclick="showGetRecordsPage()" value="Get Records">
								<input type="button" onclick="logout()"value="logout"><br>
								
								<input id="medicine" placeholder="medicine"></input>
								<select id="bfaf">
								<option>BF/AF</option>
								<option>Before Food</option>
								<option>After Food</option>
								</select>
								<select id="morning">
								<option>Morning</option>
								<option>0</option>
								<option>1</option>
								<option>2</option>
								</select>
								<select id="noon">
								<option>Noon</option>
								<option>0</option>
								<option>1</option>
								<option>2</option>
								</select>
								<select id="night">
								<option>Night</option>
								<option>0</option>
								<option>1</option>
								<option>2</option>
								</select>
								<input id="days" type="number" min="1" placeholder="Days">
								<button onclick="addingmedicine()">Add Medicine</button>
								<button onclick="submitMedicine()">submit medicines</button>
								<div id="invalidmeddetails" class="invalid"><div>
								`;
								
						clinicPage.innerHTML = addMedicinesPage;

		}
	}
	xhr.open("GET", "AddVisitServlet?eMRNo=" + eMRNo + "&visitedFor=" + visitedFor + "&clinicalNotes=" + clinicalNotes + "&doctor=" + doctor, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send();
}

function addingmedicine() {
	let med = document.getElementById("medicine").value;
	let bfaf = document.getElementById("bfaf").value;
	let morning = document.getElementById("morning").value;
	let noon = document.getElementById("noon").value;
	let night = document.getElementById("night").value;
	let days = document.getElementById("days").value;
	
	let medcontainer = document.getElementById("medtable");


	document.getElementById("invalidmeddetails").innerHTML = "";

	if (med === "" || bfaf === "BF/AF" || morning === "Morning" || noon === "Noon" || night === "Night" || days ==="") {
		document.getElementById("invalidmeddetails").innerHTML = "<h6>*please fill medicine details</h6>";
		return;
	}

	var medDetail = { "med": med, "bfaf": bfaf, "morning": morning, "noon": noon, "night": night, "days": days };

	medDetails.push(medDetail);
	//console.log(medDetails);
	medcontainer.style.display = "table";
	let i = medDetails.length - 1;
	medcontainer.innerHTML += `<tr id = "${i}"><td>${med}</td><td>${bfaf}</td><td>${morning}</td><td>${noon}</td><td>${night}</td><td>${days}</td><td><button onclick="removeMedicine(${i})">remove</button></td></tr>`;

}

function removeMedicine(id) {
	let medRow = document.getElementById(id);
	medRow.remove();
	medDetails.splice(id, 1); //remove the JSON object from the medDetails array with the same index as the removed row
	console.log(medDetails);
}

function submitMedicine() {
	let medicineJsonString = JSON.stringify(medDetails);
	//alert("submit");
	console.log(medicineJsonString);
	
		xhr.open("POST", "AddMedicineServlet" , true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("medicines="+medicineJsonString);
		
		location.reload();
	}
	
function showGetRecordsPage(){
	let clinicPage = document.getElementById("clinicpage");
	clinicPage.innerHTML = "";
	let getRecordsPage=`<input type="button" onclick="showAddDoctorpage()" value="Add new doctor">
								<input type="button" onclick="showAddPatientpage()" value="Add new patient">
								<input type="button" onclick="showAddVisitpage()" value="Add visit">
								<input type="button" onclick="showGetRecordsPage()" value="Get Records">
								<input type="button" onclick="logout()"value="logout"><br>
						<input type="number" min="1" id="emrno" placeholder="EMR No"> <button onclick="getRecords()">submit</button>
						<div><table id="medicinetable"><table></div>`
	clinicPage.innerHTML=getRecordsPage;
}

function getRecords(){
	
	let eMRNo = document.getElementById("emrno").value;
	let recordstable = document.getElementById("recordstable");
	recordstable.style.display= "table";
	
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let records =JSON.parse(xhr.responseText);
			recordstable.innerHTML=recordstable.children[0].innerHTML;

			for(let i=0;i<records.length;i++){
				//console.log(records[i]);
				recordstable.innerHTML+=`<tr><td>${records[i].clinicId}</td><td>${records[i].clinicName}</td><td>${records[i].visitedOn}</td><td>${records[i].visitedFor}</td><td>${records[i].clinicalNotes}</td><td>${records[i].doctorName}</td><td>${records[i].regdNo}</td><td> <button id="${records[i].visitId}" value="${records[i].visitId}" onclick="getMedicine(${records[i].visitId})">prescription</td></tr>`;
			}
			
		}
	}
		xhr.open("POST", "GetRecordsServlet" , true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("eMRNo="+eMRNo);
}

function logout(){
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			location.replace("Authentication.jsp");
		}
	}
	
		xhr.open("GET", "LogoutServlet" , true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send();
		
}

function getMedicine(visitId){
	let medicinepage = document.getElementById("medicinetable");
	medicinepage.innerHTML="";
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let medicines = JSON.parse(xhr.responseText);
			medicinepage.innerHTML=`<tr><th>Medicine</th><th>AF/BF</th><th>Morning</th><th>Noon</th><th>Night</th><th>Days</th></tr>`
			for(let i=0;i<medicines.length;i++){
				medicinepage.innerHTML+=`<tr><td>${medicines[i].medicine}</td><td>${medicines[i].bfaf}</td><td>${medicines[i].morning}</td><td>${medicines[i].noon}</td><td>${medicines[i].night}</td><td>${medicines[i].days}</td></tr>`
			}
		}
	}
	
		xhr.open("GET", "GetMedicineServlet?visitId="+visitId , true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send();
}
