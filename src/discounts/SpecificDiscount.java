package discounts;

public class SpecificDiscount extends DiscountDecorator{
	
	public SpecificDiscount(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	public float calculateDicount(int price) {
		System.out.println("Discount fel specific"+(percent));
//		System.out.println("service price "+(discount).calculateDicount(price));
		float result=price - (((float)(percent)/100 * price));
		System.out.println("res specific"+result);
		return result;
	}
}