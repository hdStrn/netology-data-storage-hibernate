package ru.netology.netologydatastoragehibernate.service;

import ru.netology.netologydatastoragehibernate.entity.Person;
import ru.netology.netologydatastoragehibernate.entity.PersonalData;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person findByPersonalData(PersonalData personalData);

    Person savePerson(Person person);

    void deletePerson(PersonalData personalData);

    List<Person> findAllByCity(String city);

    List<Person> findAllByAgeLess(Integer age);

    Person findAllByNameAndSurname(String name, String surname);
}
