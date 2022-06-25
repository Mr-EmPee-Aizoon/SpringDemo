package ml.empee.springdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    @Column(name = "person_id")
    private Integer personID;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String surname;

    @Setter @Getter
    private String gender;

    @Setter @Getter
    @Column(name = "birth_city")
    private String birthCity;

    @Setter @Getter
    @Column(name = "birth_province")
    private String birthProvince;

    @Setter @Getter
    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Person() {}

    public Person(Integer personID) {
        this.personID = personID;
    }

}
