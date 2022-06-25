package ml.empee.springdemo.model.dto.car;

import lombok.Getter;
import lombok.Setter;

public class CarRequestDTO extends CarDTO {

    @Setter @Getter
    private Integer carOwner;

}
