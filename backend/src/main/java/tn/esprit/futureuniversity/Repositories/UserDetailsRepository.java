package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.futureuniversity.Entities.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByUserId(Integer userId);

}
