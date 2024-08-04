package tn.esprit.futureuniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.futureuniversity.Entities.Employability;
import tn.esprit.futureuniversity.Services.IEmployabilityServices;


import java.util.List;

@RestController
@RequestMapping("/api/employability")
public class EmployabilityRestController {

    @Autowired
    private IEmployabilityServices employabilityService;

    @PostMapping
    public Employability createEmployability(@RequestBody Employability employability) {
        return employabilityService.saveEmployability(employability);
    }

    @PutMapping("/{id}")
    public Employability updateEmployability(@PathVariable Long id, @RequestBody Employability employability) {
        employability.setId(id);
        return employabilityService.updateEmployability(employability);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployability(@PathVariable Long id) {
        employabilityService.deleteEmployability(id);
    }

    @GetMapping("/{id}")
    public Employability getEmployabilityById(@PathVariable Long id) {
        return employabilityService.getEmployabilityById(id);
    }

    @GetMapping
    public List<Employability> getAllEmployability() {
        return employabilityService.getAllEmployabilities();
    }
}
