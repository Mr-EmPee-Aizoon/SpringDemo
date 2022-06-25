package ml.empee.springdemo.model.dao.car;

import ml.empee.springdemo.model.Car;

import java.util.List;

public interface CarDAO {

    Car save(Car car);

    Car findByID(Integer carID);

    Car update(Car car, Integer targetCarID);

    Car deleteByID(Integer carID);

    List<Car> findAll();

    List<Car> findAllByPerson(Integer personID);

}
