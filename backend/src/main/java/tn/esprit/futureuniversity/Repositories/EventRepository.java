package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Event;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT COUNT(e) FROM Event e")
    long countByFilter(String eventId, String name, String description);

    @Query("SELECT e FROM Event e")
    List<Event> findByFilter(String eventId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty);
}
