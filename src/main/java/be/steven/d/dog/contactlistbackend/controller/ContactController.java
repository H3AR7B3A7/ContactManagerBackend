package be.steven.d.dog.contactlistbackend.controller;

import be.steven.d.dog.contactlistbackend.model.Contact;
import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactCommand;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactListCommand;
import be.steven.d.dog.contactlistbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*", maxAge = 3600) // Change "*" to your domain name.
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/lists/{userId}")
    public List<ContactList> contactListsOfUser(@PathVariable final Long userId) {
        return contactService.findByUserId(userId);
    }

    @GetMapping("{listId}")
    public List<Contact> contactsOfContactList(@PathVariable final Long listId) {
        return contactService.findByContactListId(listId);
    }

    @PostMapping("/lists")
    public ContactList createNewContactList(@RequestBody final CreateNewContactListCommand createNewContactListCommand) {
        return contactService.createNewContactList(createNewContactListCommand);
    }

    @PostMapping("/")
    public Contact createNewContact(@RequestBody final CreateNewContactCommand createNewContactCommand) {
        return contactService.createNewContact(createNewContactCommand);
    }

    @DeleteMapping("/delete/{contactId}")
    public void deleteContact(@PathVariable final Long contactId) {
        contactService.deleteContact(contactId);
    }

    @DeleteMapping("/delete/lists/{listId}")
    public void deleteList(@PathVariable final Long listId) {
        contactService.deleteList(listId);
    }
}