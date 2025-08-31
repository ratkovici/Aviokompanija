package model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@NamedQuery(
        name = Let.GET_LETOVI_FOR_AVIONS,
        query = "SELECT l FROM Let l WHERE l.avion.id = :id"
)

@Entity
public class Let {
	
    public static final String GET_LETOVI_FOR_AVIONS = "Let.getLetoviForAvions";

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "let_seq")
	private int id;
	private String broj_leta;
	private String polaznig;
	private String dolaznig;
	private String vrijeme_dolaska;
	private String vrijeme_polaska;
	@ManyToOne
	@JoinColumn(name = "avion_id")
	private Avion avion;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pilot pilot;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Putnik> putnici;
	public Let(int id, String broj_leta, String polaznig, String dolaznig, String vrijeme_dolaska,
			String vrijeme_polaska, Avion avion, Pilot pilot) {
		super();
		this.id = id;
		this.broj_leta = broj_leta;
		this.polaznig = polaznig;
		this.dolaznig = dolaznig;
		this.vrijeme_dolaska = vrijeme_dolaska;
		this.vrijeme_polaska = vrijeme_polaska;
		this.avion = avion;
		this.pilot = pilot;
	}
	public Let() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBroj_leta() {
		return broj_leta;
	}
	public void setBroj_leta(String broj_leta) {
		this.broj_leta = broj_leta;
	}
	public String getPolaznig() {
		return polaznig;
	}
	public void setPolaznig(String polaznig) {
		this.polaznig = polaznig;
	}
	public String getDolaznig() {
		return dolaznig;
	}
	public void setDolaznig(String dolaznig) {
		this.dolaznig = dolaznig;
	}
	public String getVrijeme_dolaska() {
		return vrijeme_dolaska;
	}
	public void setVrijeme_dolaska(String vrijeme_dolaska) {
		this.vrijeme_dolaska = vrijeme_dolaska;
	}
	public String getVrijeme_polaska() {
		return vrijeme_polaska;
	}
	public void setVrijeme_polaska(String vrijeme_polaska) {
		this.vrijeme_polaska = vrijeme_polaska;
	}
	
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	public Set<Putnik> getPutnici() {
		return putnici;
	}
	public void setPutnici(Set<Putnik> putnici) {
		this.putnici = putnici;
	}
	@Override
	public int hashCode() {
		return Objects.hash(avion, broj_leta, dolaznig, id, pilot, polaznig, putnici, vrijeme_dolaska, vrijeme_polaska);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Let other = (Let) obj;
		return Objects.equals(avion, other.avion) && Objects.equals(broj_leta, other.broj_leta)
				&& Objects.equals(dolaznig, other.dolaznig) && id == other.id && Objects.equals(pilot, other.pilot)
				&& Objects.equals(polaznig, other.polaznig) && Objects.equals(putnici, other.putnici)
				&& Objects.equals(vrijeme_dolaska, other.vrijeme_dolaska)
				&& Objects.equals(vrijeme_polaska, other.vrijeme_polaska);
	}
	
	
}
