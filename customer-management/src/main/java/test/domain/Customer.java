package test.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.CustomerManagementApplication;
import test.domain.CustomerCreated;
import test.domain.PointUpdated;

@Entity
@Table(name = "Customer_table")
@Data
//<<< DDD / Aggregate Root
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    @Embedded
    private Address address;

    private Integer totalPoints;

    @PostPersist
    public void onPostPersist() {
        CustomerCreated customerCreated = new CustomerCreated(this);
        customerCreated.publishAfterCommit();

        PointUpdated pointUpdated = new PointUpdated(this);
        pointUpdated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerManagementApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
}
//>>> DDD / Aggregate Root
