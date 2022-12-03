package payment;

import java.util.Scanner;

import forms.Form;
import forms.LandlineForm;

public class CreditCard implements Payment {
	public static int balance=0;	
	private static Scanner myObj = new Scanner(System.in);

	public boolean calculatePayment(int amount) {
		System.out.println("Enter your balance in credit card: ");
		balance = myObj.nextInt();
		if(balance<amount) {
			System.out.println("Not enough credit"+"\nChoose another payment method");
			return false;
		}
		balance = balance - amount;
		System.out.print("-SUCCESS-\nYour balance after payment: "+ balance+"\n");
		return true;
	}
	public boolean addToWallet(int funds) {
		System.out.println("Enter your balance in credit card: ");
		balance = myObj.nextInt();
		if(balance<funds) {
			System.out.println("Not enough credit to add funds in wallet\n");
			return false;
		}
		balance = balance - funds;
		System.out.print("Your balance after adding funds: "+ balance+"\n");
		return true;
	}
}
