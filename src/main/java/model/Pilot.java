package model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pilot_seq")
	private int id;
	private String ime;
	private String prezime;
	private String broj_licence;
	public Pilot(int id, String ime, String prezime, String broj_licence) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.broj_licence = broj_licence;
	}
	public Pilot() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBroj_licence() {
		return broj_licence;
	}
	public void setBroj_licence(String broj_licence) {
		this.broj_licence = broj_licence;
	}
	@Override
	public int hashCode() {
		return Objects.hash(broj_licence, id, ime, prezime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilot other = (Pilot) obj;
		return Objects.equals(broj_licence, other.broj_licence) && id == other.id && Objects.equals(ime, other.ime)
				&& Objects.equals(prezime, other.prezime);
	}

	
	
}


