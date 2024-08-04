package tn.esprit.futureuniversity.Controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.futureuniversity.Entities.Reservation;
import tn.esprit.futureuniversity.Pages.ReservationPage;
import tn.esprit.futureuniversity.Services.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    public final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<ReservationPage> getReservations(
            @RequestParam(value = "reservationId", defaultValue = "") String reservationId,
            @RequestParam(value = "studentId", defaultValue = "") String studentId,
            @RequestParam(value = "roomId", defaultValue = "") String roomId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "itemsPerPage", defaultValue = "50") int itemsPerPage,
            @RequestParam(value = "isSortingAsc", defaultValue = "1") int isSortingAsc,
            @RequestParam(value = "sortingProperty", defaultValue = "reservationId") String sortingProperty) {

        try {
            long totalRecords = reservationService.getTotalReservations(reservationId, studentId, roomId);
            long totalPages = totalRecords / itemsPerPage;
            if (itemsPerPage > Integer.valueOf(200)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Maximum items per page is 2000");
            }
            if (page > totalPages) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Out of range");
            }
            List<Reservation> reservations = reservationService.getReservations(reservationId, studentId, roomId, page, itemsPerPage, isSortingAsc, sortingProperty);
            return ResponseEntity.ok(new ReservationPage(reservations, totalRecords, totalPages, ""));
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }
}
