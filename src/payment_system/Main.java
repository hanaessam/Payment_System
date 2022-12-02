package payment_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import forms.Form;
import services.Donations;
import services.InternetPayment;
import services.Landline;
import services.MobileRecharge;
import services.ServiceFactory;

public class Main {
	static Scanner myObj = new Scanner(System.in);
	private static final Scanner sc = new Scanner(System.in);
	private static User user1 = new User("", "", "");

	public static void prompt() {
		System.out.println("Our Services: ");
		System.out.println("1- Mobile Recharge Services");
		System.out.println("2- Internet Payment Services");
		System.out.println("3- Landline Services ");
		System.out.println("4- Donation Services ");
		System.out.println("Enter your service: ");
		int switchNum = myObj.nextInt();
		switch (switchNum) {
		case 1:
			System.out.println("---Mobile Recharge Services---");
			ServiceFactory mobileRechaServiceFactory = new MobileRecharge();
			mobileRechaServiceFactory.createForm();
			break;
		case 2:
			System.out.println("---Internet Payment Services---");
			ServiceFactory internetPaymentFactory = new InternetPayment();
			internetPaymentFactory.createForm();
			break;
		case 3:
			System.out.println("---Landline Service---");
			ServiceFactory landlineServiceFactory = new Landline();
			landlineServiceFactory.createForm();
			break;
		case 4:
			System.out.println("---Donation Services---");
			ServiceFactory donationServiceFactory = new Donations();
			donationServiceFactory.createForm();
			break;
		}
	}

	public static void main(String[] args) {
		int choice = 1;
		do {
			boolean exitRequested = false;
			while (!exitRequested) {
				System.out.println("------Welcome to fawry system------");
				System.out.println("1- Sign up");
				System.out.println("2- Log in");
				System.out.println("3- Exit");
				System.out.println("Enter 1, to sign up or 2 to log in, 3 for exit");				choice = sc.nextInt();
				switch (choice) {
				case 1:
					register();
					prompt();
					break;

				case 2:
					login();
					prompt();
					break;

				case 3:
					exitRequested = true;
					break;

				default:
					System.out.println("?");
					break;
				}
			}
		} while (choice != 3);
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
		login(); // call login after registering
	}

	public static void login() {
		System.out.println("Username:");
		String username = sc.next();
		System.out.println("Password:");
		String password = sc.next();
		User x = new User();
		HashMap<String, String> loginUser = x.getUserMap();
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
