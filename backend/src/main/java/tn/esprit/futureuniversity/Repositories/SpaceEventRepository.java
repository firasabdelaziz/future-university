package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.SpaceEvent;

import java.util.List;

@Repository
public interface SpaceEventRepository extends JpaRepository<SpaceEvent, Long> {

    @Query("SELECT COUNT(s) FROM SpaceEvent s")
    long countByFilter(String spaceEventId, String spaceId, String eventId);

    @Query("SELECT s FROM SpaceEvent s")
    List<SpaceEvent> findByFilter(String spaceEventId, String spaceId, String eventId, int page, int itemsPerPage, int isSortingAsc, String sortingProperty);
}
