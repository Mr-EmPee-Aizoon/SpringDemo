package ml.empee.springdemo.model.dto.car;

import lombok.Getter;
import lombok.Setter;

abstract class CarDTO {

    @Setter @Getter
    private String licensePlate;

    @Setter @Getter
    private String brand;

    @Setter @Getter
    private String model;

    @Setter @Getter
    private int displacement;

}
