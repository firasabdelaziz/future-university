package tn.esprit.futureuniversity.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.TeamBuildingActivity;

import java.util.List;

@Repository
public interface TeamBuildingActivityRepository extends JpaRepository<TeamBuildingActivity, Long> {
    @Query("SELECT COUNT(t) FROM TeamBuildingActivity t")
    long countByFilter(String teamBuildingActivityId, String name, String description);

    @Query("SELECT t FROM TeamBuildingActivity t")
    List<TeamBuildingActivity> findByFilter(String teamBuildingActivityId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty);
}
