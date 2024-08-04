package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Course;
import tn.esprit.futureuniversity.Entities.Task;
import tn.esprit.futureuniversity.Entities.User;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(User user);

    List<Task> findByCourse(Course course);

}
