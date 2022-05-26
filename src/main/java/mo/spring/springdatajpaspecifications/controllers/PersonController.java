package mo.spring.springdatajpaspecifications.controllers;

import mo.spring.springdatajpaspecifications.dao.IPersonDAO;
import mo.spring.springdatajpaspecifications.entities.Person;
import mo.spring.springdatajpaspecifications.repositories.PersonRepositorySpec;
import mo.spring.springdatajpaspecifications.specifications.PersonSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private IPersonDAO personDAO;

    @Autowired
    private PersonRepositorySpec personRepositorySpec;

    @RequestMapping("/predicate-search")
    public ResponseEntity<List<Person>> predicateSearch(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email){
        List<Person> res = personDAO.search(firstname, lastname, email);
        return ResponseEntity.ok(res);
    }

    @RequestMapping("/specification-search")
    public ResponseEntity<List<Person>> specificationSearch(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Byte minAge){
        Specification<Person> specifications = Specification.where(PersonSpecifications.likeFirstname(firstname))
                .and(PersonSpecifications.likeLastname(lastname))
                .and(PersonSpecifications.equalEmail(email))
                .and(PersonSpecifications.greaterThanOrEqualToAge(minAge));

        List<Person> res = personRepositorySpec.findAll(specifications);

        return ResponseEntity.ok(res);
    }
}
