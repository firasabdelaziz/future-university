package tn.esprit.futureuniversity.Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.futureuniversity.Entities.TeamBuildingActivity;

import java.util.List;

@Data
@AllArgsConstructor
public class TeamBuildingActivityPage {
    private List<TeamBuildingActivity> teamBuildingActivities;
    private long totalRecords;
    private long totalPages;
    private String nextPage;
}
