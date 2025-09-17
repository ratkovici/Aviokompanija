package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
@NamedQuery(
        name = Avion.GET_ALL_AVIONS, query = "SELECT a FROM Avion a"
)

 
public class Avion {
	
	public static final String GET_ALL_AVIONS = "Avion.getAllAvions";
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avion_seq")
    private int id;
    private int kapacitet;
    private String model_aviona;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "avion")
    @JsonIgnore
    private Set<Let> letovi = new HashSet<>();
    @Transient
	private byte [] fileContent;
    private String filePath;
    
	public Avion(int id, int kapacitet, String model_aviona) {
		super();
		this.id = id;
		this.kapacitet = kapacitet;
		this.model_aviona = model_aviona;
		this.letovi = letovi;
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
	
	public Set<Let> getLetovi() {
		return letovi;
	}
	public void setLetovi(Set<Let> letovi) {
		this.letovi = letovi;
	}
	public static String getGetAllAvions() {
		return GET_ALL_AVIONS;
	}
	
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(id, kapacitet, model_aviona);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Avion other = (Avion) obj;
	    return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Avion [id=" + id + ", kapacitet=" + kapacitet + ", model_aviona=" + model_aviona + "]";
	}
    
    
    
    
    
    
    
    
    
    
}

