package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import discounts.Discount;
import discounts.ServicePrice;
import forms.Form;
import payment_system.User;

public interface ServiceFactory {
	Discount discount = new ServicePrice();
	List<User> listOfUsers = new ArrayList<>();
	
	public Form createForm();
	
}
