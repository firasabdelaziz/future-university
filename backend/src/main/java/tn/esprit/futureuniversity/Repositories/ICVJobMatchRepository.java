package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.futureuniversity.Entities.CVJobMatch;

public interface ICVJobMatchRepository extends JpaRepository<CVJobMatch, Long> {
}
