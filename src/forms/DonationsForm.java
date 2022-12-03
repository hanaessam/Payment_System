package forms;

import java.util.Scanner;

public class DonationsForm implements Form {
	private static Scanner myObj = new Scanner(System.in);
	public static int amount;
	public static int donationChoice;
	public static int paymentChoice;
	
	public DonationsForm() {
		this.formHandler();
	}
	
	public void formHandler() {
		System.out.println("Enter the Amount you want to donate : ");
		amount = myObj.nextInt();
		System.out.println("----Choose----");
		System.out.println("1- Cancer Hospitals" + "\n" + "2- Schools" + "\n" + "3- NGOs");
		donationChoice = myObj.nextInt();
		this.choosePayment();
	}
	
	@Override
	public void choosePayment() {
		System.out.println("----Choose Payment Method----");
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
}