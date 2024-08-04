package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Course;
import tn.esprit.futureuniversity.Entities.Note;
import tn.esprit.futureuniversity.Entities.User;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{

    List<Course> findByUserId(User user);

}
