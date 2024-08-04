package tn.esprit.futureuniversity.Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Note;
import tn.esprit.futureuniversity.Entities.Task;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ExportService {

    public ByteArrayInputStream notesPDFReport(List<Note> notes) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add content to the PDF document
            for (Note note : notes) {
                document.add(new Paragraph("Title: " + note.getTitle()));
                document.add(new Paragraph("Description: " + note.getDescription()));
                document.add(new Paragraph("Label: " + note.getLabel()));
                document.add(new Paragraph(" "));
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
    public ByteArrayInputStream tasksPDFReport(List<Task> tasks) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add content to the PDF document
            for (Task task : tasks) {
                document.add(new Paragraph("Title: " + task.getTitle()));
                document.add(new Paragraph("Completed: " + task.isCompleted()));
                document.add(new Paragraph("Priority: " + task.getPriority()));
                document.add(new Paragraph("Due Date: " + task.getDueDate()));
                document.add(new Paragraph(" "));
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}

