package services;

import forms.Form;
import forms.MobileRechargeForm;

public class MobileRecharge implements ServiceFactory, ServiceBehavior {
	
//	Form mobilerechargeform = new MobileRechargeForm();
	public Form createForm() {
		return new MobileRechargeForm();
	}
}
