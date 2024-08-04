package tn.esprit.futureuniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.futureuniversity.Entities.Carpool;
import tn.esprit.futureuniversity.Pages.CarpoolPage;
import tn.esprit.futureuniversity.Services.CarpoolService;

import java.util.List;

@RestController
@RequestMapping("/carpool")
public class CarpoolController {
    @Autowired
    public final CarpoolService carpoolService;

    public CarpoolController(CarpoolService carpoolService) {
        this.carpoolService = carpoolService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<CarpoolPage> getCarpool(@RequestParam(value = "carpoolId", defaultValue = "") String carpoolId,
                                                  @RequestParam(value = "driverId", defaultValue = "") String driverId,
                                                  @RequestParam(value = "passengerId", defaultValue = "") String passengerId,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "itemsPerPage", defaultValue = "50") int itemsPerPage,
                                                  @RequestParam(value = "isSortingAsc", defaultValue = "1") int isSortingAsc,
                                                  @RequestParam(value = "sortingProperty", defaultValue = "carpoolId") String sortingProperty) {

        try {
            long totalRecords = carpoolService.getTotalCarpool(carpoolId, driverId, passengerId);
            long totalPages = totalRecords / itemsPerPage;
            if (itemsPerPage > Integer.valueOf(200)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Maximum items per page is 2000");
            }
            if (page > totalPages) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Out of range");
            }

            List<Carpool> carpools = carpoolService.getCarpool(carpoolId, driverId, passengerId, page, itemsPerPage, isSortingAsc, sortingProperty);
            return ResponseEntity.ok(new CarpoolPage(carpools, totalRecords, totalPages, ""));
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carpool> getCarpoolById(@RequestParam Long id) {
        try {
            Carpool carpool = carpoolService.getCarpoolById(id);
            return ResponseEntity.ok(carpool);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Carpool> addCarpool(@RequestBody Carpool carpool) {
        try {
            Carpool newCarpool = carpoolService.addCarpool(carpool);
            return ResponseEntity.ok(newCarpool);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Carpool> updateCarpool(@RequestBody Carpool carpool) {
        try {
            Carpool updatedCarpool = carpoolService.updateCarpool(carpool);
            return ResponseEntity.ok(updatedCarpool);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarpoolById(@RequestParam Long id) {
        try {
            carpoolService.deleteCarpoolById(id);
            return ResponseEntity.ok("Carpool deleted successfully");
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/all")
    public ResponseEntity<String> deleteAllCarpools() {
        try {
            carpoolService.deleteAllCarpools();
            return ResponseEntity.ok("All carpools deleted successfully");
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }


}
