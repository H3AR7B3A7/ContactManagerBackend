package be.steven.d.dog.contactlistbackend.model;

import lombok.*;

import javax.persistence.*;

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

    public Contact(Long contactListId, String name, String email, String number) {
        this.contactListId = contactListId;
        this.name = name;
        this.email = email;
        this.number = number;
    }
}