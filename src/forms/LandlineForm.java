package forms;

import java.util.Scanner;

public class LandlineForm implements Form {
	private static Scanner myObj = new Scanner(System.in);
	public static String homeNumber;
	public static int amount;
	public static int recieptChoice;
	public static int paymentChoice;
		
	public LandlineForm() {
		this.formHandler();
	}
	
	public void formHandler() {
		System.out.println("Enter your home Number: ");
		homeNumber = myObj.nextLine();
		System.out.println("Enter the Amount you want to pay : ");
		amount = myObj.nextInt();
		System.out.println("----Choose Reciept Option----");
		System.out.println("1- Quarterly Reciept" + "\n" + "2- Monthly Reciept" + "\n" );
		recieptChoice = myObj.nextInt();
		this.choosePayment();
	}
	public void choosePayment() {
		System.out.println("----Choose Payment Method----");
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
}