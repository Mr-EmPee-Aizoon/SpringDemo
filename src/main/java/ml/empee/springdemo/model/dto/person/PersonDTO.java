package ml.empee.springdemo.model.dto.person;

import lombok.Getter;
import lombok.Setter;

abstract class PersonDTO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String surname;

    @Getter @Setter
    private String gender;

    @Getter @Setter
    private String birthProvince;

    @Getter @Setter
    private String birthCity;

    @Getter @Setter
    private String birthDate;

}
