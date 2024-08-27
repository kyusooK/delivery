package test.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.NotificationManagementApplication;
import test.domain.NotificationCreated;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private CustomerId customerId;

    @Embedded
    private OrderId orderId;

    private String message;

    private LocalDateTime notificationTime;

    @PostPersist
    public void onPostPersist() {
        NotificationCreated notificationCreated = new NotificationCreated(this);
        notificationCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationManagementApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
//>>> DDD / Aggregate Root
