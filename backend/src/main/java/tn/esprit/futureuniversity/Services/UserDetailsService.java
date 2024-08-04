package tn.esprit.futureuniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.UserDetails;
import tn.esprit.futureuniversity.Repositories.UserDetailsRepository;

import java.util.List;
import java.util.Optional;
@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public List<UserDetails> findAll() {
        return userDetailsRepository.findAll();
    }

    public Optional<UserDetails> findById(Integer id) {
        return userDetailsRepository.findById(id);
    }

    public UserDetails save(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    public void deleteById(Integer id) {
        userDetailsRepository.deleteById(id);
    }
}
