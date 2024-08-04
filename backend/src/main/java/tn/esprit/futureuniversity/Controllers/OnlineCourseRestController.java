package tn.esprit.futureuniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.futureuniversity.Entities.OnlineCourse;
import tn.esprit.futureuniversity.Services.IOnlineCourseServices;


import java.util.List;

@RestController
@RequestMapping("/api/online-courses")
public class OnlineCourseRestController {

    @Autowired
    private IOnlineCourseServices onlineCourseService;

    @PostMapping
    public OnlineCourse createOnlineCourse(@RequestBody OnlineCourse onlineCourse) {
        return onlineCourseService.saveOnlineCourse(onlineCourse);
    }

    @PutMapping("/{id}")
    public OnlineCourse updateOnlineCourse(@PathVariable Long id, @RequestBody OnlineCourse onlineCourse) {
        onlineCourse.setId(id);
        return onlineCourseService.updateOnlineCourse(onlineCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteOnlineCourse(@PathVariable Long id) {
        onlineCourseService.deleteOnlineCourse(id);
    }

    @GetMapping("/{id}")
    public OnlineCourse getOnlineCourseById(@PathVariable Long id) {
        return onlineCourseService.getOnlineCourseById(id);
    }

    @GetMapping
    public List<OnlineCourse> getAllOnlineCourses() {
        return onlineCourseService.getAllOnlineCourses();
    }
}
