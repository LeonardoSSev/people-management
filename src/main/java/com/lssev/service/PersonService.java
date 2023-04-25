package com.lssev.service;

import com.lssev.domain.Person;
import com.lssev.dto.CreateOrUpdatePersonDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface PersonService {

    Iterable<Person> list();

    Person findById(@NotNull Long id);

    Person create(@NotBlank CreateOrUpdatePersonDTO person);
    Person update(@NotNull Long id, @NotBlank CreateOrUpdatePersonDTO person);

    void deleteById(@NotNull Long id);
}
