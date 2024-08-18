package tn.esprit.futureuniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Notification;
import tn.esprit.futureuniversity.Entities.Task;
import tn.esprit.futureuniversity.Repositories.NotificationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class TaskNotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificationRepository notificationRepository;

    public TaskNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    public void scheduleNotification(Task task) {
        long currentTime = System.currentTimeMillis();
        long dueTime = task.getDueDate().getTime();
        long delay = dueTime - currentTime;



        System.out.println("delay"+delay);
        System.out.println("getDueDate"+task.getDueDate().getTime());
        System.out.println("System.currentTimeMillis"+System.currentTimeMillis());
        if (delay < 0) {
            sendDueNotification(task);
        } else {
            sendNotification(task, "Task updated: " + task.getTitle());

        }

    }

    private void sendNotification(Task task,String message) {
        String destination = "/topic/notification";

        // Create and save the notification in the database
        Notification notification = new Notification("Task Notification", message, "apps/tasks/" + task.getId());
        notificationRepository.save(notification);

        // String message = "Task '" + task.getTitle() + "' in course '" + task.getCourse().getName() + "' is due now!";
        messagingTemplate.convertAndSend(destination,message);
    }
    private void sendDueNotification(Task task) {
        String destination = "/topic/notification";

        // Create and save the notification in the database
        Notification notification = new Notification("Task Notification", "Task due : " + task.getTitle(), "apps/tasks/" + task.getId());
        notificationRepository.save(notification);

        messagingTemplate.convertAndSend(destination, "Task due : " + task.getTitle());
    }



}