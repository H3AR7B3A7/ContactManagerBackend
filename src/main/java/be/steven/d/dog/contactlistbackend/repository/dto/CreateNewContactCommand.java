package be.steven.d.dog.contactlistbackend.repository.dto;

import lombok.Getter;

@Getter
public class CreateNewContactCommand {
    private Long contactListId;
    private String name;
    private String email;
    private String number;
}
