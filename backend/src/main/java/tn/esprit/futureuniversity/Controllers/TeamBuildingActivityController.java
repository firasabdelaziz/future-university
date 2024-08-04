package tn.esprit.futureuniversity.Controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.futureuniversity.Entities.TeamBuildingActivity;
import tn.esprit.futureuniversity.Pages.TeamBuildingActivityPage;
import tn.esprit.futureuniversity.Services.TeamBuildingActivityService;

import java.util.List;

@RestController
@RequestMapping("/team-building-activity")
public class TeamBuildingActivityController {
    public final TeamBuildingActivityService teamBuildingActivityService;

    public TeamBuildingActivityController(TeamBuildingActivityService teamBuildingActivityService) {
        this.teamBuildingActivityService = teamBuildingActivityService;
    }

    @GetMapping(value = {""})
    public ResponseEntity<TeamBuildingActivityPage> getTeamBuildingActivities(
            @RequestParam(value = "teamBuildingActivityId", defaultValue = "") String teamBuildingActivityId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "description", defaultValue = "") String description,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "itemsPerPage", defaultValue = "50") int itemsPerPage,
            @RequestParam(value = "isSortingAsc", defaultValue = "1") int isSortingAsc,
            @RequestParam(value = "sortingProperty", defaultValue = "teamBuildingActivityId") String sortingProperty) {

        try {
            long totalRecords = teamBuildingActivityService.getTotalTeamBuildingActivities(teamBuildingActivityId, name, description);
            long totalPages = totalRecords / itemsPerPage;
            if (itemsPerPage > Integer.valueOf(200)) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Maximum items per page is 2000");
            }
            if (page > totalPages) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Out of range");
            }
            List<TeamBuildingActivity> teamBuildingActivities = teamBuildingActivityService.getTeamBuildingActivities(teamBuildingActivityId, name, description, page, itemsPerPage, isSortingAsc, sortingProperty);
            return ResponseEntity.ok(new TeamBuildingActivityPage(teamBuildingActivities, totalRecords, totalPages, ""));
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamBuildingActivity> getTeamBuildingActivityById(@RequestParam Long id) {
        try {
            TeamBuildingActivity teamBuildingActivity = teamBuildingActivityService.getTeamBuildingActivityById(id);
            return ResponseEntity.ok(teamBuildingActivity);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TeamBuildingActivity> addTeamBuildingActivity(@RequestBody TeamBuildingActivity teamBuildingActivity) {
        try {
            TeamBuildingActivity newTeamBuildingActivity = teamBuildingActivityService.addTeamBuildingActivity(teamBuildingActivity);
            return ResponseEntity.ok(newTeamBuildingActivity);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<TeamBuildingActivity> updateTeamBuildingActivity(@RequestBody TeamBuildingActivity teamBuildingActivity) {
        try {
            TeamBuildingActivity updatedTeamBuildingActivity = teamBuildingActivityService.updateTeamBuildingActivity(teamBuildingActivity);
            return ResponseEntity.ok(updatedTeamBuildingActivity);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTeamBuildingActivityById(@RequestParam Long id) {
        try {
            teamBuildingActivityService.deleteTeamBuildingActivityById(id);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllTeamBuildingActivities() {
        try {
            teamBuildingActivityService.deleteAllTeamBuildingActivities();
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }
}