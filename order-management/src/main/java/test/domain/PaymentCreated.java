package test.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import test.domain.*;
import test.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCreated extends AbstractEvent {

    private Long id;
    private OrderId orderId;
    private Money amount;
    private String paymentMethod;
    private String paymentStatus;
    private paymentStatusType paymentStatusType;
    private LocalDateTime paymentTime;
    private Integer earnedPoints;

    public PaymentCreated(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCreated() {
        super();
    }
}
//>>> DDD / Domain Event
