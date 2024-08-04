package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.CVJobMatch;

import java.util.List;

public interface ICVJobMatchsServices {

    CVJobMatch saveCVJobMatch(CVJobMatch cvJobMatch);
    CVJobMatch updateCVJobMatch(CVJobMatch cvJobMatch);
    void deleteCVJobMatch(Long id);
    CVJobMatch getCVJobMatchById(Long id);
    List<CVJobMatch> getAllCVJobMatches();
}
