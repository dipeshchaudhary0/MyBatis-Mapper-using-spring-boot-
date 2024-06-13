package com.dipesh.mybatis_test.service;

import com.dipesh.mybatis_test.dto.RefinedPerson;
import com.dipesh.mybatis_test.model.Person;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PersonService {

    Person findPersonById(Long id);

    RefinedPerson findRefinedPersonById(Long id);

    List<Person> findAllPersons();

    Person createPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Long id);

     List<RefinedPerson> findLimitedPersons(int page, int size);
}
