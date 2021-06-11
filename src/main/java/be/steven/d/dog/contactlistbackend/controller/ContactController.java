package be.steven.d.dog.contactlistbackend.controller;

import be.steven.d.dog.contactlistbackend.model.Contact;
import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactCommand;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactListCommand;
import be.steven.d.dog.contactlistbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/lists/{userId}")
    public List<ContactList> contactListsOfUser(@PathVariable Long userId) {
        return contactService.findByUserId(userId);
    }

    @GetMapping("{listId}")
    public List<Contact> contactsOfContactList(@PathVariable Long listId) {
        return contactService.findByContactListId(listId);
    }

    @PostMapping("/lists")
    public void createNewContactList(@RequestBody CreateNewContactListCommand createNewContactListCommand) {
        contactService.createNewContactList(createNewContactListCommand);
    }

    @PostMapping("/")
    public void createNewContact(@RequestBody CreateNewContactCommand createNewContactCommand) {
        contactService.createNewContact(createNewContactCommand);
    }
}
