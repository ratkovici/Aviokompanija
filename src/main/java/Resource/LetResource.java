package Resource;



import Repository.LetRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Let;

@Path("/let/")
public class LetResource {

	@Inject
	LetRepository letRepository;
	
	@POST
	@Path("/addLet")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createLet(Let let) {
		Let l = letRepository.createLet(let);
		return Response.ok().entity(l).build();
		
	}
	
}
