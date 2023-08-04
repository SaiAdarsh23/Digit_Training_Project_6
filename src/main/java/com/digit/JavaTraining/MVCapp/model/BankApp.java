package com.digit.JavaTraining.MVCapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;



public class BankApp {
	int bank_id;
	String bank_name;
	String ifsc_code;
	int AccNo;
	int pin;
	int cust_id;
	String cust_name;
	int balance;
	String email;
	long phone;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	public static Connection con;

	public BankApp() {
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
	
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getifsc_code() {
		return ifsc_code;
	}
	public void setifsc_code(String ifsc_code) {
		ifsc_code = ifsc_code;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public boolean Register() {
		try {
            pstmt = con.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, bank_id);
            pstmt.setString(2, bank_name);
            pstmt.setString(3, ifsc_code);
            pstmt.setInt(4, AccNo);
            pstmt.setInt(5, pin);
            pstmt.setInt(6, cust_id);
            pstmt.setString(7, cust_name);
            pstmt.setInt(8, balance);
            pstmt.setString(9, email);
            pstmt.setLong(10, phone);

            int x = pstmt.executeUpdate();
            if(x>0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public boolean Login() {
		try {
            pstmt = con.prepareStatement("select * from bankapp where Cust_id=? and pin=?");
            
            pstmt.setInt(1, cust_id);
            pstmt.setInt(2, pin);          
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()) {
            	 bank_id = resultSet.getInt("bank_id");
            	 bank_name = resultSet.getString("bank_name");
            	 ifsc_code = resultSet.getString("IFSC_code");
            	 AccNo = resultSet.getInt("AccNo");
            	 pin = resultSet.getInt("pin");
            	 cust_id = resultSet.getInt("Cust_id");
            	 cust_name = resultSet.getString("Cust_Name");
            	 balance = resultSet.getInt("Balance");
            	 email = resultSet.getString("Email");
            	 phone = resultSet.getLong("Phone");
            	 cust_id = resultSet.getInt("Cust_id");
            	
            	return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public boolean ChangePassword(String np, String cp) {
		try {
			
            if(np.equals(cp)) {
            	pstmt = con.prepareStatement("update bankapp set pin = ? where AccNo = ?");
                pstmt.setInt(1, Integer.parseInt(np));
                pstmt.setInt(2, AccNo);          
                
                int x = pstmt.executeUpdate();
                if(x>0) {
                    return true; 
                }
                else {
                    return false;
                }
            }
            else {
            	return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
	
}
