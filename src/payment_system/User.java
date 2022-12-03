package payment_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import forms.Form;
import payment.Payment;
import payment.Wallet;
import refunds.Observer;
import refunds.Refund;

public class User implements Observer {
	Scanner myObj = new Scanner(System.in);
	public static int request;
	public static String username;
	private final String email;
	private final String password;
	Form form ;
	Payment wallet= new Wallet();
	private static final HashMap<String, String> loginUser = new HashMap<>();
	public static List<String> userRequestList;
	public static int refundedAmount;
	public static String accepted;
	
	public User() {
		User.username = "";
		this.email = "";
		this.password = "";
		userRequestList  = new ArrayList<>();
	}
	public User(String username, String password, String email) {
		User.username = username;
	    this.password = password;
	    this.email = email;
	}
	public List< String> getUserListRequest(){
		return userRequestList;
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
//	 public boolean isUserExist(User user){
//	        if(loginUser.containsKey(user.getUsername()) && loginUser.containsValue(user.getPassword())){
//	            return true;
//	        } else {
//	            System.out.println("No member in the list!");
//	        }
//	        return false;
//	    }

	    //something also wrong here
	    public void register(User user) {
	        loginUser.put(user.getUsername(),user.getPassword());
	        System.out.println("here: "+user.getUsername());
	        System.out.println("here: "+user.getPassword());
	    }
//	    public void login(User member){
//	        if(isUserExist(member)) {
//	            System.out.println("Hello " + member.getEmail());
//	        } else {
//	            System.out.println("No member with username " +member.getUsername());
//	        }
//	    }
	    public void requestRefund() {
	    	int choice = Form.refund();
	    	if(choice==1) {
	    	System.out.println("Enter amount to be refunded: ");
			refundedAmount = myObj.nextInt();
			System.out.print( "user name  "+User.username);
			//username = loginUser.get(username);
			userRequestList.add(username);
			accepted = "acc";
			userRequestList.add(accepted);
			userRequestList = getUserListRequest();
			System.out.print(userRequestList);
	    }
	    }
}
