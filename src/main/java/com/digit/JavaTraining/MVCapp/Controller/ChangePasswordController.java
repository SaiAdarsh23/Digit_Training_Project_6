package com.digit.JavaTraining.MVCapp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.JavaTraining.MVCapp.model.BankApp;

@WebServlet("/changepword")
public class ChangePasswordController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        String np = req.getParameter("np");
        String cp = req.getParameter("cp");
        
        HttpSession session = req.getSession();
        BankApp bankapp = (BankApp) session.getAttribute("bankapp");
        boolean b = bankapp.ChangePassword(np, cp);
        
        if(b==true) {
            resp.sendRedirect("/Digit_Training_Project_6/PwordChangeSuccess.html");
        }
        else {
            resp.sendRedirect("/Digit_Training_Project_6/PwordChangeFail.html");
        }
	}
}
