package be.steven.d.dog.contactlistbackend.service;

import be.steven.d.dog.contactlistbackend.mapper.ContactMapper;
import be.steven.d.dog.contactlistbackend.model.Contact;
import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.ContactListRepository;
import be.steven.d.dog.contactlistbackend.repository.ContactRepository;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactCommand;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactListCommand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactListRepository contactListRepository;
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactListRepository contactListRepository, ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactListRepository = contactListRepository;
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
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
    public void createNewContactList(CreateNewContactListCommand createNewContactListCommand) {
        ContactList newContactList = contactMapper.mapContactList(createNewContactListCommand);
        contactListRepository.saveAndFlush(newContactList);
    }

    @Override
    public void createNewContact(CreateNewContactCommand createNewContactCommand) {
        Contact newContact = contactMapper.mapContact(createNewContactCommand);
        contactRepository.saveAndFlush(newContact);
    }
}
