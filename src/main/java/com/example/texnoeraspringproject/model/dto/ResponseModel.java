package com.example.texnoeraspringproject.model.dto;


import lombok.Getter;


@Getter
public class ResponseModel {
    String message;

    public ResponseModel(String message) {
        this.message = message;
    }
}
