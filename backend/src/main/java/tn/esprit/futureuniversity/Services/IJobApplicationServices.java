package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.JobApplication;

import java.util.List;

public interface IJobApplicationServices  {

    JobApplication saveJobApplication(JobApplication jobApplication);
    JobApplication updateJobApplication(JobApplication jobApplication);
    void deleteJobApplication(Long id);
    JobApplication getJobApplicationById(Long id);
    List<JobApplication> getAllJobApplications();
}
