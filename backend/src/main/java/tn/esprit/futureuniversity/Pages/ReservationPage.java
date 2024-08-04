package tn.esprit.futureuniversity.Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.futureuniversity.Entities.Reservation;

import java.util.List;

@Data
@AllArgsConstructor
public class ReservationPage {
    private List<Reservation> reservations;
    private long totalRecords;
    private long totalPages;
    private String nextPage;
}
