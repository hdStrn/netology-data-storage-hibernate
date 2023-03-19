package ru.netology.netologydatastoragehibernate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.netologydatastoragehibernate.entity.Person;
import ru.netology.netologydatastoragehibernate.entity.PersonalData;
import ru.netology.netologydatastoragehibernate.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{name}-{surname}-{age}")
    @ResponseStatus(code = HttpStatus.OK)
    public Person getPersonByPersonalData(@PathVariable String name,
                                          @PathVariable String surname,
                                          @PathVariable Integer age) {
        return personService.findByPersonalData(new PersonalData(name, surname, age));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{name}-{surname}-{age}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable String name,
                             @PathVariable String surname,
                             @PathVariable Integer age) {
        personService.deletePerson(new PersonalData(name, surname, age));
    }

    @GetMapping("/by-city")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.findAllByCity(city);
    }

    @GetMapping("/by-age-less")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> getPersonsByAgeLess(@RequestParam Integer age) {
        return personService.findAllByAgeLess(age);
    }

    @GetMapping("/by-name-and-surname")
    @ResponseStatus(code = HttpStatus.OK)
    public Person getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.findAllByNameAndSurname(name, surname);
    }
}
