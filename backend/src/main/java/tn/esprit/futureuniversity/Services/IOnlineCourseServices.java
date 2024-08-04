package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.OnlineCourse;

import java.util.List;

public interface IOnlineCourseServices  {

    OnlineCourse saveOnlineCourse(OnlineCourse onlineCourse);
    OnlineCourse updateOnlineCourse(OnlineCourse onlineCourse);
    void deleteOnlineCourse(Long id);
    OnlineCourse getOnlineCourseById(Long id);
    List<OnlineCourse> getAllOnlineCourses();




}

