package tn.esprit.futureuniversity.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Repositories.CarpoolRepository;
import tn.esprit.futureuniversity.Entities.Carpool;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarpoolService {
    private final CarpoolRepository carpoolRepository;

    public List<Carpool> getCarpool(String carpoolId, String driverId, String passengerId, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return carpoolRepository.findByFilter(carpoolId, driverId, passengerId, page, itemsPerPage, isSortingAsc, sortingProperty);
    }
    public Carpool getCarpoolById(Long id) {
        return carpoolRepository.findById(id).orElse(null);
    }

    public Carpool addCarpool(Carpool carpool) {
        if(carpool == null)
            return null;
        return carpoolRepository.save(carpool);
    }

    public Carpool updateCarpool(Carpool carpool) {
        if(carpool == null)
            return null;
        return carpoolRepository.save(carpool);
    }

    public void deleteCarpoolById(Long id) {
        carpoolRepository.deleteById(id);
    }

    public void deleteAllCarpools() {
        carpoolRepository.deleteAll();
    }

    public long getTotalCarpool(String carpoolId, String driverId, String passengerId) {
        return carpoolRepository.countByFilter(carpoolId, driverId, passengerId);
    }
}
