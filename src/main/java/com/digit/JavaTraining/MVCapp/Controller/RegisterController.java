package com.digit.JavaTraining.MVCapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.JavaTraining.MVCapp.model.BankApp;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        BankApp bankapp = new BankApp();
        bankapp.setAccNo(Integer.parseInt(req.getParameter("accno")));
        bankapp.setBalance(Integer.parseInt(req.getParameter("bal")));
        bankapp.setBank_id(Integer.parseInt(req.getParameter("b_id")));
        bankapp.setBank_name(req.getParameter("b_name"));
        bankapp.setCust_id(Integer.parseInt(req.getParameter("c_id")));
        bankapp.setCust_name(req.getParameter("c_name"));
        bankapp.setEmail(req.getParameter("email"));
        bankapp.setifsc_code(req.getParameter("ifsc_code"));
        bankapp.setPhone(Long.parseLong(req.getParameter("phone")));
        bankapp.setPin(Integer.parseInt(req.getParameter("pin")));
        
        boolean b = bankapp.Register();
        if(b==true) {
        	resp.sendRedirect("/Digit_Training_Project_6/RegisterSuccess.html");
        }
        else {
        	resp.sendRedirect("/Digit_Training_Project_6/RegisterFail.html");
        }
        
	}
}
