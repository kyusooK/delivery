package test.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import test.domain.*;
import test.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CustomerCreated extends AbstractEvent {

    private Long customerId;

    public CustomerCreated(Customer aggregate) {
        super(aggregate);
    }

    public CustomerCreated() {
        super();
    }
}
//>>> DDD / Domain Event
