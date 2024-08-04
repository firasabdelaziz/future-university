package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Carpool;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface CarpoolRepository extends JpaRepository<Carpool, Long> {

    //@Query("SELECT COUNT(c) FROM Carpool c WHERE " +
    //        "(:carpoolId = '' OR c.driver.id = :carpoolId) " +
    //        "AND (:driverId = '' OR c.driver.id = :driverId) " +
    //        "AND (:passengerId = '' OR c.driver.id = :passengerId)")
    @Query("SELECT COUNT(c) FROM Carpool c")
            long countByFilter(String carpoolId, String driverId, String passengerId);

    //@Query("SELECT c FROM Carpool c WHERE " +
    //        "(:carpoolId = '' OR c.driver.id = :carpoolId) " +
    //        "AND (:driverId = '' OR c.driver.id = :driverId) " +
    //        "AND (:passengerId = '' OR c.driver.id = :passengerId)")
    @Query("SELECT c FROM Carpool c")
            List<Carpool> findByFilter(String carpoolId, String driverId, String passengerId, int page, int itemsPerPage, int isSortingAsc, String sortingProperty);
   }
