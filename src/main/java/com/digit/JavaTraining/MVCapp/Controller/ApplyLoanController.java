package com.digit.JavaTraining.MVCapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.JavaTraining.MVCapp.model.Loan;

@WebServlet("/loan")
public class ApplyLoanController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeOfLoan = req.getParameter("loan");
		
		HttpSession session = req.getSession();
		
		Loan currLoan = new Loan();
		boolean b = currLoan.ApplyLoan(typeOfLoan);
		if(b==true) {
			session.setAttribute("curLoan", currLoan);
			resp.sendRedirect("/Digit_Training_Project_6/LoanDetails.jsp");
		}
		else {
			resp.sendRedirect("/Digit_Training_Project_6/LoanDetailsFail.jsp");
		}
		
	}
}
