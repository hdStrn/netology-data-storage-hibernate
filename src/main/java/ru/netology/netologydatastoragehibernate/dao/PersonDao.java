package ru.netology.netologydatastoragehibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.netologydatastoragehibernate.entity.Person;
import ru.netology.netologydatastoragehibernate.entity.PersonalData;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person, PersonalData> {

    List<Person> findAllByCityOfLiving(String city);

    List<Person> findAllByPersonalData_AgeLessThanOrderByPersonalData_Age(Integer age);

    Optional<Person> findAllByPersonalData_NameAndPersonalData_Surname(String name, String surname);
}
