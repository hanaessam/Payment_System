package services;
import discounts.Discount;
import discounts.ServicePrice;
import forms.Form;
import forms.LandlineForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class Landline implements ServiceFactory, LandlineServiceProvider{
	public static Form form ;
	public static Payment payment ;
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
	
	public void setPaymentChoice() {
		int choice = ((LandlineForm)form).paymentChoice;
		if(choice == 1) {
			payment = new CreditCard();
			boolean state=payment.calculatePayment(((LandlineForm)form).amount);
			if(!state) {
				((LandlineForm)form).choosePayment();
				setPaymentChoice();
			}
		}else if(choice == 2) {
			payment = new Cash();
			payment.calculatePayment(((LandlineForm)form).amount);
		}else {
			payment = new Wallet();
			boolean state=payment.calculatePayment(((LandlineForm)form).amount);
			if(!state) {
				((LandlineForm)form).choosePayment();
				setPaymentChoice();
			}
		}
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