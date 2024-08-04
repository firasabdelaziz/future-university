package tn.esprit.futureuniversity.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.futureuniversity.Entities.OnlineCourse;
import tn.esprit.futureuniversity.Repositories.IOnlineCourseRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class OnlineCourseServicesImp implements IOnlineCourseServices {


    @Autowired
    private IOnlineCourseRepository onlineCourseRepository;

    @Override
    public OnlineCourse saveOnlineCourse(OnlineCourse onlineCourse) {
        return onlineCourseRepository.save(onlineCourse);
    }

    @Override
    public OnlineCourse updateOnlineCourse(OnlineCourse onlineCourse) {
        Optional<OnlineCourse> existingOnlineCourse = onlineCourseRepository.findById(onlineCourse.getId());
        if (existingOnlineCourse.isPresent()) {
            return onlineCourseRepository.save(onlineCourse);
        } else {
            throw new RuntimeException("OnlineCourse not found");
        }
    }

    @Override
    public void deleteOnlineCourse(Long id) {
        onlineCourseRepository.deleteById(id);
    }

    @Override
    public OnlineCourse getOnlineCourseById(Long id) {
        return onlineCourseRepository.findById(id).orElseThrow(() -> new RuntimeException("OnlineCourse not found"));
    }

    @Override
    public List<OnlineCourse> getAllOnlineCourses() {
        return onlineCourseRepository.findAll();
    }
}
