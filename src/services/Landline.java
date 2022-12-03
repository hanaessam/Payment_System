package services;
import discounts.Discount;
import discounts.ServicePrice;
import forms.Form;
import forms.LandlineForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class Landline extends ServiceFactory implements LandlineServiceProvider{

	public static Discount discount;
	public static ReceiptBehavior receiptBehavior;
	
	public Landline() {
		super();
		System.out.println("Landline here...");
	}
	
	public Form createForm() {
		form = new LandlineForm();
		return (LandlineForm)form;
	}

	public void setReceiptChoice() {		
		int choice = ((LandlineForm)form).recieptChoice;
		if(choice == 1 ) {
			receiptBehavior = new QuarterlyReceipt();
		}else {
			receiptBehavior = new MonthlyReceipt();
		}
	}
}