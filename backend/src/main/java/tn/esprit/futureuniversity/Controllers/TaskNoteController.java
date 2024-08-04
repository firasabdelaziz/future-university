package tn.esprit.futureuniversity.Controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import tn.esprit.futureuniversity.Entities.Note;
import tn.esprit.futureuniversity.Entities.Section;
import tn.esprit.futureuniversity.Entities.Task;
import tn.esprit.futureuniversity.Security.ExportService;
import tn.esprit.futureuniversity.Services.ITaskNoteService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/Tasknote")
@AllArgsConstructor
public class TaskNoteController {

    private final ITaskNoteService taskNoteService;

    private ExportService exportService;


    // Export PDF endpoints

    @GetMapping("/notes/export/pdf/user/{userId}")
    public ResponseEntity<InputStreamResource> exportNotesPdf(@PathVariable long userId){
        System.out.println("userId"+userId);
        List<Note> notes = taskNoteService.getNotesByUser(userId);
        ByteArrayInputStream bais = exportService.notesPDFReport(notes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=notes.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }
    @GetMapping("/tasks/export/pdf/user/{userId}")
    public ResponseEntity<InputStreamResource> exportTasksPdf(@PathVariable long userId){
        List<Task> tasks = taskNoteService.getTasksByUser(userId);
        ByteArrayInputStream bais = exportService.tasksPDFReport(tasks);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=notes.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }


    // Note endpoints
    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
        return taskNoteService.createNote(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable long id) {
        return taskNoteService.getNoteById(id);
    }

    @PutMapping("/notes/{id}")
    public Note updateNoteById(@PathVariable long id, @RequestBody Note note) {
        return taskNoteService.updateNoteById(id, note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNoteById(@PathVariable long id) {
        taskNoteService.deleteNoteById(id);
    }

    @GetMapping("/notes/user/{userId}")
    public List<Note> getNotesByUser(@PathVariable long userId) {
        return taskNoteService.getNotesByUser(userId);
    }



    // Section endpoints
    @PostMapping("/sections")
    public Section createSection(@RequestBody Section section) {
        return taskNoteService.createSection(section);
    }

    @GetMapping("/sections/{id}")
    public Section getSectionById(@PathVariable long id) {
        return taskNoteService.getSectionById(id);
    }

    @PutMapping("/sections/{id}")
    public Section updateSectionById(@PathVariable long id, @RequestBody Section section) {
        return taskNoteService.updateSectionById(id, section);
    }

    @DeleteMapping("/sections/{id}")
    public void deleteSectionById(@PathVariable long id) {
        taskNoteService.deleteSectionById(id);
    }

    @GetMapping("/sections/user/{userId}")
    public List<Section> getSectionsByUser(@PathVariable long userId) {
        return taskNoteService.getSectionsByUser(userId);
    }


    // Task endpoints
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskNoteService.createTask(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable long id) {
        return taskNoteService.getTaskById(id);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable long id) {
        taskNoteService.deleteTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById(@PathVariable long id, @RequestBody Task task) {
        return taskNoteService.updateTaskById(id, task);
    }

    @GetMapping("/tasks/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable long userId) {
        return taskNoteService.getTasksByUser(userId);
    }


}