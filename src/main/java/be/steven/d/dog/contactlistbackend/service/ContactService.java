package be.steven.d.dog.contactlistbackend.service;

import be.steven.d.dog.contactlistbackend.model.Contact;
import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactCommand;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactListCommand;

import java.util.List;

public interface ContactService {
    List<ContactList> findByUserId(Long userId);

    List<Contact> findByContactListId(Long listId);

    void createNewContactList(CreateNewContactListCommand createNewContactListCommand);

    void createNewContact(CreateNewContactCommand createNewContactCommand);
}
