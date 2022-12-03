package services;

import discounts.Discount;
import forms.DonationsForm;
import forms.Form;
import forms.MobileRechargeForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class Donations implements ServiceFactory {
	public static Form form ;
	public static Payment payment ;
	public static Discount discount;

	@Override
	public Form createForm() {
		form = new DonationsForm();
		return (DonationsForm)form;
	}
	
	public void setDonationChoice() {		
		int choice = ((DonationsForm)form).donationChoice;
		if (choice == 1) {
//			choice = new ;
		} else if (choice == 2) {
//			choice = new ;
		} else if (choice == 3) {
//			choice = new ;
		}
	}

	@Override
	public void setPaymentChoice() {
		int choice = ((DonationsForm)form).paymentChoice;
		if(choice == 1) {
			payment = new CreditCard();
			boolean state=payment.calculatePayment(((DonationsForm)form).amount);
			if(!state) {
				((DonationsForm)form).choosePayment();
				setPaymentChoice();
			}
		}else if(choice == 2) {
			payment = new Cash();
			payment.calculatePayment(((DonationsForm)form).amount);
		}else {
			payment = new Wallet();
			boolean state=payment.calculatePayment(((DonationsForm)form).amount);
			if(!state) {
				((DonationsForm)form).choosePayment();
				setPaymentChoice();
			}
		}
	}
}
