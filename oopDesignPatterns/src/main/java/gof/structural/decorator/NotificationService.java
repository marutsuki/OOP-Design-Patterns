package gof.structural.decorator;

import lombok.extern.log4j.Log4j2;

/**
 * Singleton is a good pattern to use for a service class that is stateless, since we only need one instance.
 *
 * This is done in other ways usually however, with Spring Boot -> We use Spring Beans to define @Service classes,
 * you can think of them as singletons (There can be multiple instances of the same service class however though).
 */
@Log4j2
public class NotificationService {
    public static NotificationService notificationService;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (notificationService == null) {
            notificationService = new NotificationService();
        }
        return notificationService;
    }

    /**
     * As this is supposed to be just an example, we will mimic sending a notification to a phone number. In reality,
     * this would be much harder
     * @param phoneNumber The phone number to send to
     * @param message The message to send along with the notification
     */
    public void notify(String phoneNumber, String message) {
        log.info("Sending notification to {}: {}", phoneNumber, message);
    }
}
