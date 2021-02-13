package com.abacelli.springmongodb.domain.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CommentDTO {

    private String text;
    private Date date;
    private AuthorDTO author;

    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
