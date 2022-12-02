package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import discounts.Discount;
import discounts.ServicePrice;
import forms.Form;
import payment.Cash;
import payment.Payment;
import payment_system.User;

public interface ServiceFactory {
//	public static Form form = null;
//	public static Payment payment = null;
//	Discount discount = new ServicePrice();
//	List<User> listOfUsers = new ArrayList<>();
	public Form createForm();
}