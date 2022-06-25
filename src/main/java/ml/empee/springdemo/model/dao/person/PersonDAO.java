package ml.empee.springdemo.model.dao.person;

import ml.empee.springdemo.model.Person;

import java.util.List;

public interface PersonDAO {

    Person save(Person person);

    Person findByID(Integer personID);

    Person update(Person person, Integer targetPersonID);

    Person deleteByID(Integer personID);

    List<Person> findAll();

}
