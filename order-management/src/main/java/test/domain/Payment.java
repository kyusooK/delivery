package test.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.OrderManagementApplication;
import test.domain.PaymentCreated;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private OrderId orderId;

    @Embedded
    private Money amount;

    private String paymentMethod;

    private String paymentStatus;

    @Embedded
    private paymentStatusType paymentStatusType;

    private LocalDateTime paymentTime;

    private Integer earnedPoints;

    @PostPersist
    public void onPostPersist() {
        PaymentCreated paymentCreated = new PaymentCreated(this);
        paymentCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = OrderManagementApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }
}
//>>> DDD / Aggregate Root
