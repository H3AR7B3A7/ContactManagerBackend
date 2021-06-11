package be.steven.d.dog.contactlistbackend.mapper;

import be.steven.d.dog.contactlistbackend.model.Contact;
import be.steven.d.dog.contactlistbackend.model.ContactList;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactCommand;
import be.steven.d.dog.contactlistbackend.repository.dto.CreateNewContactListCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact mapContact(CreateNewContactCommand createNewContactCommand);

    ContactList mapContactList(CreateNewContactListCommand createNewContactListCommand);
}