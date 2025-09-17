package Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import Repository.AvionRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import model.Avion;

@Path("/avion/")
public class AvionResource {
	
	
	private final String uploadDirectory = "uploads/";


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
	  	
	  	
	  	
	    @GET
	    @Path("/getAvionWithId")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getAvionWithId(@QueryParam("id") int avionId) {
	        Avion avion = avionRepository.findById(avionId);
	        if (avion == null) {
	            return Response.status(Response.Status.NOT_FOUND)
	                           .entity("Avion sa ID " + avionId + " nije pronadjen")
	                           .build();
	        }

	        return Response.ok(avion).build();
	    }
	    
}
