package discounts;

public class OverallDiscount extends DiscountDecorator{
	
	public OverallDiscount(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	public float calculateDicount(int price) {
		float result= price - (((float)(percent)/100 * price));
		return result;
	}
}