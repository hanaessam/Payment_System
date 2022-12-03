package refunds;

import java.util.HashMap;

public class Refund implements Subject {
	private static final HashMap<String, String> requests = new HashMap<>();
	public static boolean accepted;
	public void subscribe(Observer observer) {};
	public void unSubscribe(Observer observer) {};
	public void notifyObservers() {};
}