package tn.esprit.futureuniversity.Controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.futureuniversity.Entities.Event;
import tn.esprit.futureuniversity.Pages.EventPage;
import tn.esprit.futureuniversity.Services.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    public final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<EventPage> getEvents(@RequestParam(value = "eventId", defaultValue = "") String eventId,
                                              @RequestParam(value = "name", defaultValue = "") String name,
                                              @RequestParam(value = "description", defaultValue = "") String description,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "itemsPerPage", defaultValue = "50") int itemsPerPage,
                                              @RequestParam(value = "isSortingAsc", defaultValue = "1") int isSortingAsc,
                                              @RequestParam(value = "sortingProperty", defaultValue = "eventId") String sortingProperty) {

        try {
            long totalRecords = eventService.getTotalEventsByFilter(eventId, name, description);
            long totalPages = totalRecords / itemsPerPage;
            if (itemsPerPage > Integer.valueOf(200)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Maximum items per page is 2000");
            }
            if (page > totalPages) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Out of range");
            }
            List<Event> events = eventService.getEventsByFilter(eventId, name, description, page, itemsPerPage, isSortingAsc, sortingProperty);
            return ResponseEntity.ok(new EventPage(events, totalRecords, totalPages, "localhost:8080/api/event"+ "?eventId=" + eventId ));
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@RequestParam Long id) {
        try {
            Event event = eventService.getEventById(id);
            return ResponseEntity.ok(event);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        try {
            System.out.println("----------------------------");
            System.out.println(event);
            System.out.println("----------------------------");
            //Event newEvent = eventService.addEvent(event);
            return ResponseEntity.ok(event);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        try {
            Event updatedEvent = eventService.updateEvent(event);
            return ResponseEntity.ok(updatedEvent);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@RequestParam Long id) {
        try {
            eventService.deleteEventById(id);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllEvents() {
        try {
            eventService.deleteAllEvents();
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }
}
