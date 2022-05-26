package mo.spring.springdatajpaspecifications.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private Byte age;
    private String email;
    private String phoneNumber;
}
