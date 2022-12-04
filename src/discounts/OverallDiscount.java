package discounts;

public class OverallDiscount extends DiscountDecorator{
	
	public OverallDiscount(Discount discount) {
		super(discount);
		this.discount = discount;
	}
	public float calculateDicount(int price) {
		System.out.println("Discount fel overall"+percent);
		System.out.println("price fel overall abl el discount:"+price+"\n");
//		System.out.println("service price "+(discount).calculateDicount(price));
		float result= price - (((float)(percent)/100 * price));
		System.out.println("res overall"+result);
		return result;
	}
}