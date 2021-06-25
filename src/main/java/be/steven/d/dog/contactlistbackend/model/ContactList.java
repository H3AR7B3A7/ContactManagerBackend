package be.steven.d.dog.contactlistbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ContactList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactList")
    @JsonIgnoreProperties("contactList")
    private List<Contact> contacts = new ArrayList<>();

}