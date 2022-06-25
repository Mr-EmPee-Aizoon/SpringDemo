package ml.empee.springdemo.controller;

import ml.empee.springdemo.model.dto.person.PersonRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ml.empee.springdemo.model.dto.person.PersonResponseDTO;
import ml.empee.springdemo.model.services.PersonService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(
            value = "/save",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public PersonResponseDTO save(PersonRequestDTO request) {
        validatePerson(request);

        return personService.save(request);
    }

    @GetMapping(
            value = "/find/{personID}",
            produces = APPLICATION_JSON_VALUE
    )
    public PersonResponseDTO findByID(@PathVariable("personID") Integer personID) {
        if(personID == null || personID < 0) {
            throw new IllegalArgumentException("Invalid personID");
        }

        return personService.findByID(personID);
    }

    @PutMapping(
            value = "/edit/{personID}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public PersonResponseDTO update(PersonRequestDTO request, @PathVariable("personID") Integer personID) {
        validatePerson(request);

        return personService.update(request, personID);
    }

    @DeleteMapping(
            value = "/remove/{personID}",
            produces = APPLICATION_JSON_VALUE
    )
    public PersonResponseDTO deleteByID(@PathVariable("personID") Integer personID) {
        if(personID == null || personID < 0) {
            throw new IllegalArgumentException("Invalid personID");
        }

        return personService.deleteByID(personID);
    }

    @GetMapping(
            value = "/list",
            produces = APPLICATION_JSON_VALUE
    )
    public List<PersonResponseDTO> findAll() {
        return personService.findAll();
    }

    private static boolean validatePerson(PersonRequestDTO person) {
        String nome = person.getName();
        if(nome == null || nome.length() < 5 || nome.length() > 30) {
            throw new IllegalArgumentException("The person name isn't valid");
        }

        String surname = person.getSurname();
        if(surname == null || surname.length() < 5 || surname.length() > 30) {
            throw new IllegalArgumentException("The person surname isn't valid");
        }

        String gender = person.getGender();
        if(gender == null || gender.length() != 1 || (gender.charAt(0) != 'M' && gender.charAt(0) != 'F')) {
            throw new IllegalArgumentException("The person gender isn't valid");
        }

        String birthCity = person.getBirthCity();
        if(birthCity == null) {
            throw new IllegalArgumentException("The person birth city is invalid");
        }

        String birthProvince = person.getBirthProvince();
        if(birthProvince == null || birthProvince.length() != 2) {
            throw new IllegalArgumentException("The person birth province isn't valid");
        }

        String birthDate = person.getBirthDate();
        if(birthDate == null || !birthDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("The person birth date is invalid");
        }

        return true;
    }

}
