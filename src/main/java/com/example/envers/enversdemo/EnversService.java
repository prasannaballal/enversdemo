package com.example.envers.enversdemo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EnversService {

    private final PersonRepository personRepository;

    public EnversService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String updatePerson(PersonDto personDto) {
        Optional<Person> optionalPerson = personRepository.findById(personDto.getId());
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setFirst_name(personDto.getFirstName());
            person.setLast_name(personDto.getLastName());
            person.setEmail(personDto.getEmail());
            person.setModifiedDate(LocalDateTime.now());
            personRepository.save(person);
            return "Person updated successfully" ;
        } else {
            return"Person not found with id: " + personDto.getId()+".";
        }
    }

    public String createPerson(PersonDto personDto) {
        Person person = new Person();
        person.setFirst_name(personDto.getFirstName());
        person.setLast_name(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setCreatedDate(LocalDateTime.now());
        personRepository.save(person);
        return"Person created successfully";
    }

    public String deletePerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.delete(optionalPerson.get());
            return"Person deleted successfully";
        } else {
            return"Person not found with id: " +id+".";
        }
    }
}
