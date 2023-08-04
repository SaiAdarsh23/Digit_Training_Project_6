<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.JavaTraining.MVCapp.model.BankApp, 
	com.digit.JavaTraining.MVCapp.model.Transaction, java.util.ArrayList"%>

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
	max-width: 900px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 15px;
	text-align: center;
	border: 1px solid #ccc;
}

th {
	background-color: #3366cc;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	display: block;
	margin-top: 20px;
	text-align: center;
	color: #3366cc;
	text-decoration: none;
	font-weight: bold;
	transition: color 0.3s;
}

a:hover {
	color: #005580;
}

tr.green {
	background-color: #c8e6c9;
}

tr.red {
	background-color: #ffcdd2;
}
</style>
</head>
<body>

	<%
	session = request.getSession();
	if (session == null) {
		response.sendRedirect("/Digit_Training_Project_6/Home.html");
		return;
	}

	BankApp curBankUser = (BankApp) session.getAttribute("bankapp");
	if (curBankUser == null) {
		response.sendRedirect("/Digit_Training_Project_6/Home.jsp");
		return;
	}

	String isListGenerated = (String) session.getAttribute("isListGenerated");
	if (isListGenerated == null) {
		response.sendRedirect("/Digit_Training_Project_6/viewAllTransactions");
	} else {
		session.removeAttribute("isListGenerated");
	}

	ArrayList<Transaction> arrayList = (ArrayList<Transaction>) session.getAttribute("ALL_TRANSACTIONS");
	if (arrayList == null) {
		return;
	}
	%>

	<%
	if (arrayList.size() == 0) {
	%>
	<h1 align="center">No Transactions Made Yet!</h1>
	<%
	return;
	}
	%>


	<div class="container">
		<h1 align="center">All Transactions</h1>
		<br>
		<table>
			<tr>
				<th>Transaction ID</th>
			<th>Customer ID</th>
			<th>Sender Bank Name</th>
			<th>Sender Bank IFSC Code</th>
			<th>Sender Account Number</th>
			<th>Receiver IFSC</th>
			<th>Receiver Account Number</th>
			<th>Amount of Transfer</th>
			</tr>

			<%
			for (Transaction curTransaction : arrayList) {
				String trTypeClass = curTransaction.getSender_accno() == curBankUser.getAccNo() ? "red" : "green";
			%>
			<tr class="<%=trTypeClass%>">
				<td><%=curTransaction.getTransaction_id()%></td>
			<td><%=curTransaction.getCust_id()%></td>
			<td><%=curTransaction.getBank_name()%></td>
			<td><%=curTransaction.getIFSC()%></td>
			<td><%=curTransaction.getSender_accno()%></td>
			<td><%=curTransaction.getReceiver_IFSC()%></td>
			<td><%=curTransaction.getReceiver_accno()%></td>
			<td><%=curTransaction.getAmount()%></td>
			</tr>
			<%
			}
			%>

		</table>
		<a href="Home.jsp">Go to Home Page</a>
	</div>

</body>
</html>