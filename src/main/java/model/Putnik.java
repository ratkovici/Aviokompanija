package model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Putnik {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "putnik_seq")
	private int id;
	private String ime;
	private String prezime;
	private String broj_pasosa;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Let> letovi;
	public Putnik(int id, String ime, String prezime, String broj_pasosa) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.broj_pasosa = broj_pasosa;
	}
	public Putnik() {
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
	public String getBroj_pasosa() {
		return broj_pasosa;
	}
	public void setBroj_pasosa(String broj_pasosa) {
		this.broj_pasosa = broj_pasosa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(broj_pasosa, id, ime, prezime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Putnik other = (Putnik) obj;
		return Objects.equals(broj_pasosa, other.broj_pasosa) && id == other.id && Objects.equals(ime, other.ime)
				&& Objects.equals(prezime, other.prezime);
	}
	public Set<Let> getLetovi() {
		return letovi;
	}
	public void setLetovi(Set<Let> letovi) {
		this.letovi = letovi;
	}
	
}
