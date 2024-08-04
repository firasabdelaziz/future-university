package tn.esprit.futureuniversity.Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.futureuniversity.Entities.SpaceEvent;

import java.util.List;

@Data
@AllArgsConstructor
public class SpaceEventPage {
    private List<SpaceEvent> spaceEvents;
    private long totalRecords;
    private long totalPages;
    private String nextPage;
}
