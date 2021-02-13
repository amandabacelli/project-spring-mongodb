package com.abacelli.springmongodb.controllers.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardError {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
