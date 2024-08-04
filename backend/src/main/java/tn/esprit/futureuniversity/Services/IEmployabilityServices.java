package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.Employability;

import java.util.List;

public interface IEmployabilityServices {
    Employability saveEmployability(Employability employability);
    Employability updateEmployability(Employability employability);
    void deleteEmployability(Long id);
    Employability getEmployabilityById(Long id);
    List<Employability> getAllEmployabilities();
}
