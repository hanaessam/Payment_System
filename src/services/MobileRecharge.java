package services;

import discounts.Discount;
import forms.Form;
import forms.LandlineForm;
import forms.MobileRechargeForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class MobileRecharge implements ServiceFactory, ServiceProvider{
	public static Form form ;
	public static Payment payment ;
	public static Discount discount;
	public static ServiceBehavior serviceBehavior;
	
	public MobileRecharge() {
		super();
		System.out.println("Mobile Recharge here...");
	}
	
	public Form createForm() {
		form = new MobileRechargeForm();
		return (MobileRechargeForm)form;
	}
	
	public void setCompanyChoice() {		
		int choice = ((MobileRechargeForm)form).companyChoice;
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
		int choice = ((MobileRechargeForm)form).paymentChoice;
		if(choice == 1) {
			payment = new CreditCard();
			boolean state=payment.calculatePayment(((MobileRechargeForm)form).amount);
			if(!state) {
				((MobileRechargeForm)form).choosePayment();
				setPaymentChoice();
			}
		}else if(choice == 2) {
			payment = new Cash();
			payment.calculatePayment(((MobileRechargeForm)form).amount);
		}else {
			payment = new Wallet();
			boolean state=payment.calculatePayment(((MobileRechargeForm)form).amount);
			if(!state) {
				((MobileRechargeForm)form).choosePayment();
				setPaymentChoice();
			}
		}
	}
}
