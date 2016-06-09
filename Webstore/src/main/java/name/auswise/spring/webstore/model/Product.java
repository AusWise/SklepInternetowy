package name.auswise.spring.webstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produkt")
public class Product {
	
	private Long ID;
	
	@ManyToOne
	@JoinColumn(name = "TypproduktuID")
	private ProductType typProduktu;
	
	@ManyToOne
	@JoinColumn(name = "ProducentID")
	private Producer producent;
	
	private String Nazwa;
	private String Opis;
	private double Cena;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return ID;
	}
	
	public void setID(Long ID) {
		this.ID = ID;
	}
	
	@ManyToOne
	@JoinColumn(name = "TypproduktuID")
	public ProductType getTypProduktu() {
		return typProduktu;
	}
	
	@ManyToOne
	@JoinColumn(name = "TypproduktuID")
	public void setTypProduktu(ProductType typProduktu) {
		this.typProduktu = typProduktu;
	}
	
	@ManyToOne
	@JoinColumn(name = "ProducentID")
	public Producer getProducent() {
		return producent;
	}
	
	@ManyToOne
	@JoinColumn(name = "ProducentID")
	public void setProducent(Producer producent) {
		this.producent = producent;
	}
	
	public String getNazwa() {
		return Nazwa;
	}
	
	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}
	
	public String getOpis() {
		return Opis;
	}
	
	public void setOpis(String opis) {
		Opis = opis;
	}
	
	public double getCena() {
		return Cena;
	}
	
	public void setCena(double cena) {
		Cena = cena;
	}

	@Override
	public String toString() {
		return Nazwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	
}
