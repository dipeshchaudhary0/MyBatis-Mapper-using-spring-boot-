package com.dipesh.mybatis_test.mapper;

import com.dipesh.mybatis_test.dto.RefinedPerson;
import com.dipesh.mybatis_test.model.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;


import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("""
            SELECT id,
                   name,
                   email,
                   phone_number AS phoneNumber,
                   address,
                   city,
                   state,
                   country,
                   postal_code AS postalCode,
                   occupation
            FROM persons
            WHERE id = #{id}
            """)
    Person findPersonById(Long id);

    @Select("""
            SELECT id,
                   name,
                   email,
                   phone_number AS phoneNumber
            FROM persons
            WHERE id = #{id}
            """)
    RefinedPerson findRefinedPersonById(Long id);

    @Select("""
            SELECT id,
                   name,
                   email,
                   phone_number AS phoneNumber,
                   address,
                   city,
                   state,
                   country,
                   postal_code AS postalCode,
                   occupation
            FROM persons
            """)
    List<Person> findAllPersons();

    @Update("""
            UPDATE persons
            SET name = #{name},
                email = #{email},
                phone_number = #{phoneNumber},
                address = #{address},
                city = #{city},
                state = #{state},
                country = #{country},
                postal_code = #{postalCode},
                occupation = #{occupation}
            WHERE id = #{id}
            """)
    void updatePerson(Person person);

    @Delete("DELETE FROM persons WHERE id = #{id}")
    void deletePerson(Long id);

    @Select("""
            SELECT id,
                   name,
                   email,
                   phone_number AS phoneNumber
            FROM persons
            """)
    List<RefinedPerson> findLimitedPersons(RowBounds rowBounds);
    Page<RefinedPerson> findLimitedPersons();
}
