package refunds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import forms.Form;
import payment_system.User;

public class Refund implements Subject {
	public static final HashMap<Integer, List<String>> requests = new HashMap<Integer, List<String>>();
	public static String accepted;
	public static Form form;
	private static Scanner myObj = new Scanner(System.in);
//	public static int refundedAmount;
	public static Observer userObserver;
	public static String observerUsername;
	//public static List<String> userRequestList = new ArrayList<>();
	/*
	 * 1- choice nt-check beh
	 * 2- enter el amount to be refunded
	 * 3- amount to be refunded fel hashmap fe requests + username of user ---> admin
	 * 4- admin get
	 * 
	 * 
	 * 
	 * */
	public void subscribe(Observer userObserver) {
		this.userObserver = (User) userObserver;
		System.out.println(((User) userObserver).username);
			requests.put(((User) userObserver).refundedAmount,((User) userObserver).userRequestList);
			System.out.println(requests);
		}
	
	public void unSubscribe(Observer observer) {};
	public void notifyObservers() {};
}