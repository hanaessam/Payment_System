package payment;

public class Wallet implements Payment {
	Payment creditcardPayment = new CreditCard();
	public static int walletBalance = 0;
	
	public void calculatePayment(int amount) {
		// TODO Auto-generated method stub
		
	}
	public void addFunds(int funds) {
		walletBalance = walletBalance + ((CreditCard) creditcardPayment).funds;
		System.out.println("");
		
	}
	
}
