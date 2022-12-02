package forms;

import java.util.Scanner;

public class LandlineForm implements Form {
	public String homeNumber;
	public int amount;
	public int recieptChoice;
	public int paymentChoice;
	
	private static Scanner myObj = new Scanner(System.in);
	
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
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
}
