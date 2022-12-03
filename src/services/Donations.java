package services;

import discounts.Discount;
import forms.DonationsForm;
import forms.Form;
import forms.MobileRechargeForm;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;
import payment.Wallet;

public class Donations extends ServiceFactory {

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


}
