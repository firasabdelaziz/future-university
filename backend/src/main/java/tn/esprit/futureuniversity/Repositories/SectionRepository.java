package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Section;
import tn.esprit.futureuniversity.Entities.User;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {
    List<Section> findByUserId(User user);
}
