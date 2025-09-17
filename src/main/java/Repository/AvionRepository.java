package Repository;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Avion;
import model.Let;

@Dependent
public class AvionRepository {

    @Inject
    private EntityManager em;


    @Transactional
    public Avion createAvion(Avion avion) {
        return em.merge(avion);
    }
	
    @Transactional
    public Avion updateAvion(Avion avion) {
        return em.merge(avion);  
    }
    
    @Transactional
    public List<Avion> getAllAvions() {
        
        List<Avion> avioni = em.createNamedQuery(Avion.GET_ALL_AVIONS, Avion.class)
                .getResultList();

        
        for (Avion avion : avioni) {
            List<Let> letovi = em.createNamedQuery(Let.GET_LETOVI_FOR_AVIONS, Let.class)
                    .setParameter("id", avion.getId())
                    .getResultList();

            avion.setLetovi(new HashSet<>(letovi));
        }

        return avioni;
    }
    
    public Avion findById(int id) {
        return em.find(Avion.class, id);
    }

    public Avion save(Avion avion) {
        if (avion.getId() == 0) {
            em.persist(avion);
            return avion;
        } else {
            return em.merge(avion);
        }
    }

	
}
