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

    public ContactServiceImpl(final ContactListRepository contactListRepository, final ContactRepository contactRepository, final ContactMapper contactMapper) {
        this.contactListRepository = contactListRepository;
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public List<ContactList> findByUserId(final Long userId) {
        return contactListRepository.findByUserId(userId);
    }

    @Override
    public List<Contact> findByContactListId(final Long listId) {
        return contactRepository.findByContactListId(listId);
    }

    @Override
    public void createNewContactList(final CreateNewContactListCommand createNewContactListCommand) {
        final ContactList newContactList = contactMapper.mapContactList(createNewContactListCommand);
        contactListRepository.saveAndFlush(newContactList);
    }

    @Override
    public void createNewContact(final CreateNewContactCommand createNewContactCommand) {
        final Contact newContact = contactMapper.mapContact(createNewContactCommand);
        contactRepository.saveAndFlush(newContact);
    }

    @Override
    public void deleteContact(final Long contactId) {
        contactRepository.deleteById(contactId);
    }

    @Override
    public void deleteList(final Long listId) {
        contactListRepository.deleteById(listId);
    }
}
