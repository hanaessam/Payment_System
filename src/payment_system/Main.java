package payment_system;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.security.auth.Subject;
import forms.Form;
import forms.LandlineForm;
import payment.Wallet;
import refunds.Refund;
import services.Donations;
import services.InternetPayment;
import services.Landline;
import services.MobileRecharge;
import services.ServiceFactory;

public class Main {
	static Scanner myObj = new Scanner(System.in);
	private static final Scanner sc = new Scanner(System.in);
	private static User user1 = new User();
	public static Refund refundSubject = new Refund();
	public static List<User> users=new ArrayList<>();
	public static ServiceFactory mobileRechaServiceFactory = new MobileRecharge();
	public static ServiceFactory internetPaymentFactory = new InternetPayment();
	public static ServiceFactory landlineServiceFactory = new Landline();
	public static ServiceFactory donationServiceFactory = new Donations();
	
	public static HashMap<List<String>, Integer> adminResponse() {
		for (List<String> i : refundSubject.requests.keySet()) {
			if(i.size() != 2) {
				System.out.println("1-enter 'a' for Accepted \n2-enter 'r' for  Rejecterd");
				String accepted = sc.next();
				if (!(i.contains("a") && i.contains("r"))) {
					i.add(accepted);
				}
				System.out.println(refundSubject.requests);
				for(int j=0;j<users.size();j++) {
					if(users.get(j).username == i.get(0) && accepted == "a" && accepted == "r") {
					    System.out.println("List of requests: "+ refundSubject.requests.get(i));
						((Wallet)users.get(j).wallet).setWalletBalance(refundSubject.requests.get(i));
						break;
					}
				}
			}
		}
		return (HashMap<List<String>, Integer>) refundSubject.requests;
	}

	public static void prompt() {
		System.out.println("Our Services: ");
		System.out.println("1- Mobile Recharge Services");
		System.out.println("2- Internet Payment Services");
		System.out.println("3- Landline Services ");
		System.out.println("4- Donation Services ");
		System.out.println("5- Add funds to wallet ");
		System.out.println("Enter your service: ");
		int switchNum = myObj.nextInt();
		switch (switchNum) {
		case 1:
			System.out.println("---Mobile Recharge Services---");
			Form mobileForm = mobileRechaServiceFactory.createForm();
			((MobileRecharge) mobileRechaServiceFactory).setCompanyChoice();
			((MobileRecharge) mobileRechaServiceFactory).setPaymentChoice();
			if( user1.requestRefund(((MobileRecharge) mobileRechaServiceFactory).form.amount) ) {
				refundSubject.subscribe(user1);
			}
			break;
		case 2:
			System.out.println("---Internet Payment Services---");
			Form internetForm = internetPaymentFactory.createForm();
			((InternetPayment) internetPaymentFactory).setCompanyChoice();
			((InternetPayment) internetPaymentFactory).setPaymentChoice();
			if( user1.requestRefund(((InternetPayment) internetPaymentFactory).form.amount) ) {
				refundSubject.subscribe(user1);
			}
			break;
		case 3:
			System.out.println("---Landline Service---");
			Form landlineForm = landlineServiceFactory.createForm();
			((Landline) landlineServiceFactory).setReceiptChoice();
			((Landline) landlineServiceFactory).setPaymentChoice();
			if ( user1.requestRefund(((Landline) landlineServiceFactory).form.amount) ) {
				refundSubject.subscribe(user1);
			}
			break;
		case 4:
			System.out.println("---Donation Services---");
			Form donationForm = donationServiceFactory.createForm();
			((Donations) donationServiceFactory).setDonationChoice();
			((Donations) donationServiceFactory).setPaymentChoice();
			if( user1.requestRefund(((Donations) donationServiceFactory).form.amount) ) {
				refundSubject.subscribe(user1);
			}
			break;
		case 5:
			System.out.println("---Add funds to wallet---");
			((Wallet) user1.wallet).addFunds();
		}
	}

	public static void main(String[] args) {
		int choice = 1;
		while (choice != 3) {
			user1.userRequestList = new ArrayList<>(); //
			System.out.println("\n------Welcome to fawry system------");
			System.out.println("Choose from the following \n1- Admin\n2- User\n3- Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("----Choose----");
				System.out.println("1- Add discount");
				System.out.println("2- View  refund requests");
				System.out.println("3- Exit");
				int temp = sc.nextInt();
				switch (temp) {
				case 1:
					 int c;
					System.out.println("\n1- Overall Descount \n2- Specific Discount");
					c = myObj.nextInt();
					if(c == 2) {
						System.out.println("Our Services \n1- Mobile Recharge Services");
						System.out.println("2- Internet Payment Services");
						System.out.println("3- Landline Services ");
						System.out.println("Enter your service: ");
						int s = myObj.nextInt();
						System.out.println("Enter the percentage of the discount: ");
						int discountPercentSpecific = myObj.nextInt();
						
						switch (s) {
						case 1: {
							mobileRechaServiceFactory.specificDiscount = discountPercentSpecific;
							break;
						}
						case 2:{
							internetPaymentFactory.specificDiscount = discountPercentSpecific;
							break;
						}
						case 3:{
							landlineServiceFactory.specificDiscount = discountPercentSpecific;
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + s);
						}
					}else {
						System.out.println("Enter the percentage of the discount: ");
						int discountPercentOverall = myObj.nextInt();
						mobileRechaServiceFactory.overallDiscount = discountPercentOverall;
						internetPaymentFactory.overallDiscount = discountPercentOverall;
						landlineServiceFactory.overallDiscount = discountPercentOverall;
					}
					break;
				case 2:
					System.out.println(refundSubject.requests);
					adminResponse();
					break;
				case 3:
					return;
				default:
					System.out.println("Unexpected value: " + temp);
					break;
				}
				break;
			}
			case 2: {
				System.out.println("\n1- Sign up");
				System.out.println("2- Log in");
				System.out.println("3- Exit");
				System.out.println("Enter 1, to sign up or 2 to log in, 3 for exit");
				int temp = sc.nextInt();
				switch (temp) {
				case 1:
					register();
					prompt();
					users.add(user1);
					break;
				case 2:
					login();
					prompt();
					break;
				case 3:
					return;
				default:
					System.out.println("Unexpected value: " + temp);
					break;
				}
				break;
			}
			case 3:
				return;
			default:
				System.out.println("Unexpected value: " + choice);
			}
		}
		prompt();
	}

	public static void register() {
		System.out.println("Please enter Email");
		String email = sc.next();
		System.out.println("Please enter username");
		String username = sc.next();
		System.out.println("Please enter password");
		String password = sc.next();
		User newMember = new User(username, password, email);
		user1.register(newMember);
		user1.username = username;
		login(); 
	}

	public static void login() {
		System.out.println("Username:");
		String username = sc.next();
		System.out.println("Password:");
		String password = sc.next();
		HashMap<String, String> loginUser = user1.getUserMap();
		System.out.println("hash : " + loginUser); //
		find(loginUser, username, password);
	}

	public static void find(HashMap<String, String> loginUser, String username, String password) {
		boolean f = false;
		for (String i : loginUser.keySet()) {
			if (i.equals(username) && loginUser.get(i).equals(password)) {
				System.out.println("User is Found!");
				f = true;
				break;
			}
		}
		if (!f) {
			System.out.println("User Not Found. please \t 1-Login Again -  2-sign up");
			int c = sc.nextInt();
			if (c == 1)
				login();
			else if (c == 2)
				register();
		}
	}
}