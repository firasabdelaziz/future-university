package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.futureuniversity.Entities.JobApplication;

import java.util.List;

public interface IJobApplicationRepository extends JpaRepository<JobApplication, Long> {



}