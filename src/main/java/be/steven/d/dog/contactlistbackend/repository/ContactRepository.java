package be.steven.d.dog.contactlistbackend.repository;

import be.steven.d.dog.contactlistbackend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByContactListId(Long userId);
}
