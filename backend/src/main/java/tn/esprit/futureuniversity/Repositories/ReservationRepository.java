package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT COUNT(r) FROM Reservation r")
    long countByFilter(String reservationId, String studentId, String roomId);

    @Query("SELECT r FROM Reservation r")
    List<Reservation> findByFilter(String reservationId, String studentId, String roomId, int page, int itemsPerPage, int isSortingAsc, String sortingProperty);
}
