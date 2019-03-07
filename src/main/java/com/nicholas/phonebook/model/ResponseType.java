package com.nicholas.phonebook.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "response")
public class ResponseType {

    private int code;
    private String message;

    public ResponseType() {
    }

    public ResponseType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
