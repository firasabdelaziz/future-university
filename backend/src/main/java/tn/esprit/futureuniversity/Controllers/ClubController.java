package tn.esprit.futureuniversity.Controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.futureuniversity.Entities.Club;
import tn.esprit.futureuniversity.Pages.ClubPage;
import tn.esprit.futureuniversity.Services.ClubService;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    public final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<ClubPage> getClubs(@RequestParam(value = "clubId", defaultValue = "") String clubId,
                                            @RequestParam(value = "clubName", defaultValue = "") String clubName,
                                            @RequestParam(value = "clubDescription", defaultValue = "") String clubDescription,
                                            @RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "itemsPerPage", defaultValue = "50") int itemsPerPage,
                                            @RequestParam(value = "isSortingAsc", defaultValue = "1") int isSortingAsc,
                                            @RequestParam(value = "sortingProperty", defaultValue = "clubId") String sortingProperty) {

        try {
            long totalRecords = clubService.getTotalClubsByFilter(clubId, clubName, clubDescription);
            long totalPages = totalRecords / itemsPerPage;
            if (itemsPerPage > Integer.valueOf(200)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Maximum items per page is 2000");
            }
            if (page > totalPages) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Out of range");
            }
            List<Club> clubs = clubService.getClubsByFilter(clubId, clubName, clubDescription, page, itemsPerPage, isSortingAsc, sortingProperty);
            return ResponseEntity.ok(new ClubPage(clubs, totalRecords, totalPages, ""));
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@RequestParam Long id) {
        try {
            Club club = clubService.getClubById(id);
            return ResponseEntity.ok(club);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Club> addClub(@RequestBody Club club) {
        try {
            Club newClub = clubService.addClub(club);
            return ResponseEntity.ok(newClub);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Club> updateClub(@RequestBody Club club) {
        try {
            Club updatedClub = clubService.updateClub(club);
            return ResponseEntity.ok(updatedClub);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClubById(@RequestParam Long id) {
        try {
            clubService.deleteClubById(id);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllClubs() {
        try {
            clubService.deleteAllClubs();
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }
}
