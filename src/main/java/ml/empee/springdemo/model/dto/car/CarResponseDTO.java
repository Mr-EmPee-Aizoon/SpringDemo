package ml.empee.springdemo.model.dto.car;

import lombok.Getter;
import lombok.Setter;
import ml.empee.springdemo.model.dto.person.PersonResponseDTO;

public class CarResponseDTO extends CarDTO {

    @Getter @Setter
    private Integer carID;

    @Setter @Getter
    private PersonResponseDTO carOwner;

}
