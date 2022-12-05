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
	public static Scanner myObj = new Scanner(System.in);
	public static Refund refundSubject = new Refund();
	public static Form userForm;
	public static ServiceFactory mobileRechaServiceFactory = new MobileRecharge();
	public static ServiceFactory internetPaymentFactory = new InternetPayment();
	public static ServiceFactory landlineServiceFactory = new Landline();
	public static ServiceFactory donationServiceFactory = new Donations();
	
	public static void main(String[] args) {
		int choice = 1;
		while (choice != 3) {
			userForm.user.userRequestList = new ArrayList<>(); //
			System.out.println("\n------Welcome to our payment system------");
			System.out.println("Choose from the following \n1- Admin\n2- User\n3- Exit");
			choice = myObj.nextInt();
			switch (choice) {
			case 1: {
				userForm.getAdminForm();
				break;
			}
			case 2: {
				System.out.println("\n1- Sign up");
				System.out.println("2- Log in");
				System.out.println("3- Exit");
				System.out.println("Enter 1, to sign up or 2 to log in, 3 for exit");
				int temp = myObj.nextInt();
				switch (temp) {
				case 1:
					userForm.register();
					userForm.getUserPrompt();
					userForm.users.add(userForm.user);
					break;
				case 2:
					userForm.login();
					userForm.getUserPrompt();
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
		userForm.getUserPrompt();
	}
	
}

	