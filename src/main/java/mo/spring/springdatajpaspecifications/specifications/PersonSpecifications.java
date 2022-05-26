package mo.spring.springdatajpaspecifications.specifications;

import mo.spring.springdatajpaspecifications.entities.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecifications {
    private PersonSpecifications() {
    }

    public static Specification<Person> likeFirstname(String firstname){
        if(firstname == null) {
            return null;
        }
        else {
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.like( root.get("firstname"), "%"+firstname+"%" );
        }
    }

    public static Specification<Person> likeLastname(String lastname){
        if(lastname == null) {
            return null;
        }
        else {
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.like( root.get("lastname"), "%"+lastname+"%" );
        }
    }

    public static Specification<Person> equalEmail(String email){
        if(email == null) {
            return null;
        }
        else {
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal( root.get("email"), email );
        }
    }

    public static Specification<Person> greaterThanOrEqualToAge(Byte age){
        if(age == null) {
            return null;
        }
        else {
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo( root.get("age"), age );
        }
    }
}
