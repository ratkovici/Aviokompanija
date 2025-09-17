package Repository;

import model.Timezone;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;


@Path("/api/time/current")
@RegisterRestClient(baseUri = "https://timeapi.io")
public interface TimezoneClient {

    @GET
    @Path("/ip")
    Timezone getTimezoneByIp(@QueryParam("ipAddress") String ipAddress);
}
