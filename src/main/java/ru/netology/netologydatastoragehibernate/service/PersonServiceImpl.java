package ru.netology.netologydatastoragehibernate.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.netologydatastoragehibernate.dao.PersonDao;
import ru.netology.netologydatastoragehibernate.entity.Person;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public List<Person> getPersonsByCity(String city) {
        return personDao.getPersonsByCity(city);
    }
}
