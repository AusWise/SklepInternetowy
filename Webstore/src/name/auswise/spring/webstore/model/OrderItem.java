package name.auswise.spring.webstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zamawianeprodukty")
public class OrderItem {
	private Long ID;
	private Integer liczba;
	private Product product;
	private Order order;
	
	public OrderItem(){
		
	}
	
	public OrderItem(Integer liczba, Product product) {
		super();
		this.liczba = liczba;
		this.product = product;
	}

	public OrderItem(CartItem cartItem){
		liczba = cartItem.getNumber();
		product = cartItem.getProduct();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return ID;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	
	public Integer getLiczba() {
		return liczba;
	}
	
	public void setLiczba(Integer liczba) {
		this.liczba = liczba;
	}
	
	@ManyToOne
	@JoinColumn(name = "ProduktID")
	public Product getProduct(){
		return product;
	}

	@ManyToOne
	@JoinColumn(name = "ProduktID")
	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne
	@JoinColumn(name = "ZamowienieID")
	public Order getOrder() {
		return order;
	}
	
	@ManyToOne
	@JoinColumn(name = "ZamowienieID")
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
