package payment_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import forms.Form;
import payment.Payment;
import payment.Wallet;
import refunds.Observer;

public class User implements Observer {
	Scanner myObj = new Scanner(System.in);
	public static int request;
	public static String username;
	private final String email;
	private final String password;
	Form form;
	public Payment wallet = new Wallet();
	private static final HashMap<String, String> loginUser = new HashMap<>();
	public List<String> userRequestList;
	public static int refundedAmount;
	public static String accepted;

	public User() {
		User.username = "";
		this.email = "";
		this.password = "";
		userRequestList = new ArrayList<>();
	}

	public User(String username, String password, String email) {
		User.username = username;
		this.password = password;
		this.email = email;
	}

	public List<String> getUserListRequest() {
		return userRequestList;
	}

	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}

	public String getUsername() {
		return User.username + "";
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

	public void register(User user) {
		loginUser.put(user.getUsername(), user.getPassword());
	}

	public boolean requestRefund(int amount) {
		int choice = Form.refund();
		if (choice == 1) {
			System.out.println("Enter amount to be refunded: ");
			refundedAmount = myObj.nextInt();
			if(amount==refundedAmount) {
				userRequestList.add(username);
				userRequestList = getUserListRequest();
				return true;
			}
			else {
				System.out.println("You have to refund a complete transaction");
			}
		}
		return false;
	}
	public void update() {
		System.out.println("Refunded amount updated!");
	}
}