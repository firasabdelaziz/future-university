package tn.esprit.futureuniversity.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Club;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query("SELECT COUNT(c) FROM Club c")
    long countByFilter(String clubId, String name, String description);

    @Query("SELECT c FROM Club c")
    List<Club> findByFilter(String clubId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty);
}
