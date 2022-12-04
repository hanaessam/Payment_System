package discounts;

public class OverallDiscount extends DiscountDecorator{
	
	public OverallDiscount(Discount discount) {
		super();
		this.discount = discount;
	}
	public float calculateDicount(int discountPercentage) {
		System.out.println("Discount fel overall"+discountPercentage);
		System.out.println("service price "+discount.calculateDicount(discountPercentage));
		float result=((float)discountPercentage/100) * discount.calculateDicount(discountPercentage);
		System.out.println("res overall"+result);
		return result;
	}
}