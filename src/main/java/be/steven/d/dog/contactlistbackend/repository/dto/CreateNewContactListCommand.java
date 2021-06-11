package be.steven.d.dog.contactlistbackend.repository.dto;

import lombok.Getter;

@Getter
public class CreateNewContactListCommand {
    private String name;
    private Long userId;
}
