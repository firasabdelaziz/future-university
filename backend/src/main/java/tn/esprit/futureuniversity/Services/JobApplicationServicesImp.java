package tn.esprit.futureuniversity.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.JobApplication;
import tn.esprit.futureuniversity.Repositories.IJobApplicationRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JobApplicationServicesImp implements  IJobApplicationServices {

    @Autowired
    private IJobApplicationRepository jobApplicationRepository;

    @Override
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public JobApplication updateJobApplication(JobApplication jobApplication) {
        Optional<JobApplication> existingJobApplication = jobApplicationRepository.findById(jobApplication.getId());
        if (existingJobApplication.isPresent()) {
            return jobApplicationRepository.save(jobApplication);
        } else {
            throw new RuntimeException("JobApplication not found");
        }
    }

    @Override
    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id).orElseThrow(() -> new RuntimeException("JobApplication not found"));
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }
}
