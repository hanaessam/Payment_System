package forms;

import java.util.Scanner;

public class DonationsForm extends Form {
	private static Scanner myObj = new Scanner(System.in);
	public static int donationChoice;
	
	public DonationsForm() {
		this.formHandler();
	}
	
	public void formHandler() {
		System.out.println("----Choose----");
		System.out.println("1- Cancer Hospitals" + "\n" + "2- Schools" + "\n" + "3- NGOs");
		donationChoice = myObj.nextInt();
		System.out.println("Enter the Amount you want to donate : ");
		amount = myObj.nextInt();
		choosePayment();
		refund();
	}
}