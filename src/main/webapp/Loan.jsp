<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.JavaTraining.MVCapp.model.BankApp"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-image:
		url("/Digit_Training_Project_6/images/BankApp1.png");
	background-size: cover;
	background-position: center;
}
body::before {
			content: "";
			background-image: inherit;
			background-size: cover;
			background-repeat: no-repeat;
			filter: blur(2px);
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: -1;
		}

.container {
	max-width: 400px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h1 {
	color: #3366cc;
	margin-bottom: 20px;
}

p {
	margin-bottom: 20px;
}

label {
	font-weight: bold;
}

form {
	margin-top: 20px;
}

input[type="text"] {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	width: 100%;
	margin-top: 5px;
}

input[type="submit"] {
	background-color: #3366cc;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 4px;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.4s ease;
}

input[type="submit"]:hover {
	background-color: #005580;
}
</style>
</head>
<body>

	<%
	session = request.getSession();
	if (session == null) {
		response.sendRedirect("/BankingWithMVC/index.html");
		return;
	}

	BankApp curBankUser = (BankApp) session.getAttribute("bankapp");
	if (curBankUser == null) {
		response.sendRedirect("/MVCBankApp/Welcome.html");
		return;
	}
	%>

	<div class="container">
		<h1>Apply for Loan</h1>
		<h2>Select Type Of Loan to Apply</h2>

		<p>1. Home Loan</p>
		<p>2. Educational Loan</p>
		<p>3. Vehicle Loan</p>
		<p>4. Gold Loan</p>
		<p>5. Personal Loan</p>

		<form action="loan">

			<label>Select Your Choice</label><br><br>
			<select name="loan" id="loan">
				<option value="Home Loan">Home Loan</option>
				<option value="Educational Loan">Educational Loan</option>
				<option value="Vehicle Loan">Vehicle Loan</option>
				<option value="Gold Loan">Gold Loan</option>
				<option value="Personal Loan">Personal Loan</option>
			</select> <br> <br> <br> <input type="submit" name="Apply">
		</form>
	</div>

</body>
</html>