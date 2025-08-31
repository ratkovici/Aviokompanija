package model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Karta {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "karta_seq")
	private int id;
	private String sjediste;
	private double cijena;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "putnik_id")
	private Putnik putnik;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "let_id")
	private Let let;
	
	public Karta(int id, String sjediste, double cijena, Putnik putnik, Let let) {
		super();
		this.id = id;
		this.sjediste = sjediste;
		this.cijena = cijena;
		this.putnik = putnik;
		this.let = let;
	}
	public Karta() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSjediste() {
		return sjediste;
	}
	public void setSjediste(String sjediste) {
		this.sjediste = sjediste;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	public Putnik getPutnik() {
		return putnik;
	}
	public void setPutnik(Putnik putnik) {
		this.putnik = putnik;
	}
	public Let getLet() {
		return let;
	}
	public void setLet(Let let) {
		this.let = let;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cijena, id, let, putnik, sjediste);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Karta other = (Karta) obj;
		return Double.doubleToLongBits(cijena) == Double.doubleToLongBits(other.cijena) && id == other.id
				&& let == other.let && putnik == other.putnik && Objects.equals(sjediste, other.sjediste);
	}
	
	
	
}
