package tn.esprit.futureuniversity.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Club;
import tn.esprit.futureuniversity.Repositories.ClubRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {
    public final ClubRepository clubRepository;

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Club getClubById(Long id) {
        return clubRepository.findById(id).orElse(null);
    }

    public Club addClub(Club club) {
        if(club == null)
            return null;
        return clubRepository.save(club);
    }

    public Club updateClub(Club club) {
        if(club == null)
            return null;
        return clubRepository.save(club);
    }

    public void deleteClubById(Long id) {
        clubRepository.deleteById(id);
    }

    public void deleteAllClubs() {
        clubRepository.deleteAll();
    }

    public long getTotalClubs() {
        return clubRepository.count();
    }

    public List<Club> getClubsByFilter(String clubId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return clubRepository.findByFilter(clubId, name, description, page, itemsPerPage, isSortingAsc, sortingProperty);
    }

    public long getTotalClubsByFilter(String clubId, String name, String description) {
        return clubRepository.countByFilter(clubId, name, description);
    }

    public List<Club> getClubsByFilter(String clubId, String name, String description) {
        return clubRepository.findByFilter(clubId, name, description, 0, 500, 1, "clubId");
    }

    public List<Club> getClubsByFilter(String clubId, String name, String description, int page, int itemsPerPage) {
        return clubRepository.findByFilter(clubId, name, description, page, itemsPerPage, 1, "clubId");
    }

    public List<Club> getTotalClub(String clubId, String name, String description, int page, int itemsPerPage, int isSortingAsc, String sortingProperty) {
        return clubRepository.findByFilter(clubId, name, description, page, itemsPerPage, isSortingAsc, sortingProperty);
    }
}
