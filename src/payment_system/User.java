package payment_system;

import java.util.HashMap;
import java.util.Scanner;

import payment.Wallet;
import refunds.Observer;
import refunds.Refund;

public class User implements Observer {
	Scanner myObj = new Scanner(System.in); 
	private final String username;
	private final String email;
	private final String password;
	private static final HashMap<String, String> loginUser = new HashMap<>();
	Wallet wallet;
	Refund refund;
	public User() {
		this.username = "";
		this.email = "";
		this.password = "";
	}
	public User(String username, String email, String password) {
		this.username = username;
	    this.password = password;
	    this.email = email;
	}

	public String getUsername() {
		 return this.username + "";
	}
	public String getPassword() {
		return this.password + "";
	}
	public String getEmail() {
		return this.email + "";
	}
	public HashMap<String, String> getUserMap() {
	     return loginUser;
	}


}
