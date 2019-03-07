package com.nicholas.phonebook.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@JsonRootName(value = "entry")
public class EntryType extends AbstractType {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must contain only 10 digits")
    private String phoneNumber;


    public EntryType() {
    }

    public EntryType(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "EntryEntity{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
