package com.nicholas.phonebook.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "phoneBook")
public class PhoneBookType extends AbstractType{
    private String name;
    private List<EntryType> entries;

    public PhoneBookType() {
    }

    public PhoneBookType(String name) {
        this.name = name;
    }

    public PhoneBookType(String name, List<EntryType> entries) {
        this.name = name;
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntryType> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryType> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "PhoneBookType{" +
                "name='" + name + '\'' +
                ", entries=" + entries +
                '}';
    }
}
