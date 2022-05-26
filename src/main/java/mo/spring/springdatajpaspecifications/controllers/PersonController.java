package mo.spring.springdatajpaspecifications.controllers;

import mo.spring.springdatajpaspecifications.dao.IPersonDAO;
import mo.spring.springdatajpaspecifications.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/predicate-search")
    public ResponseEntity<List<Person>> predicateSearch(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email){
        List<Person> res = personDAO.search(firstname, lastname, email);
        return ResponseEntity.ok(res);
    }
}
