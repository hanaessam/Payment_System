package refunds;

import payment_system.User;

public interface Subject {
	Observer observer = new User();
	public void subscribe(Observer observer);
	public void unSubscribe(Observer observer);
	public void notifyObservers();	
}