package be.steven.d.dog.contactlistbackend.service;

import be.steven.d.dog.contactlistbackend.model.Contact;
import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.ContactListRepository;
import be.steven.d.dog.contactlistbackend.repository.ContactRepository;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactCommand;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactListRepository contactListRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactListRepository contactListRepository, ContactRepository contactRepository) {
        this.contactListRepository = contactListRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactList> findByUserId(Long userId) {
        return contactListRepository.findByUserId(userId);
    }

    @Override
    public List<Contact> findByContactListId(Long listId) {
        return contactRepository.findByContactListId(listId);
    }

    @Override
    public void createNewContactList(CreateNewContactListCommand command) {
        ContactList newContactList = new ContactList(command.getUserId(), command.getName());
        contactListRepository.saveAndFlush(newContactList);
    }

    @Override
    public void createNewContact(CreateNewContactCommand createNewContactCommand) {
        Contact newContact = new Contact(createNewContactCommand.getContactListId(),
                createNewContactCommand.getName(),
                createNewContactCommand.getEmail(),
                createNewContactCommand.getNumber());
        contactRepository.saveAndFlush(newContact);
    }
}
