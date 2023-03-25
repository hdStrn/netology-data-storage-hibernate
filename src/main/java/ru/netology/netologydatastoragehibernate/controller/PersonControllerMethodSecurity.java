package ru.netology.netologydatastoragehibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.netologydatastoragehibernate.entity.Person;
import ru.netology.netologydatastoragehibernate.entity.PersonalData;
import ru.netology.netologydatastoragehibernate.service.PersonService;

import java.util.List;

@RestController("Method Security Controller")
@RequiredArgsConstructor
@RequestMapping("/persons-method-security")
public class PersonControllerMethodSecurity {

    private final PersonService personService;

    @GetMapping
    @Secured("ROLE_READ")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{name}-{surname}-{age}")
    @Secured("ROLE_READ")
    @ResponseStatus(code = HttpStatus.OK)
    public Person getPersonByPersonalData(@PathVariable String name,
                                          @PathVariable String surname,
                                          @PathVariable Integer age) {
        return personService.findByPersonalData(new PersonalData(name, surname, age));
    }

    @PostMapping
    @RolesAllowed("WRITE")
    @ResponseStatus(code = HttpStatus.OK)
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{name}-{surname}-{age}")
    @PostAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable String name,
                             @PathVariable String surname,
                             @PathVariable Integer age) {
        personService.deletePerson(new PersonalData(name, surname, age));
    }

    @GetMapping("/authentication")
    @PostAuthorize("#username == authentication.principal.username")
    @ResponseStatus(code = HttpStatus.OK)
    public String checkAuthentication(@RequestParam String username) {
        return "Hi, " + username + ", you are authenticated!";
    }
}
