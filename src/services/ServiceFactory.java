package services;

import discounts.Discount;
import discounts.DiscountDecorator;
import discounts.OverallDiscount;
import discounts.ServicePrice;
import discounts.SpecificDiscount;
import forms.Form;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public abstract class ServiceFactory {
	Discount discount;
	public abstract Form createForm();
	public static Form form ;
	public static Payment payment;
	public static int overallDiscount = 0;
	public static int specificDiscount = 0;
	
	public void setPaymentChoice() {
		int choice = ((Form)form).paymentChoice;
		discount = new ServicePrice(form.amount);
		System.out.println(ServicePrice.servicePrice);
		if(specificDiscount!=0) {
			discount=new SpecificDiscount(discount);
			((DiscountDecorator)discount).percent = specificDiscount;
			form.amount = (int)discount.calculateDicount(form.amount);
			System.out.println(form.amount);
		}
		if(overallDiscount!=0) {
				discount = new OverallDiscount(discount);
				((DiscountDecorator)discount).percent = overallDiscount;
				form.amount = (int)discount.calculateDicount(form.amount);
				System.out.println(form.amount);
		}
		if(choice == 1) {
			payment = new CreditCard();
			boolean state=payment.calculatePayment(((Form)form).amount);
			if(!state) {
				((Form)form).choosePayment();
				setPaymentChoice();
			}
		}else if(choice == 2) {
			payment = new Cash();
			payment.calculatePayment(((Form)form).amount);
		}else {
			payment = new Wallet();
			boolean state=payment.calculatePayment(((Form)form).amount);
			if(!state) {
				((Form)form).choosePayment();
				setPaymentChoice();
			}
		}
	}
}
	
	
	