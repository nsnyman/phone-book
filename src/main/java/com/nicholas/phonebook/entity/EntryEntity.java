package com.nicholas.phonebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact",
        indexes = {
                @Index(name = "i_id", columnList = "id"),
                @Index(name = "i_name", columnList = "name"),
                @Index(name = "i_phone_number", columnList = "phoneNumber")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_phone_number", columnNames = "phoneNumber")
        })
public class EntryEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phoneNumber;


    public EntryEntity() {
    }

    public EntryEntity(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
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
}
