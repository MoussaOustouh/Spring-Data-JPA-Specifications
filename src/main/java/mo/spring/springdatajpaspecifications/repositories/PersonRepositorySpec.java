package mo.spring.springdatajpaspecifications.repositories;

import mo.spring.springdatajpaspecifications.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositorySpec extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

}
