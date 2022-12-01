package services;

import forms.DonationsForm;
import forms.Form;

public class Donations implements ServiceFactory {
//	Form donationForm = new DonationsForm();

//	@Override
	public Form createForm() {
		// TODO Auto-generated method stub
		return new DonationsForm();
	}
}
