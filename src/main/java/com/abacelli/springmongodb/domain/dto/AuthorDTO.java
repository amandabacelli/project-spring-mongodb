package com.abacelli.springmongodb.domain.dto;

import com.abacelli.springmongodb.domain.User;
import lombok.Getter;

@Getter
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
