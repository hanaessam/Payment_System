package services;
import forms.DonationsForm;
import forms.Form;
import payment.Cash;
import payment.CreditCard;
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
	
	@Override
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