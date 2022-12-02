package services;

import discounts.Discount;
import discounts.ServicePrice;
import forms.Form;
import forms.LandlineForm;
import payment.Cash;
import payment.Payment;

public class Landline implements ServiceFactory, LandlineServiceProvider{
	public static Form form = null;
	public static Payment payment = null;
	Discount discount = new ServicePrice();
	public Form createForm() {
		return new LandlineForm();
	}
	public void createPayment() {
		payment = new Cash();
	}
}
