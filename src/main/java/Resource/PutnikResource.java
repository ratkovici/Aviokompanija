package Resource;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Repository.PutnikRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Putnik;


@Path("/putnik/")
public class PutnikResource {
		
	@Inject
	PutnikRepository putnikRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addPutnik")
	public Response createPutnik(Putnik putnik) {
		
		Putnik p =	putnikRepository.createPutnik(putnik);
		return Response.ok().entity(p).build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllPutnik")
	public Response getAllPutnik() {
		List<Putnik> putnikList = putnikRepository.getAllPutnik();
		Set <Putnik> putnici = new HashSet<>(putnikList);
		return Response.ok().entity(putnici).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getLongestPname")
	public Response getLongestPname() {
		List<Putnik> putnikList = putnikRepository.getLongestPname();
		return Response.ok().entity(putnikList).build();
	}
}
