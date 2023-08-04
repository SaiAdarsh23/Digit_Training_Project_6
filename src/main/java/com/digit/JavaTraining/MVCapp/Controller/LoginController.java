package com.digit.JavaTraining.MVCapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.JavaTraining.MVCapp.model.BankApp;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pin = Integer.parseInt(req.getParameter("pin"));
        int cust_id = Integer.parseInt(req.getParameter("c_id"));
		
        BankApp bankapp = new BankApp();
        bankapp.setCust_id(cust_id);
        bankapp.setPin(pin);
        HttpSession session = req.getSession(true);
        
        boolean b = bankapp.Login();
        if(b==true) {
        	session.setAttribute("bankapp", bankapp);
        	resp.sendRedirect("/Digit_Training_Project_6/Home.jsp");
        }
        else {
        	resp.sendRedirect("/Digit_Training_Project_6/LoginFail.html");
        }
	}
}
