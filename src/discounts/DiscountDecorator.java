package discounts;

public abstract class DiscountDecorator implements Discount {
	public static Discount discount;
	public static int percent;
	public DiscountDecorator(Discount discount) {
		// TODO Auto-generated constructor stub
		this.discount=discount;
	}
}