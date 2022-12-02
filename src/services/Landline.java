package services;

import java.security.PublicKey;

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
	public static ReceiptBehavior receiptBehavior;
	Discount discount = new ServicePrice();
	
	public Landline() {
		super();
		System.out.println("Landline here...");
	}
	
	public Form createForm() {
		form = new LandlineForm();
		return (LandlineForm)form;
	}
	
	public static void setPaymentChoice() {
		
		
		int choice = ((LandlineForm)form).paymentChoice;
		if(choice == 1) {
			payment = new CreditCard();
		}else if(choice == 2) {
			payment = new Cash();
		}else {
			payment = new Wallet();
		}
		
	}
	public static void setReceiptChoice() {
		
		int choice = ((LandlineForm)form).recieptChoice;
		if(choice == 1 ) {
			receiptBehavior = new QuarterlyReceipt();
		}else {
			receiptBehavior = new MonthlyReceipt();
		}
	}
}
