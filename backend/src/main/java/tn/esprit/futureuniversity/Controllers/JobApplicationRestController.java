package tn.esprit.futureuniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.futureuniversity.Entities.JobApplication;
import tn.esprit.futureuniversity.Services.IJobApplicationServices;


import java.util.List;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationRestController {

    @Autowired
    private IJobApplicationServices jobApplicationService;

    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return jobApplicationService.saveJobApplication(jobApplication);
    }

    @PutMapping("/{id}")
    public JobApplication updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
        jobApplication.setId(id);
        return jobApplicationService.updateJobApplication(jobApplication);
    }

    @DeleteMapping("/{id}")
    public void deleteJobApplication(@PathVariable Long id) {
        jobApplicationService.deleteJobApplication(id);
    }

    @GetMapping("/{id}")
    public JobApplication getJobApplicationById(@PathVariable Long id) {
        return jobApplicationService.getJobApplicationById(id);
    }

    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }
}
