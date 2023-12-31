package hello.core.order;

public class Order {

	private String itemName;
	private int itemPrice;
	private int discountPrice;
	private long memberId;
	

	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		// TODO Auto-generated constructor stub
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
		this.memberId = memberId;	
		}
	public int caculatePrice() {
		return itemPrice - discountPrice;
	}
	
	@Override
	public String toString() {
		return "Order [itemName=" + itemName + ", "
				+ "itemPrice=" + itemPrice + ", "
				+ "discountPrice=" + discountPrice
				+ ", emberId=" + memberId + "]";
	}
	public long getEmberId() {
		return memberId;
	}
	public void setEmberId(long emberId) {
		this.memberId = emberId;
	}
	public String getItemName() { 
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	
}
