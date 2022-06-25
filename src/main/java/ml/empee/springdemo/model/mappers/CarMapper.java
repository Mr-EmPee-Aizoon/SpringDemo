package ml.empee.springdemo.model.mappers;

import ml.empee.springdemo.model.Car;
import ml.empee.springdemo.model.Person;
import ml.empee.springdemo.model.dto.car.CarRequestDTO;
import ml.empee.springdemo.model.dto.car.CarResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static Car mapDtoToEntity(CarRequestDTO request) {
        Car car = new Car();
        car.setLicensePlate(request.getLicensePlate());
        car.setBrand(request.getBrand());
        car.setModel(request.getModel());

        car.setPerson(
                new Person(request.getCarOwner())
        );

        return car;
    }

    public static CarResponseDTO mapEntityToDto(Car entity) {
        CarResponseDTO response = new CarResponseDTO();

        response.setLicensePlate(entity.getLicensePlate());
        response.setBrand(entity.getBrand());
        response.setModel(entity.getModel());

        response.setCarOwner(
                PersonMapper.mapEntityToDto(entity.getPerson())
        );

        return response;
    }

    public static List<Car> mapDtoListToEntityList(List<CarRequestDTO> requests) {
        return requests.stream()
                .map(CarMapper::mapDtoToEntity)
                .collect(Collectors.toList());
    }

    public static List<CarResponseDTO> mapEntityListToDtoList(List<Car> entities) {
        return entities.stream()
                .map(CarMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
