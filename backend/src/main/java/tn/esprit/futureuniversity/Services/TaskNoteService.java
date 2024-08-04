package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.Course;
import tn.esprit.futureuniversity.Entities.Note;
import tn.esprit.futureuniversity.Entities.Task;
import tn.esprit.futureuniversity.Entities.User;
import tn.esprit.futureuniversity.Repositories.CourseRepository;
import tn.esprit.futureuniversity.Repositories.NoteRepository;
import tn.esprit.futureuniversity.Repositories.TaskRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TaskNoteService implements ITaskNoteService {

    private final NoteRepository noteRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;


    public List<Note> getNotesByUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return noteRepository.findByUserId(user);
    }
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @Override
    public Note updateNoteById(long id, Note note) {
        Note existingNote = getNoteById(id);
        existingNote.setTitle(note.getTitle());
        existingNote.setDescription(note.getDescription());
        existingNote.setLabel(note.getLabel());
        existingNote.setTags(note.getTags());
        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteNoteById(long id) {
        noteRepository.deleteById(id);
    }




    @Override
    public List<Task> getTasksByUser(long userId) {
        System.out.println("id"+userId);
        User user = userRepository.findById(userId).orElseThrow();
        System.out.println("user"+user);
        return taskRepository.findByUserId(user);
    }

    @Override
    public List<Task> getTasksByCourse(long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return taskRepository.findByCourse(course);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Transactional
    @Override
    public Task updateTaskById(long id, Task updatedTask) {
        System.out.println("Attempting to update task with ID: " + id);
        Task task = getTaskById(id);
        System.out.println("Task found: " + task);
        if (task != null) {
            System.out.println("Task found: " + task);
            task.setTitle(updatedTask.getTitle());
            task.setPriority(updatedTask.getPriority());
            task.setDueDate(updatedTask.getDueDate());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            task.setUpdatedAt(updatedTask.getUpdatedAt());
            task.setTags(updatedTask.getTags());
            task.setCourse(updatedTask.getCourse()); // Update course relation


            System.out.println("Updated task: " + task);
            return taskRepository.save(task);
        } else {
            System.out.println("Task not found with ID: " + id);
            throw new RuntimeException("Task not found");
        }
    }


    @Override
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }


    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCoursesByUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return courseRepository.findByUserId(user);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course updateCourseById(long id, Course course) {
        Course existingCourse = getCourseById(id);
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }

}