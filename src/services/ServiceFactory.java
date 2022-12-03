package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import discounts.Discount;
import discounts.ServicePrice;
import forms.Form;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;
import payment_system.User;

public abstract class ServiceFactory {
	public abstract Form createForm();
	public static Form form ;
	public static Payment payment ;
	public void setPaymentChoice() {
		int choice = ((Form)form).paymentChoice;
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