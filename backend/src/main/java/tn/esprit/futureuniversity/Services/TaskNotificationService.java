package tn.esprit.futureuniversity.Services;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class TaskNotificationService {
    private final SimpMessagingTemplate messagingTemplate;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TaskNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void scheduleNotification(Task task) {
        long delay = task.getDueDate().getTime() - System.currentTimeMillis();
        if (delay > 0) {
            scheduler.schedule(() -> sendNotification(task), delay, TimeUnit.MILLISECONDS);
        }
    }

    private void sendNotification(Task task) {
        String destination = "/topic/notification" + task.getUserId().getId();
        String message = "Task '" + task.getTitle() + "' in course '" + task.getCourse().getName() + "' is due now!";
        messagingTemplate.convertAndSend(destination, message);
    }
}