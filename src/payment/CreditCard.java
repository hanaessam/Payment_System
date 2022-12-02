package payment;

import java.util.Scanner;

import forms.Form;

public class CreditCard implements Payment {
	public static int balance;	
	public static int funds;	
	private static Scanner myObj = new Scanner(System.in);


	public void calculatePayment(int amount) {
		System.out.println("Enter your balance in credit card: ");
		balance = myObj.nextInt();
		balance = balance - amount;
		System.out.print("Your balance after payment: "+ balance+"\n");
	}
	public void addToWallet(int funds) {
		System.out.println("Enter your balance in credit card: ");
		balance = myObj.nextInt();
		balance = balance - funds;
		System.out.print("Your balance after adding funds: "+ balance+"\n");
	}
	
}
