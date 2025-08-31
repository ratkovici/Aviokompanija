package model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avion_seq")
    private int id;
    private int kapacitet;
    private String model_aviona;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Let> let;
	
	public Avion(int id, int kapacitet, String model_aviona, Set<Let> let) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.model_aviona = model_aviona;
		this.let = let;
	}
	public Avion() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public String getModel_aviona() {
		return model_aviona;
	}
	public void setModel_aviona(String model_aviona) {
		this.model_aviona = model_aviona;
	}
	
	public Set<Let> getLet() {
		return let;
	}
	public void setLet(Set<Let> let) {
		this.let = let;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, kapacitet, model_aviona);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return Objects.equals(id, other.id) && kapacitet == other.kapacitet
				&& Objects.equals(model_aviona, other.model_aviona);
	}
	@Override
	public String toString() {
		return "Avion [id=" + id + ", kapacitet=" + kapacitet + ", model_aviona=" + model_aviona + "]";
	}
    
    
    
    
    
    
    
    
    
    
}

