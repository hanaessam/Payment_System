package services;

import forms.Form;
import forms.InternetPaymentForm;

public class InternetPayment extends ServiceFactory implements ServiceProvider {
	public static ServiceBehavior serviceBehavior;
	public InternetPayment() {
		super();
	}
	
	public Form createForm() {
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
	
}