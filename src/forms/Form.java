package forms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import payment.Payment;
import payment.Wallet;
import payment_system.User;
import refunds.Refund;
import services.Donations;
import services.InternetPayment;
import services.Landline;
import services.MobileRecharge;
import services.ServiceFactory;

public abstract class Form {
	private static Scanner myObj = new Scanner(System.in);
	public static int paymentChoice;
	public static int amount;
	public static Payment payment ;
	public static ServiceFactory mobileRechaServiceFactory = new MobileRecharge();
	public static ServiceFactory internetPaymentFactory = new InternetPayment();
	public static ServiceFactory landlineServiceFactory = new Landline();
	public static ServiceFactory donationServiceFactory = new Donations();
	public static User user = new User();
	public static Refund refundSubject = new Refund();
	public static List<User> users=new ArrayList<>();
	
	public abstract void formHandler();
	public static int refund() {
		int choice;
		System.out.println("Do you want a refund:\n"+"1- Yes\n"+"2- No");	
		choice=myObj.nextInt();
		return choice;
	}
	public void choosePayment() {
		System.out.println("----Choose Payment Method----");
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
	public static void getUserPrompt() {
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
			if(user.requestRefund(((MobileRecharge) mobileRechaServiceFactory).form.amount)) {
				refundSubject.subscribe(user);
			}
			break;
		case 2:
			System.out.println("---Internet Payment Services---");
			internetPaymentFactory.createForm();
			((InternetPayment) internetPaymentFactory).setCompanyChoice();
			((InternetPayment) internetPaymentFactory).setPaymentChoice();
			if( user.requestRefund(((InternetPayment) internetPaymentFactory).form.amount) ) {
				refundSubject.subscribe(user);
			}
			break;
		case 3:
			System.out.println("---Landline Service---");
			Form landlineForm = landlineServiceFactory.createForm();
			((Landline) landlineServiceFactory).setReceiptChoice();
			((Landline) landlineServiceFactory).setPaymentChoice();
			if ( user.requestRefund(((Landline) landlineServiceFactory).form.amount) ) {
				refundSubject.subscribe(user);
			}
			break;
		case 4:
			System.out.println("---Donation Services---");
			Form donationForm = donationServiceFactory.createForm();
			((Donations) donationServiceFactory).setDonationChoice();
			((Donations) donationServiceFactory).setPaymentChoice();
			if( user.requestRefund(((Donations) donationServiceFactory).form.amount) ) {
				refundSubject.subscribe(user);
			}
			break;
		case 5:
			System.out.println("---Add funds to wallet---");
			((Wallet) user.wallet).addFunds();
		}
	}
	
	public static void register() {
		System.out.println("----Register----");
		System.out.println("Please enter Email");
		String email = myObj.next();
		System.out.println("Please enter username");
		String username = myObj.next();
		System.out.println("Please enter password");
		String password = myObj.next();
		User newMember = new User(username, password, email);
		user.register(newMember);
		user.username = username;
		login(); 
	}

	public static void login() {
		System.out.println("----Login----");
		System.out.println("Username:");
		String username = myObj.next();
		System.out.println("Password:");
		String password = myObj.next();
		HashMap<String, String> loginUser = user.getUserMap();
		System.out.println("hash : " + loginUser); //
		findUser(loginUser, username, password);
	}

	public static void findUser(HashMap<String, String> loginUser, String username, String password) {
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
			int c = myObj.nextInt();
			if (c == 1)
				login();
			else if (c == 2)
				register();
		}
	}
	
	
	public static HashMap<List<String>, Integer> getAdminResponse() {
		for (List<String> i : refundSubject.requests.keySet()) {
			if(i.size() != 2) {
				System.out.println("1-enter 'a' for Accepted \n2-enter 'r' for  Rejecterd");
				String accepted = myObj.next();
				if (!(i.contains("a") && i.contains("r"))) {
					i.add(accepted);
				}
				System.out.println(refundSubject.requests);
				for(int j=0;j<users.size();j++) {
					if(users.get(j).username == i.get(0) && accepted == "a" && accepted == "r") {
						((Wallet)users.get(j).wallet).setWalletBalance(refundSubject.requests.get(i));
						break;
					}
				}
			}
		}
		return (HashMap<List<String>, Integer>) refundSubject.requests;
	}
	
	
	public static void getAdminForm() {
		System.out.println("----Choose----");
		System.out.println("1- Add discount");
		System.out.println("2- View refund requests");
		System.out.println("3- Exit");
		int temp = myObj.nextInt();
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
			getAdminResponse();
			user.update();
			break;
		case 3:
			return;
		default:
			System.out.println("sUnexpected value: " + temp);
			break;
		}
		
}
	
}