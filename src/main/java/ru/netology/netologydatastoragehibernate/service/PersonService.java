package ru.netology.netologydatastoragehibernate.service;

import ru.netology.netologydatastoragehibernate.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonsByCity(String city);
}
