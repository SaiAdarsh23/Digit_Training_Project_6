package com.digit.JavaTraining.MVCapp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.JavaTraining.MVCapp.model.BankApp;
import com.digit.JavaTraining.MVCapp.model.Transaction;

@WebServlet("/viewAllTransactions")
public class ViewAllTransactionsController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		BankApp curBankUser = (BankApp) curSession.getAttribute("bankapp");
		if (curBankUser == null) {
			curSession.setAttribute("ERROR_MSG", "Invalid Customer! Session Invalid!");
			resp.sendRedirect("/Digit_Training_Project_6/TransferFail.html");
			return;
		}

		Transaction curTransaction = new Transaction();
		ArrayList<Transaction> receiveTransactionsList = curTransaction.viewAllTransactions(curBankUser.getAccNo());

		curSession.setAttribute("ALL_TRANSACTIONS", receiveTransactionsList);
		curSession.setAttribute("isListGenerated", "true");

		resp.sendRedirect("/Digit_Training_Project_6/ViewAllTransactions.jsp");
	}
}
