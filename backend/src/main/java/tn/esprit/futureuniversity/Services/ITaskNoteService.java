package tn.esprit.futureuniversity.Services;

import tn.esprit.futureuniversity.Entities.Note;
import tn.esprit.futureuniversity.Entities.Section;
import tn.esprit.futureuniversity.Entities.Task;

import java.util.List;

public interface ITaskNoteService {

    List<Note> getNotesByUser(long userId);
    Note createNote(Note note);
    Note getNoteById(long id);
    Note updateNoteById(long id, Note note);
    void deleteNoteById(long id);


    List<Section> getSectionsByUser(long userId);
    Section createSection(Section section);
    Section getSectionById(long id);
    Section updateSectionById(long id, Section section);
    void deleteSectionById(long id);


    List<Task> getTasksByUser(long sectionId);
    Task createTask(Task task);
    Task getTaskById(long id);

    Task updateTaskById(long id,Task task);
    void deleteTaskById(long id);

}