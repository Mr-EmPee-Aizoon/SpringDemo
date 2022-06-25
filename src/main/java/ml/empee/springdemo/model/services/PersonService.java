package ml.empee.springdemo.model.services;

import ml.empee.springdemo.model.Person;
import ml.empee.springdemo.model.dao.person.PersonDAO;
import ml.empee.springdemo.model.dto.person.PersonRequestDTO;
import ml.empee.springdemo.model.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ml.empee.springdemo.model.dto.person.PersonResponseDTO;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public PersonResponseDTO save(PersonRequestDTO request) {
        Person result = personDAO.save(PersonMapper.mapDtoToEntity(request));
        return PersonMapper.mapEntityToDto(result);
    }

    @Nullable
    @Transactional
    public PersonResponseDTO update(PersonRequestDTO request, Integer personID) {
        Person person = personDAO.findByID(personID);
        if(person == null) {
            return null;
        }

        Person updatedEntity = personDAO.update(
                PersonMapper.mapDtoToEntity(request),
                personID
        );
        return PersonMapper.mapEntityToDto(updatedEntity);
    }

    @Nullable
    public PersonResponseDTO findByID(Integer personID) {
        Person person = personDAO.findByID(personID);
        if(person == null) {
            return null;
        }

        return PersonMapper.mapEntityToDto(person);
    }

    @Nullable
    public PersonResponseDTO deleteByID(Integer personID) {
        Person removedPerson = personDAO.deleteByID(personID);
        if(removedPerson == null) {
            return null;
        }

        return PersonMapper.mapEntityToDto(removedPerson);
    }

    public List<PersonResponseDTO> findAll() {
        List<Person> people = personDAO.findAll();
        if(people.isEmpty()) {
            return Collections.emptyList();
        }

        return PersonMapper.mapEntityListToDtoList(people);
    }

}
