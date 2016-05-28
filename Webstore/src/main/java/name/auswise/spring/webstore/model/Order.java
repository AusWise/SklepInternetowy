package name.auswise.spring.webstore.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zamowienia")
public class Order {
	
	private Long ID;
	private List<OrderItem> orderItems;
	private Delivery delivery;
	private Payment payment;
	private Date Data;
	private User user;
	
	public Order(){
		orderItems = new LinkedList<OrderItem>();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return ID;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	
	@OneToMany(mappedBy="order",targetEntity=OrderItem.class)
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void setOrderItems(Cart cart) {
		OrderItem orderItem;
		for(CartItem cartItem: cart.getCartItems()){
			orderItem = new OrderItem(cartItem);
			orderItem.setOrder(this);
			orderItems.add(orderItem);
		}
	}
	
	@ManyToOne
	@JoinColumn(name = "WysylkaID")
	public Delivery getDelivery() {
		return delivery;
	}
	
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	@ManyToOne
	@JoinColumn(name = "PlatnoscID")
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Date getData() {
		return Data;
	}
	
	public void setData(Date data) {
		Data = data;
	}

	@ManyToOne
	@JoinColumn(name = "UzytkownikID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
