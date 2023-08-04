package com.digit.JavaTraining.MVCapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Loan {
	
	public static Connection con;
	
	int loanID;
    String loanType;
    int tenure;
    float intrest;
    String description;

    public Loan() {
    	String url = "jdbc:mysql://localhost:3306/bankApp";
        String user = "root";
        String pwd = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }

    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }
 
    public String getLoanType() {
        return loanType;
    }
 
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public float getIntrest() {
        return intrest;
    }

    public void setIntrest(float intrest) {
        this.intrest = intrest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean ApplyLoan(String typeOfLoan) {
    	try {
			String query = "SELECT * FROM Loan WHERE Ltype = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, typeOfLoan);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				this.loanID = rs.getInt("Lid");
				this.loanType = rs.getString("Ltype");
				this.tenure = rs.getInt("tenure");
				this.intrest = rs.getFloat("interest");
				this.description = rs.getString("description");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    }

}
