package forms;
import java.util.Scanner;

public abstract class Form {
	private static Scanner myObj = new Scanner(System.in);
	public static int paymentChoice;
	public static int amount;
	
	public abstract void formHandler();
	
	public static int refund() {
		int choice;
		System.out.println("Do you want a refund:\n"+"1- Yes\n"+"2- No");	
		choice=myObj.nextInt();
		return choice;
	}
	public void choosePayment() {
		System.out.println("----Choose Payment Method----");
		System.out.println("1- Credit card" + "\n" + "2- Cash" + "\n" + "3- Wallet" + "\n" );
		paymentChoice = myObj.nextInt();
	}
}