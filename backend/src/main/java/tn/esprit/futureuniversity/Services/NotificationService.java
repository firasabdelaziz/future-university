package tn.esprit.futureuniversity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.futureuniversity.Entities.Notification;
import tn.esprit.futureuniversity.Repositories.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService implements INotificationService{
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public boolean markAllAsRead() {
        List<Notification> notifications = notificationRepository.findAll();
        for (Notification notification : notifications) {
            notification.setRead(true);
            notificationRepository.save(notification);
        }
        return true;
    }
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification createNotification(Notification notification) {
        notification.setTime(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            notification.setTitle(notificationDetails.getTitle());
            notification.setDescription(notificationDetails.getDescription());
            notification.setRead(notificationDetails.isRead());
            notification.setLink(notificationDetails.getLink());
            notification.setLink(notificationDetails.getLink());
            return notificationRepository.save(notification);
        }
        return null;
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

}
