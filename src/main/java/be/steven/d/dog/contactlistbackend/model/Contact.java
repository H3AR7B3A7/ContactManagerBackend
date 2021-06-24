package be.steven.d.dog.contactlistbackend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contactListId;
    private String name;
    private String email;
    private String number;

    public Contact(final Long contactListId, final String name, final String email, final String number) {
        this.contactListId = contactListId;
        this.name = name;
        this.email = email;
        this.number = number;
    }
}