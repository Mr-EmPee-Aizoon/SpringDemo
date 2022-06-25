package ml.empee.springdemo.model.mappers;

import ml.empee.springdemo.model.Person;
import ml.empee.springdemo.model.dto.person.PersonRequestDTO;
import ml.empee.springdemo.model.dto.person.PersonResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public static Person mapDtoToEntity(PersonRequestDTO request) {
        Person entity = new Person();
        entity.setName(request.getName());
        entity.setSurname(request.getSurname());
        entity.setGender(request.getGender());

        entity.setBirthCity(request.getBirthCity());
        entity.setBirthProvince(request.getBirthProvince());
        entity.setBirthDate(LocalDate.parse(request.getBirthDate()));

        return entity;
    }

    public static PersonResponseDTO mapEntityToDto(Person entity) {
        PersonResponseDTO response = new PersonResponseDTO();

        response.setPersonID(entity.getPersonID());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setGender(entity.getGender());

        response.setBirthCity(entity.getBirthCity());
        response.setBirthProvince(entity.getBirthProvince());
        response.setBirthDate(entity.getBirthDate().toString());

        return response;
    }

    public static List<Person> mapDtoListToEntityList(List<PersonRequestDTO> requests) {
        return requests.stream()
                .map(PersonMapper::mapDtoToEntity)
                .collect(Collectors.toList());
    }

    public static List<PersonResponseDTO> mapEntityListToDtoList(List<Person> entities) {
        return entities.stream()
                .map(PersonMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
