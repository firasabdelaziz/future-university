package tn.esprit.futureuniversity.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Club;
import tn.esprit.futureuniversity.Entities.Reservation;
import tn.esprit.futureuniversity.Repositories.ClubRepository;
import tn.esprit.futureuniversity.Repositories.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    public final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation addReservation(Reservation reservation) {
        if(reservation == null)
            return null;
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        if(reservation == null)
            return null;
        return reservationRepository.save(reservation);
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    public void deleteAllReservations() {
        reservationRepository.deleteAll();
    }

    public long getTotalReservations( String reservationId, String name, String description) {
        return reservationRepository.count();
    }

    public List<Reservation> getReservations(String reservationId, String studentId, String roomId, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return reservationRepository.findByFilter(reservationId, studentId, roomId, page, itemsPerPage, isSortingAsc, sortingProperty);
    }


}
