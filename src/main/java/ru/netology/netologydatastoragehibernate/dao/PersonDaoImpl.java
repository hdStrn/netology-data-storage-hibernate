package ru.netology.netologydatastoragehibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.netologydatastoragehibernate.entity.Person;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Person> getPersonsByCity(String city) {
//        Query selectByCity = entityManager.createQuery(
//                "select p from Person p where p.cityOfLiving = :city", Person.class);
//        selectByCity.setParameter("city", city);
//        return selectByCity.getResultList();

        return entityManager.createQuery("select p from Person p", Person.class).getResultStream()
                .filter(p -> Objects.equals(p.getCityOfLiving().toLowerCase(), city.toLowerCase()))
                .collect(Collectors.toList());
    }
}
