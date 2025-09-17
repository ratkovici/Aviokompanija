package Repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import model.Let;

@Dependent
public class LetRepository {

	@Inject
	private EntityManager em;

	@Transactional
	public Let createLet(Let let) {
		return em.merge(let);
	}

}
