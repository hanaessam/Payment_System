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
	Schools schools;
	CancerHospital hospital;
	NGOs ngos;
	@Override
	public Form createForm() {
		form = new DonationsForm();
		return (DonationsForm)form;
	}
	
	public void setDonationChoice() {
		int choice = ((DonationsForm)form).donationChoice;
		if (choice == 1) {
			schools = new Schools(((DonationsForm)form).amount);
		} else if (choice == 2) {
			hospital = new CancerHospital(((DonationsForm)form).amount);
		} else if (choice == 3) {
			ngos = new NGOs(((DonationsForm)form).amount);
		}
	}
}