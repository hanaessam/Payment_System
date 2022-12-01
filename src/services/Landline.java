package services;

import forms.Form;
import forms.LandlineForm;

public class Landline implements ServiceFactory, LandlineServiceProvider{

	public Form createForm() {
		// TODO Auto-generated method stub
		return new LandlineForm();
	}

}
