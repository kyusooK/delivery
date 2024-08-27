package test.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import test.domain.*;
import test.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StoreCreated extends AbstractEvent {

    private Long storeId;

    public StoreCreated(Store aggregate) {
        super(aggregate);
    }

    public StoreCreated() {
        super();
    }
}
//>>> DDD / Domain Event
