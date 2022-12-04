package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import discounts.Discount;
import discounts.OverallDiscount;
import discounts.ServicePrice;
import discounts.SpecificDiscount;
import forms.Form;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;
import payment_system.User;

public abstract class ServiceFactory {
	Discount discount;
	public abstract Form createForm();
	public static Form form ;
	public static Payment payment;
	public static int overallDiscount = 0;
	public static int specificDiscount = 0;
	
	
	public void setPaymentChoice() {
		System.out.println("overall:"+overallDiscount);
		System.out.println("specific:"+specificDiscount);
		int choice = ((Form)form).paymentChoice;
		discount = new ServicePrice(form.amount);
		System.out.println(ServicePrice.servicePrice);
		if(overallDiscount!=0) {
			discount = new OverallDiscount(discount);
			((Form)form).amount = (int)discount.calculateDicount(overallDiscount);
			System.out.println(discount.calculateDicount(overallDiscount));
		}
		if(specificDiscount!=0) {
			discount=new SpecificDiscount(discount);
			((Form)form).amount = (int)discount.calculateDicount(specificDiscount);
			System.out.println(discount.calculateDicount(specificDiscount));
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
	
	
	