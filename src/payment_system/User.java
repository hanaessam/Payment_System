package payment_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import payment.Payment;
import payment.Wallet;
import refunds.Observer;
import refunds.Refund;

public class User implements Observer {
	Scanner myObj = new Scanner(System.in);
	public static int request;
	private final String username;
	private final String email;
	private final String password;
	Payment wallet= new Wallet();
	private static final HashMap<String, String> loginUser = new HashMap<>();
	public static List<String> userRequestList = new ArrayList<>();
	public static int refundedAmount;
	public static String accepted;
	
	public User() {
		this.username = "";
		this.email = "";
		this.password = "";
	}
	public User(String username, String password, String email) {
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
	 public boolean isUserExist(User user){
	        if(loginUser.containsKey(user.getUsername()) && loginUser.containsValue(user.getPassword())){
	            return true;
	        } else {
	            System.out.println("No member in the list!");
	        }
	        return false;
	    }

	    //something also wrong here
	    public void register(User user) {
	        loginUser.put(user.getUsername(),user.getPassword());
	    }
	    public void login(User member){
	        if(isUserExist(member)) {
	            System.out.println("Hello " + member.getEmail());
	        } else {
	            System.out.println("No member with username " +member.getUsername());
	        }
	    }
	    public void requestRefund() {
	    	System.out.println("Enter amount to be refunded: ");
			refundedAmount = myObj.nextInt();
			userRequestList.add(username);
			accepted = "";
			userRequestList.add(accepted);
	    }
}
