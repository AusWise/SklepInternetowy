package name.auswise.spring.webstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "uzytkownicy")
public class User {
	
	private long ID;
	
	private Role rola;
	
	private String Imie;
	private String Nazwisko;
	private Long pESEL;
	private Integer NIP;
	private Integer NumerTelefonu;
	private String Email;
	private String Ulica;
	private Integer NrBudynku;
	private Integer NrLokalu;
	private String Miasto;
	private String KodPocztowy;
	private String login;
	private String haslo;
	private String passwordConfirm;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	@ManyToOne
	@JoinColumn(name="RolaID", nullable=false)
	public Role getRola() {
		return rola;
	}
	
	@ManyToOne
	@JoinColumn(name="RolaID", nullable=false)
	public void setRola(Role rola) {
		this.rola = rola;
	}
	
	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		Imie = imie;
	}

	public String getNazwisko() {
		return Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}

	public Long getPESEL() {
		return pESEL;
	}

	public void setPESEL(Long pESEL) {
		this.pESEL = pESEL;
	}

	public Integer getNIP() {
		return NIP;
	}

	public void setNIP(Integer nIP) {
		NIP = nIP;
	}

	public Integer getNumerTelefonu() {
		return NumerTelefonu;
	}

	public void setNumerTelefonu(Integer numerTelefonu) {
		NumerTelefonu = numerTelefonu;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		Ulica = ulica;
	}

	public Integer getNrBudynku() {
		return NrBudynku;
	}

	public void setNrBudynku(Integer nrBudynku) {
		NrBudynku = nrBudynku;
	}

	public Integer getNrLokalu() {
		return NrLokalu;
	}

	public void setNrLokalu(Integer nrLokalu) {
		NrLokalu = nrLokalu;
	}

	public String getMiasto() {
		return Miasto;
	}

	public void setMiasto(String miasto) {
		Miasto = miasto;
	}

	public String getKodPocztowy() {
		return KodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		KodPocztowy = kodPocztowy;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getHaslo() {
		return haslo;
	}
	
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
	@Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
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
		User other = (User) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
    
    

}
