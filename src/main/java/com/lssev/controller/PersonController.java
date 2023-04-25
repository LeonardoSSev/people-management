package com.lssev.controller;

import com.lssev.domain.Person;
import com.lssev.dto.CreateOrUpdatePersonDTO;
import com.lssev.service.PersonServiceImpl;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Controller(value = "/person")
public class PersonController {

    @Inject
    private PersonServiceImpl personServiceImpl;

    @Get
    public Iterable<Person> list() {
        return this.personServiceImpl.list();
    }

    @Get("/{id}")
    public Person findById(@PathVariable Long id) {
        return this.personServiceImpl.findById(id);
    }

    @Post
    public Person create(@Body @Valid CreateOrUpdatePersonDTO newPerson) {
        return this.personServiceImpl.create(newPerson);
    }

    @Put("/{id}")
    public Person update(@PathVariable Long id, @Body @Valid CreateOrUpdatePersonDTO person) {
        return this.personServiceImpl.update(id, person);
    }

    @Delete("/{id}")
    public void delete(@PathVariable Long id) {
        this.personServiceImpl.deleteById(id);
    }
}
