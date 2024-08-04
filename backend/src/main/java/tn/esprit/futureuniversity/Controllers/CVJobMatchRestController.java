package tn.esprit.futureuniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.futureuniversity.Entities.CVJobMatch;
import tn.esprit.futureuniversity.Services.CVJobMatchsServicesImp;
import tn.esprit.futureuniversity.Services.ICVJobMatchsServices;


import java.util.List;

@RestController
@RequestMapping("/api/cv-job-matches")
public class CVJobMatchRestController {

    @Autowired
    private ICVJobMatchsServices cvJobMatchService;

    @PostMapping
    public CVJobMatch createCVJobMatch(@RequestBody CVJobMatch cvJobMatch) {
        return cvJobMatchService.saveCVJobMatch(cvJobMatch);
    }

    @PutMapping("/{id}")
    public CVJobMatch updateCVJobMatch(@PathVariable Long id, @RequestBody CVJobMatch cvJobMatch) {
        cvJobMatch.setId(id);
        return cvJobMatchService.updateCVJobMatch(cvJobMatch);
    }

    @DeleteMapping("/{id}")
    public void deleteCVJobMatch(@PathVariable Long id) {
        cvJobMatchService.deleteCVJobMatch(id);
    }

    @GetMapping("/{id}")
    public CVJobMatch getCVJobMatchById(@PathVariable Long id) {
        return cvJobMatchService.getCVJobMatchById(id);
    }

    @GetMapping
    public List<CVJobMatch> getAllCVJobMatches() {
        return cvJobMatchService.getAllCVJobMatches();
    }
}
