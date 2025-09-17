package model;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Avion;
import Repository.AvionRepository;

@ApplicationScoped
public class AvionScheduler {

    @Inject
    AvionRepository avionRepository;

   
    @Scheduled(every = "2m")
    void fetchAllAvionsScheduler() {
        List<Avion> avionsList = avionRepository.getAllAvions();
        Set<Avion> avions = new HashSet<>(avionsList);

        Response response = Response.ok().entity(avions).build();

        System.out.println("Scheduler ran at: " + java.time.LocalDateTime.now());
        System.out.println("Avions: " + response.getEntity());
    }
}
