package mo.spring.springdatajpaspecifications;

import mo.spring.springdatajpaspecifications.entities.Person;
import mo.spring.springdatajpaspecifications.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaSpecificationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaSpecificationsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PersonRepository personRepository){
        return args -> {
            Person p1 = new Person(null, "Moussa", "OUSTOUH", (byte)25, "mo@gmail.com", "06XXXXXXXX");
            personRepository.save(p1);
            Person p2 = new Person(null, "Test1", "Test11", (byte)26, "test1@gmail.com", "06XXXXXXXX");
            personRepository.save(p2);
        };
    }

}
