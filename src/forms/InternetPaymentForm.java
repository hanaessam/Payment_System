package forms;

import java.util.Scanner;

public class InternetPaymentForm implements Form {
	private static Scanner myObj = new Scanner(System.in);
	public static String mobileNumber;
	public static int amount;
	public static int companyChoice;
	public static int paymentChoice;
	
	public InternetPaymentForm() {
		this.formHandler();
	}
	
	public void formHandler() {
		System.out.println("Enter your Mobile Number: ");
		mobileNumber = myObj.nextLine();
		System.out.println("Enter the Amount you want to pay : ");
		amount = myObj.nextInt();
		System.out.println("----Choose Provider----");
		System.out.println("1- Vodafone" + "\n" + "2- Etisalat" + "\n" + "3- WE" + "\n" + "4- Orange");
		companyChoice = myObj.nextInt();
		this.choosePayment();
	}
	
	@Override
	public void choosePayment() {
		System.out.println("----Choose Payment Method----");
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
}
