package discounts;

public class SpecificDiscount extends DiscountDecorator{
	
	public SpecificDiscount(Discount discount) {
		super();
		this.discount = discount;
	}
	public float calculateDicount(int discountPercentage) {
		System.out.println("Discount fel specific"+discountPercentage);
		System.out.println("service price "+(discount).calculateDicount(discountPercentage));
		float result=((float)discountPercentage/100) * discount.calculateDicount(discountPercentage);
		System.out.println("res specific"+result);
		return result;
	}
}