package com.digit.JavaTraining.MVCapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.JavaTraining.MVCapp.model.BankApp;
import com.digit.JavaTraining.MVCapp.model.Transaction;

@WebServlet("/transfer")
public class TransferAmountController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		BankApp bankapp = (BankApp) session.getAttribute("bankapp");
		int pin = bankapp.getPin();
		
		Transaction t = new Transaction();
		
		t.setCust_id(Integer.parseInt(req.getParameter("cid")));
		t.setBank_name(req.getParameter("bname"));
		t.setIFSC(req.getParameter("ifsc"));
		t.setSender_accno(Integer.parseInt(req.getParameter("accno")));
		t.setReceiver_IFSC(req.getParameter("rifsc"));
		t.setReceiver_accno(Integer.parseInt(req.getParameter("raccno")));
		t.setAmount(Integer.parseInt(req.getParameter("amount")));
		t.setPin(pin);
		
		boolean b = t.transferAmount();
        if(b==true) {
        	resp.sendRedirect("/Digit_Training_Project_6/TransferSuccess.html");
        }
        else {
        	resp.sendRedirect("/Digit_Training_Project_6/TransferFail.html");
        }
	}
}
