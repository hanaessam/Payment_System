package forms;

import java.util.Scanner;

public class MobileRechargeForm implements Form {
	public String mobileNumber;
	public int amount;
	public int choice;
	
	private static Scanner myObj = new Scanner(System.in);
	public void userFormInformation() {
		System.out.println("Enter your Mobile Number: ");
		mobileNumber = myObj.nextLine();
		System.out.println("Enter the Amount you want to pay : ");
		amount = myObj.nextInt();
		System.out.println("----Choose Provider----");
		System.out.println("1- vodafone" + "\n" + "2- Etisalat" + "\n" + "3- WE" + "\n" + "4- Orange");
		choice = myObj.nextInt();
	}

	public void formHandler() {
		if (choice == 1) {
			
		} else if (choice == 2) {
			

		} else if (choice == 3) {
			

		} else if (choice == 4) {
			

		}
	}
}
