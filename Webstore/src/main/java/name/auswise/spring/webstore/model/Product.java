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
	
	
}
