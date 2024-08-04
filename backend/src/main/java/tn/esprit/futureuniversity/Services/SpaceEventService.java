package tn.esprit.futureuniversity.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Repositories.SpaceEventRepository;
import tn.esprit.futureuniversity.Entities.SpaceEvent;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceEventService {
    public final SpaceEventRepository spaceEventRepository;

    public List<SpaceEvent> getAllSpaceEvents() {
        return spaceEventRepository.findAll();
    }

    public SpaceEvent getSpaceEventById(Long id) {
        return spaceEventRepository.findById(id).orElse(null);
    }

    public SpaceEvent addSpaceEvent(SpaceEvent spaceEvent) {
        if(spaceEvent == null)
            return null;
        return spaceEventRepository.save(spaceEvent);
    }

    public SpaceEvent updateSpaceEvent(SpaceEvent spaceEvent) {
        if(spaceEvent == null)
            return null;
        return spaceEventRepository.save(spaceEvent);
    }

    public void deleteSpaceEventById(Long id) {
        spaceEventRepository.deleteById(id);
    }

    public void deleteAllSpaceEvents() {
        spaceEventRepository.deleteAll();
    }

    //getTotalSpaceEvents(spaceEventId, spaceId, eventId);
    public long getTotalSpaceEvents(String spaceEventId, String spaceId, String eventId) {
        return spaceEventRepository.countByFilter(spaceEventId, spaceId, eventId);
    }

    //getSpaceEvents(spaceEventId, spaceId, eventId, page, itemsPerPage, isSortingAsc, sortingProperty)
    public List<SpaceEvent> getSpaceEvents(String spaceEventId, String spaceId, String eventId, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return spaceEventRepository.findByFilter(spaceEventId, spaceId, eventId, page, itemsPerPage, isSortingAsc, sortingProperty);
    }
}
