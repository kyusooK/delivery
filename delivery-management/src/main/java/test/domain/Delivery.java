package test.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.DeliveryManagementApplication;
import test.domain.DeliveryCreated;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private OrderId orderId;

    @Embedded
    private RiderId riderId;

    private LocalDateTime pickupTime;

    private String deliveryStatus;

    @Embedded
    private deliveryStatusType deliveryStatusType;

    @PostPersist
    public void onPostPersist() {
        DeliveryCreated deliveryCreated = new DeliveryCreated(this);
        deliveryCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryManagementApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }
}
//>>> DDD / Aggregate Root
