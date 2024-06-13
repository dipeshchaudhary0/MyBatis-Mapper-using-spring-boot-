package com.dipesh.mybatis_test.controller;

import com.dipesh.mybatis_test.dto.RefinedPerson;
import com.dipesh.mybatis_test.model.Person;
import com.dipesh.mybatis_test.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.findPersonById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/refined/{id}")
    public ResponseEntity<RefinedPerson> getRefinedPersonById(@PathVariable Long id) {
        RefinedPerson refinedPerson = personService.findRefinedPersonById(id);
        return ResponseEntity.ok(refinedPerson);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.findAllPersons();
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {

        return ResponseEntity.ok().body(personService.createPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        personService.updatePerson(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/paginated")
    public List<RefinedPerson> getLimitedPersons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size) {
        return personService.findLimitedPersons(page, size);
    }
}
