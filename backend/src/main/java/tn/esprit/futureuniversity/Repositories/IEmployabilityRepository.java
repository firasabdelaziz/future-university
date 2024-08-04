package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.futureuniversity.Entities.Employability;

public interface IEmployabilityRepository extends JpaRepository<Employability, Long> {
}

