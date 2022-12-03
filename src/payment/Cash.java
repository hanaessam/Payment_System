package payment;

public class Cash implements Payment {
	public boolean calculatePayment(int amount) {
		System.out.println("Please pay "+ amount+" on delivery ..");
		return true;
	}
}
