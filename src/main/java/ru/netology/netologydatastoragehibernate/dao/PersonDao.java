package ru.netology.netologydatastoragehibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.netologydatastoragehibernate.entity.Person;
import ru.netology.netologydatastoragehibernate.entity.PersonalData;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person, PersonalData> {

    @Query(value = "SELECT * FROM person p WHERE p.city_of_living = :city", nativeQuery = true)
    List<Person> findAllByCityOfLiving(String city);

    @Query(value = "SELECT * FROM person p WHERE p.age < :age ORDER BY p.age", nativeQuery = true)
    List<Person> findAllByPersonalData_AgeLessThanOrderByPersonalData_Age(Integer age);

    @Query(value = "SELECT * FROM person p WHERE p.name = :name AND p.surname = :surname", nativeQuery = true)
    Optional<Person> findByPersonalData_NameAndPersonalData_Surname(String name, String surname);
}
