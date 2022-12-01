package services;

import forms.Form;
import forms.InternetPaymentForm;

public class InternetPayment implements ServiceFactory, ServiceBehavior {
//	Form internetpayform = new InternetPaymentForm();

	public Form createForm() {
		// TODO Auto-generated method stub
		return new InternetPaymentForm();
	}
}
