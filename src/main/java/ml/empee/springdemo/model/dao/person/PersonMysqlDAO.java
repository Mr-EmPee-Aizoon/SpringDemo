package ml.empee.springdemo.model.dao.person;

import ml.empee.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonMysqlDAO implements PersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Override
    public Person findByID(Integer personID) {
        return entityManager.find(Person.class, personID);
    }

    @Override
    public Person update(Person person, Integer personID) {
       person.setPersonID(personID);
        return entityManager.merge(person);
    }

    @Override
    public Person deleteByID(Integer personID) {
        Person person = findByID(personID);
        if(person != null) {
            entityManager.remove(person);
            return person;
        }

        return null;
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("select p from Person p order by p.surname", Person.class);
        return query.getResultList();
    }
}
