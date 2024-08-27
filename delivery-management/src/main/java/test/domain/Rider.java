package test.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import test.DeliveryManagementApplication;
import test.domain.RiderCreated;

@Entity
@Table(name = "Rider_table")
@Data
//<<< DDD / Aggregate Root
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    @Embedded
    private Address currentLocation;

    @PostPersist
    public void onPostPersist() {
        RiderCreated riderCreated = new RiderCreated(this);
        riderCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static RiderRepository repository() {
        RiderRepository riderRepository = DeliveryManagementApplication.applicationContext.getBean(
            RiderRepository.class
        );
        return riderRepository;
    }
}
//>>> DDD / Aggregate Root
