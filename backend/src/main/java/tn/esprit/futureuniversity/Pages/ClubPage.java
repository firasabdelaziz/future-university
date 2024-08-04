package tn.esprit.futureuniversity.Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.futureuniversity.Entities.Club;

import java.util.List;

@AllArgsConstructor
@Data
public class ClubPage {
    private List<Club> clubs;
    private long totalRecords;
    private long totalPages;
    private String nextPage;
}
