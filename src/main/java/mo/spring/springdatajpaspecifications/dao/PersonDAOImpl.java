package mo.spring.springdatajpaspecifications.dao;

import mo.spring.springdatajpaspecifications.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonDAOImpl implements IPersonDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Person> search(String firstname, String lastname, String email) {
        // create person query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);

        // firstname predicate
        Predicate firstnamePredicate = criteriaBuilder.like( personRoot.get("firstname"), "%"+firstname+"%" );

        // lastname predicate
        Predicate lastnamePredicate = criteriaBuilder.like( personRoot.get("lastname"), "%"+lastname+"%" );

        // email predicate
        Predicate emailPredicate = criteriaBuilder.equal( personRoot.get("email"), email );

        // apply the predicates
        criteriaQuery.where(firstnamePredicate, lastnamePredicate, emailPredicate);

        // get the result
        TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
