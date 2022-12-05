package refunds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import forms.Form;
import payment_system.User;

public class Refund implements Subject {
	public static final Map<List<String>,Integer> requests = new HashMap<>();
	public static String accepted;
	public static Form form;
	private static Scanner myObj = new Scanner(System.in);
	public static Observer userObserver;
	public static String observerUsername;
	Form userForm;
	
	
	public void subscribe(Observer userObserver) {
		Refund.userObserver = (User) userObserver;
		System.out.println(User.username);
			requests.put(((User) userObserver).userRequestList,((User) userObserver).refundedAmount);
			System.out.println(requests);
	}
	public void unSubscribe(Observer observer) {
		Refund.userObserver = (User) userObserver;
		System.out.println(User.username);
			requests.remove(((User) userObserver).userRequestList,((User) userObserver).refundedAmount);
			System.out.println(requests);
	};
	
	public void notifyObservers(String message) {
        for (User user : userForm.users) {
            user.update();
        }
	}
	
}