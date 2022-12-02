package forms;

import java.util.Scanner;

public class InternetPaymentForm implements Form {
	public String homenumber;
	public int amount;
	public int companyChoice;
	public int paymentChoice;
	
	private static Scanner myObj = new Scanner(System.in);
	public void formHandler() {
		System.out.println("Enter your home number: ");
		homenumber = myObj.nextLine();
		System.out.println("Enter the Amount you want to pay : ");
		amount = myObj.nextInt();
		System.out.println("----Choose Provider----");
		System.out.println("1- Vodafone" + "\n" + "2- Etisalat" + "\n" + "3- We" + "\n" + "4- Orange");
		companyChoice = myObj.nextInt();
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}

}
