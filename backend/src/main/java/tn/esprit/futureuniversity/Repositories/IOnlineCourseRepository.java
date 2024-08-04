package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.futureuniversity.Entities.OnlineCourse;

public interface IOnlineCourseRepository extends JpaRepository<OnlineCourse, Long> {

}
