package tn.esprit.futureuniversity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.futureuniversity.Entities.Note;
import tn.esprit.futureuniversity.Entities.User;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByUserId(User user);
}
