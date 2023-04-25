package com.lssev.service;

import com.lssev.domain.Person;
import com.lssev.dto.CreateOrUpdatePersonDTO;
import com.lssev.repository.PersonRepository;
import jakarta.inject.Inject;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> list() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findById(@NotNull Long id) {
        return this.personRepository.findById(id).orElse(null);
    }

    @Override
    public Person create(CreateOrUpdatePersonDTO createOrUpdatePersonDTO) {
        Person person = new Person();
        person.setName(createOrUpdatePersonDTO.name);
        person.setPhone(createOrUpdatePersonDTO.phone);

        return this.personRepository.save(person);
    }

    @Override
    public Person update(@NotNull Long id, CreateOrUpdatePersonDTO createOrUpdatePersonDTO) {
        Person person = this.personRepository.findById(id).orElse(null);

        if (person == null) {
            return null;
        }

        if (!createOrUpdatePersonDTO.name.equals("")) {
            person.setName(createOrUpdatePersonDTO.name);
        }

        if (!createOrUpdatePersonDTO.phone.equals("")) {
            person.setPhone(createOrUpdatePersonDTO.phone);
        }

        return this.personRepository.update(person);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        Person person = this.personRepository.findById(id).orElse(null);

        if (person == null) {
            return;
        }

        this.personRepository.deleteById(id);
    }
}
