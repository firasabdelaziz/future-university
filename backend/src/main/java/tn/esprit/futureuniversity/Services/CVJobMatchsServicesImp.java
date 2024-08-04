package tn.esprit.futureuniversity.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.CVJobMatch;
import tn.esprit.futureuniversity.Repositories.ICVJobMatchRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class CVJobMatchsServicesImp  implements ICVJobMatchsServices {


    @Autowired
    private ICVJobMatchRepository cvJobMatchRepository;



    @Override
    public CVJobMatch saveCVJobMatch(CVJobMatch cvJobMatch) {
        return cvJobMatchRepository.save(cvJobMatch);
    }

    @Override
    public CVJobMatch updateCVJobMatch(CVJobMatch cvJobMatch) {
        Optional<CVJobMatch> existingCVJobMatch = cvJobMatchRepository.findById(cvJobMatch.getId());
        if (existingCVJobMatch.isPresent()) {
            return cvJobMatchRepository.save(cvJobMatch);
        } else {
            throw new RuntimeException("CVJobMatch not found");
        }
    }

    @Override
    public void deleteCVJobMatch(Long id) {
        cvJobMatchRepository.deleteById(id);
    }

    @Override
    public CVJobMatch getCVJobMatchById(Long id) {
        return cvJobMatchRepository.findById(id).orElseThrow(() -> new RuntimeException("CVJobMatch not found"));
    }

    @Override
    public List<CVJobMatch> getAllCVJobMatches() {
        return cvJobMatchRepository.findAll();
    }
}
