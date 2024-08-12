package tn.esprit.futureuniversity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.futureuniversity.Entities.Notifications;

@RestController
public class NotificationController {
    @Autowired
    private SimpMessagingTemplate template;
    // Initialize Notifications
    private Notifications notifications = new Notifications(0);
    @GetMapping("/notify")
    public String getNotification() {
        // Increment Notification by one
        notifications.increment();
        // Push notifications to front-end
        template.convertAndSend("/topic/notification", notifications);
        return "Notifications successfully sent to Angular !";
    }
}
