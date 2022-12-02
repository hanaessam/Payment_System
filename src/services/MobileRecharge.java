package services;

import forms.Form;
import forms.MobileRechargeForm;

public class MobileRecharge implements ServiceFactory, ServiceBehavior {
		public Form createForm() {
		return new MobileRechargeForm();
	}
//	if (choice == 1) {
//		
//	} else if (choice == 2) {
//		
//
//	} else if (choice == 3) {
//		
//
//	} else if (choice == 4) {
//		
//
//	}
}
