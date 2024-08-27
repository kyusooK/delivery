package test.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.OrderManagementApplication;
import test.domain.OrderCreated;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private CustomerId customerId;

    @Embedded
    private StoreId storeId;

    private String orderStatus;

    @Embedded
    private orderStatusType orderStatusType;

    private LocalDateTime orderTime;

    @Embedded
    private Money totalAmount;

    @PostPersist
    public void onPostPersist() {
        OrderCreated orderCreated = new OrderCreated(this);
        orderCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderManagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
