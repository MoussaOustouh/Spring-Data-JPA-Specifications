package mo.spring.springdatajpaspecifications.dao;

import mo.spring.springdatajpaspecifications.entities.Person;

import java.util.List;

public interface IPersonDAO {
    List<Person> search(String firstname, String lastname, String email);
}
