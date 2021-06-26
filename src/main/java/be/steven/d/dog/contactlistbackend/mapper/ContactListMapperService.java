package be.steven.d.dog.contactlistbackend.mapper;

import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.ContactListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactListMapperService {

    @Autowired
    private ContactListRepository contactListRepository;

    public ContactList map(final Long contactListId) {
        return contactListRepository.findById(contactListId).get();
    }
}