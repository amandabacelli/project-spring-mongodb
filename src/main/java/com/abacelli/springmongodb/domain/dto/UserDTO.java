package com.abacelli.springmongodb.domain.dto;

import com.abacelli.springmongodb.domain.User;
import lombok.Getter;

@Getter
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
