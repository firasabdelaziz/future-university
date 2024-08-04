package tn.esprit.futureuniversity.Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.futureuniversity.Entities.Carpool;

import java.util.List;

@AllArgsConstructor
@Data
public class CarpoolPage {
    private List<Carpool> carpools;
    private long totalRecords;
    private long totalPages;
    private String nextPage;
}
