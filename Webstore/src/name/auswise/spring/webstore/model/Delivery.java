package name.auswise.spring.webstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wysylki")
public class Delivery {
	private Long ID;
	private String nazwa;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return ID;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	@Override
	public String toString() {
		return nazwa;
	}
}
