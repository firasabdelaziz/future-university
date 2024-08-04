package tn.esprit.futureuniversity.Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.futureuniversity.Entities.Event;

import java.util.List;

@Data
@AllArgsConstructor
public class EventPage {
    private List<Event> events;
    private long totalRecords;
    private long totalPages;
    private String nextPage;
}
