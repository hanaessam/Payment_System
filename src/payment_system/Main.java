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
			System.out.println("\n------Welcome to fawry system------");
			System.out.println("Choose from the following \n1- Admin\n2- User\n3- Exit");
			choice = myObj.nextInt();
			switch (choice) {
			case 1: {
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
					userForm.adminResponse();
					userForm.user.update();
					break;
				case 3:
					return;
				default:
					System.out.println("sUnexpected value: " + temp);
					break;
				}
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
					userForm.userpPrompt();
					userForm.users.add(userForm.user);
					break;
				case 2:
					userForm.login();
					userForm.userpPrompt();
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
		userForm.userpPrompt();
	}
	
}

	