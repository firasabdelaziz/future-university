package tn.esprit.futureuniversity.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.TeamBuildingActivity;
import tn.esprit.futureuniversity.Repositories.TeamBuildingActivityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamBuildingActivityService {
    public final TeamBuildingActivityRepository teamBuildingActivityRepository;

    public List<TeamBuildingActivity> getAllTeamBuildingActivities() {
        return teamBuildingActivityRepository.findAll();
    }

    public TeamBuildingActivity getTeamBuildingActivityById(Long id) {
        return teamBuildingActivityRepository.findById(id).orElse(null);
    }

    public TeamBuildingActivity addTeamBuildingActivity(TeamBuildingActivity teamBuildingActivity) {
        if(teamBuildingActivity == null)
            return null;
        return teamBuildingActivityRepository.save(teamBuildingActivity);
    }

    public TeamBuildingActivity updateTeamBuildingActivity(TeamBuildingActivity teamBuildingActivity) {
        if(teamBuildingActivity == null)
            return null;
        return teamBuildingActivityRepository.save(teamBuildingActivity);
    }

    public void deleteTeamBuildingActivityById(Long id) {
        teamBuildingActivityRepository.deleteById(id);
    }

    public void deleteAllTeamBuildingActivities() {
        teamBuildingActivityRepository.deleteAll();
    }


    public long getTotalTeamBuildingActivities(String teamBuildingActivityId, String name, String description) {
        return teamBuildingActivityRepository.countByFilter(teamBuildingActivityId, name, description);
    }

    public List<TeamBuildingActivity> getTeamBuildingActivities(String teamBuildingActivityId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return teamBuildingActivityRepository.findByFilter(teamBuildingActivityId, name, description, page, itemsPerPage, isSortingAsc, sortingProperty);
    }
}
