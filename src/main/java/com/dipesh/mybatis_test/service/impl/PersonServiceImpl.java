package com.dipesh.mybatis_test.service.impl;


import com.dipesh.mybatis_test.mapper.PersonMapper;
import com.dipesh.mybatis_test.dto.RefinedPerson;
import com.dipesh.mybatis_test.model.Person;
import com.dipesh.mybatis_test.repository.PersonRepository;
import com.dipesh.mybatis_test.service.PersonService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public Person findPersonById(Long id) {
        return personMapper.findPersonById(id);
    }


    @Override
    public RefinedPerson findRefinedPersonById(Long id) {
        return personMapper.findRefinedPersonById(id);
    }

    @Override
    public List<Person> findAllPersons() {
        return personMapper.findAllPersons();
    }

    @Override
    public Person createPerson(Person person) {
     return personRepository.save(person);
    }


    @Override
    public void updatePerson(Person person) {
        personMapper.updatePerson(person);
    }

    @Override
    public void deletePerson(Long id) {
        personMapper.deletePerson(id);
    }

    @Override
    public List<RefinedPerson> findLimitedPersons(int page, int size) {
        int offset = page * size;
        RowBounds rowBounds = new RowBounds(offset, size);
        return personMapper.findLimitedPersons(rowBounds);

    }
}
