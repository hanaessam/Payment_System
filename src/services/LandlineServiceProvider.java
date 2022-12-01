package services;

public interface LandlineServiceProvider {
	ReceiptBehavior monthlyReceiptBehavior = new MonthlyReceipt();
	ReceiptBehavior quarterlyReceiptBehavior = new QuarterlyReceipt();
}
