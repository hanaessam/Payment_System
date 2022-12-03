package services;

import discounts.Discount;
import forms.Form;
import forms.InternetPaymentForm;
import forms.MobileRechargeForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class InternetPayment implements ServiceFactory, ServiceProvider {
	public static Form form ;
	public static Payment payment ;
	public static Discount discount;
	public static ServiceBehavior serviceBehavior;

	public InternetPayment() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("Internet Payment here...");
	}
	
	public Form createForm() {
		// TODO Auto-generated method stub
		form = new InternetPaymentForm();
		return (InternetPaymentForm)form;
	}

	public void setCompanyChoice() {		
		int choice = ((InternetPaymentForm)form).companyChoice;
		if (choice == 1) {
			serviceBehavior = new Vodafone();
		} else if (choice == 2) {
			serviceBehavior = new Etisalat();
		} else if (choice == 3) {
			serviceBehavior = new We();
		} else if (choice == 4) {
			serviceBehavior = new Orange();
		}
	}
	
	public void setPaymentChoice() {
		int choice = ((InternetPaymentForm)form).paymentChoice;
		if(choice == 1) {
			payment = new CreditCard();
			boolean state=payment.calculatePayment(((InternetPaymentForm)form).amount);
			if(!state) {
				((InternetPaymentForm)form).choosePayment();
				setPaymentChoice();
			}
		}else if(choice == 2) {
			payment = new Cash();
			payment.calculatePayment(((InternetPaymentForm)form).amount);
		}else {
			payment = new Wallet();
			boolean state=payment.calculatePayment(((InternetPaymentForm)form).amount);
			if(!state) {
				((InternetPaymentForm)form).choosePayment();
				setPaymentChoice();
			}
		}
	}
}
