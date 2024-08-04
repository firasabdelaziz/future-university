package tn.esprit.futureuniversity.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Employability;
import tn.esprit.futureuniversity.Repositories.IEmployabilityRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor

@Service
public class EmployabilityServicesImp implements IEmployabilityServices {


    @Autowired
    private IEmployabilityRepository employabilityRepository;

    @Override
    public Employability saveEmployability(Employability employability) {
        return employabilityRepository.save(employability);
    }

    @Override
    public Employability updateEmployability(Employability employability) {
        Optional<Employability> existingEmployability = employabilityRepository.findById(employability.getId());
        if (existingEmployability.isPresent()) {
            return employabilityRepository.save(employability);
        } else {
            throw new RuntimeException("Employability not found");
        }
    }

    @Override
    public void deleteEmployability(Long id) {
        employabilityRepository.deleteById(id);
    }

    @Override
    public Employability getEmployabilityById(Long id) {
        return employabilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Employability not found"));
    }

    @Override
    public List<Employability> getAllEmployabilities() {
        return employabilityRepository.findAll();
    }
}
