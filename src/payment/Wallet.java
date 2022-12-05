package payment;

import java.util.Scanner;

public class Wallet implements Payment {
	Scanner myObj = new Scanner(System.in);
	Payment creditcardPayment = new CreditCard();
	public static int walletBalance = 0;
	
	public boolean calculatePayment(int amount) {
		if(walletBalance==0 || walletBalance<amount) {
			System.out.println("\nWallet = "+walletBalance);
			System.out.println("Wallet balance is not enough"+"\nChoose another payment method");
			return false;
		}
		walletBalance = walletBalance - amount;
		System.out.print("-SUCCESS-\nYour wallet balance after payment: "+ walletBalance+"\n");
		return true;
	}
	public void addFunds() {
		System.out.println("Enter the amount you want to add to wallet:");
		int funds=myObj.nextInt();
		if( ((CreditCard) creditcardPayment).addToWallet(funds) ){
			walletBalance = walletBalance + funds;
			System.out.println(funds+ " added successfully to wallet");
			System.out.println("Wallet balance is now : " + walletBalance);
		}
	}
	public void setWalletBalance(Integer i) {
		walletBalance+=i;
		System.out.println(walletBalance);
	}
}