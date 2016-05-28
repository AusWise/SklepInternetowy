package name.auswise.spring.webstore.model;

public class CartItem {
	private Product product;
	private int number;
	
	public CartItem(Product product, int number) {
		this.product = product;
		this.number = number;
	}
	
	public CartItem(){
		
	}

	public Product getProduct() {
		return product;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
