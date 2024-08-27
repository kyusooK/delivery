package test.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateOrderCommand {

    private CustomerId customerId;
    private StoreId storeId;
    private String orderStatus;
    private Money totalAmount;
}
