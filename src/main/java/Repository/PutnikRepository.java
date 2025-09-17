package Repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Avion;
import model.Let;
import model.Putnik;

@Dependent
public class PutnikRepository {
	
	@Inject
	EntityManager em;
	
	@Transactional
	public Putnik createPutnik(Putnik putnik) {
		return em.merge(putnik);
	}
	
	
	@Transactional
	public List<Putnik> getAllPutnik() {
		
	List<Putnik> putnici = em.createNamedQuery(Putnik.GET_ALL_PUTNIK, Putnik.class).getResultList();
		
		for (Putnik putnik : putnici){
			List<Let> letovi = em.createNamedQuery(Let.GET_LETOVI_FOR_PUTNIK, Let.class).setParameter("id", putnik.getId()).getResultList();
			putnik.setLetovi(new HashSet<>(letovi));	
			
		}
		return putnici;
	}
	
	public List<Putnik> getLongestPname(){
		
		List<Putnik> putnici = em.createNamedQuery(Putnik.GET_LONGEST_PNAME, Putnik.class).getResultList();
		return putnici;
		
	}
	
	
}
