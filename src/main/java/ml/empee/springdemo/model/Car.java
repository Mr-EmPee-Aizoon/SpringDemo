package ml.empee.springdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    @Column(name = "car_id")
    private Integer carID;

    @Setter @Getter
    @Column(name = "license_plate")
    private String licensePlate;

    @Setter @Getter
    private String brand;

    @Setter @Getter
    private String model;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @Setter @Getter
    private Person person;

}
