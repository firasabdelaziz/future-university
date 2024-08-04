package tn.esprit.futureuniversity.Controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.futureuniversity.Entities.SpaceEvent;
import tn.esprit.futureuniversity.Pages.SpaceEventPage;
import tn.esprit.futureuniversity.Services.SpaceEventService;

import java.util.List;

@RestController
@RequestMapping("/space-event")
public class SpaceEventController {
    public final SpaceEventService spaceEventService;

    public SpaceEventController(SpaceEventService spaceEventService) {
        this.spaceEventService = spaceEventService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<SpaceEventPage> getSpaceEvents(
            @RequestParam(value = "spaceEventId", defaultValue = "") String spaceEventId,
            @RequestParam(value = "spaceId", defaultValue = "") String spaceId,
            @RequestParam(value = "eventId", defaultValue = "") String eventId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "itemsPerPage", defaultValue = "50") int itemsPerPage,
            @RequestParam(value = "isSortingAsc", defaultValue = "1") int isSortingAsc,
            @RequestParam(value = "sortingProperty", defaultValue = "spaceEventId") String sortingProperty) {

        try {
            long totalRecords = spaceEventService.getTotalSpaceEvents(spaceEventId, spaceId, eventId);
            long totalPages = totalRecords / itemsPerPage;
            if (itemsPerPage > Integer.valueOf(200)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Maximum items per page is 2000");
            }
            if (page > totalPages) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Out of range");
            }
            List<SpaceEvent> spaceEvents = spaceEventService.getSpaceEvents(spaceEventId, spaceId, eventId, page, itemsPerPage, isSortingAsc, sortingProperty);
            return ResponseEntity.ok(new SpaceEventPage(spaceEvents, totalRecords, totalPages, ""));
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

}
