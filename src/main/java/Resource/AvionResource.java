package Resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



import Repository.AvionRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import model.Avion;

@Path("/avion/")
public class AvionResource {

	  @Inject
	    private AvionRepository avionRepository;
	  
	  	@POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/addAvion")
	    public Response createAvion(Avion avion) {
	        Avion a = avionRepository.createAvion(avion);
	        return Response.ok().entity(a).build();
	    }
	
	  	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/getAllAvions")
	    public Response getAllAvions() {
	        
	  		 List<Avion> avionsList = avionRepository.getAllAvions();
	  	    Set<Avion> avions = new HashSet<>(avionsList); 
	        return Response.ok().entity(avions).build();
	    }
	  	
}
