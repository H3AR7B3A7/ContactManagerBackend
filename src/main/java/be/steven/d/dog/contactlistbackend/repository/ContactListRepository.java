package be.steven.d.dog.contactlistbackend.repository;

import be.steven.d.dog.contactlistbackend.model.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactListRepository extends JpaRepository<ContactList, Long> {
    List<ContactList> findByUserId(Long userId);
}