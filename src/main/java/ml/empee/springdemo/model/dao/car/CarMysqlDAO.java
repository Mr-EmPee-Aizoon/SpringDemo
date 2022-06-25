package ml.empee.springdemo.model.dao.car;

import ml.empee.springdemo.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarMysqlDAO implements CarDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Car save(Car car) {
        entityManager.persist(car);
        return car;
    }

    @Override
    public Car findByID(Integer carID) {
        return entityManager.find(Car.class, carID);
    }

    @Override
    public Car update(Car car, Integer targetCarID) {
        car.setCarID(targetCarID);
        return entityManager.merge(car);
    }

    @Override
    public Car deleteByID(Integer carID) {
        Car car = entityManager.find(Car.class, carID);
        if(car != null) {
            entityManager.remove(car);
            return car;
        }

        return null;
    }

    @Override
    public List<Car> findAll() {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c", Car.class);
        return query.getResultList();
    }

    @Override
    public List<Car> findAllByPerson(Integer personID) {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.person.personID = :pID", Car.class);
        query.setParameter("pID", personID);
        return query.getResultList();
    }
}
