package forms;

import java.util.Scanner;

public class MobileRechargeForm implements Form {
	public String mobileNumber;
	public int amount;
	public int companyChoice;
	public int paymentChoice;
	
	private static Scanner myObj = new Scanner(System.in);
	public void formHandler() {
		System.out.println("Enter your Mobile Number: ");
		mobileNumber = myObj.nextLine();
		System.out.println("Enter the Amount you want to pay : ");
		amount = myObj.nextInt();
		System.out.println("----Choose Provider----");
		System.out.println("1- vodafone" + "\n" + "2- Etisalat" + "\n" + "3- WE" + "\n" + "4- Orange");
		companyChoice = myObj.nextInt();
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPaymentChoice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getReceiptChoice() {
		// TODO Auto-generated method stub
		return 0;
	}
}