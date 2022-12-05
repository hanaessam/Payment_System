package services;

import discounts.Discount;
import forms.Form;
import forms.LandlineForm;
import forms.MobileRechargeForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class MobileRecharge extends ServiceFactory implements ServiceProvider{
	public static ServiceBehavior serviceBehavior;
	public MobileRecharge() {
		super();
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

}
