package ru.netology.netologydatastoragehibernate.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.netologydatastoragehibernate.dao.PersonDao;
import ru.netology.netologydatastoragehibernate.entity.Person;
import ru.netology.netologydatastoragehibernate.entity.PersonalData;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person findByPersonalData(PersonalData personalData) {
        return personDao.findById(personalData).orElse(null);
    }

    @Override
    public Person savePerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public void deletePerson(PersonalData personalData) {
        personDao.deleteById(personalData);
    }

    @Override
    public List<Person> findAllByCity(String city) {
        return personDao.findAllByCityOfLiving(city);
    }

    @Override
    public List<Person> findAllByAgeLess(Integer age) {
        return personDao.findAllByPersonalData_AgeLessThanOrderByPersonalData_Age(age);
    }

    @Override
    public Person findAllByNameAndSurname(String name, String surname) {
        return personDao.findAllByPersonalData_NameAndPersonalData_Surname(name, surname)
                .orElse(null);
    }
}
