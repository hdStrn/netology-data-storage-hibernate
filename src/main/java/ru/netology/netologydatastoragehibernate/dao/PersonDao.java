package ru.netology.netologydatastoragehibernate.dao;

import ru.netology.netologydatastoragehibernate.entity.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getPersonsByCity(String city);
}
