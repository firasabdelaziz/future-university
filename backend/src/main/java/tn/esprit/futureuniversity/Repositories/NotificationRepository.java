package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
