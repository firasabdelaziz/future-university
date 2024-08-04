package tn.esprit.futureuniversity.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Event;
import tn.esprit.futureuniversity.Repositories.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    public final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event addEvent(Event event) {
        if(event == null)
            return null;
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        if(event == null)
            return null;
        return eventRepository.save(event);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    public long getTotalEvents() {
        return eventRepository.count();
    }

    public List<Event> getEventsByFilter(String eventId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return eventRepository.findByFilter(eventId, name, description, page, itemsPerPage, isSortingAsc, sortingProperty);
    }

    public long getTotalEventsByFilter(String eventId, String name, String description) {
        return eventRepository.countByFilter(eventId, name, description);
    }
}
