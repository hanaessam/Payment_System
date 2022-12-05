package discounts;

public class ServicePrice implements Discount {

	public static int servicePrice;
	public ServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}
	
	public float calculateDiscount(int price) {
		return price;
	}
}
