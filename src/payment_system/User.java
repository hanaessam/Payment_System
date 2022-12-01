package payment_system;

import java.util.Scanner;

import payment.Wallet;
import refunds.Observer;
import refunds.Refund;

public class User implements Observer {
	Scanner myObj = new Scanner(System.in); 
	private String username;
	private String password;
	Wallet wallet;
	Refund refund;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
//	public boolean logIn() {
//		System.out.println("Enter your username: ");
//		String newUsername = myObj.nextLine();
//		System.out.println("Enter your password: ");
//		String newPassword = myObj.nextLine();
//		if(getUsername() == newUsername && getPassword() == newPassword){
//			return true;
//			}else {
//			return false;	
//		}
//	}
//	public void signUp() {
//		System.out.println("Enter your username: ");
//		String newUsername = myObj.nextLine();
//		setUsername(newUsername);
//		System.out.println("Enter your password: ");
//		String newPassword = myObj.nextLine();
//		setPassword(newPassword);
//	}
}
