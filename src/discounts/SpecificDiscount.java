package discounts;

public class SpecificDiscount extends DiscountDecorator{
	
	public SpecificDiscount(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	public float calculateDiscount(int price) {
		float result=price - (((float)(percent)/100 * price));
		return result;
	}
}