package name.auswise.spring.webstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producenci")
public class Producer {

	private int ID;
	private String Nazwa;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getNazwa() {
		return Nazwa;
	}
	
	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}
	
	@Override
	public String toString(){
		return Nazwa;
	}
}
