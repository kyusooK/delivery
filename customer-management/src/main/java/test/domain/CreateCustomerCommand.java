package test.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateCustomerCommand {

    private String name;
    private String phone;
    private Address address;
}
