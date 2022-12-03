package forms;

import java.util.Scanner;

public class LandlineForm extends Form {
	private static Scanner myObj = new Scanner(System.in);
	public static String homeNumber;
	public static int recieptChoice;
		
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
		choosePayment();
	}
	
}