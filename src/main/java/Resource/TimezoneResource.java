package Resource;

import model.Timezone;
import Repository.TimezoneClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;



@Path("/timezone")
public class TimezoneResource {

    @Inject
    @RestClient
    TimezoneClient timezoneClient;

    @GET
    @Path("/by-ip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimezone(@QueryParam("ip") String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Query parameter 'ip' is required")
                           .build();
        }

        Timezone timezone = timezoneClient.getTimezoneByIp(ipAddress);
        return Response.ok().entity(timezone).build();
    }
}
