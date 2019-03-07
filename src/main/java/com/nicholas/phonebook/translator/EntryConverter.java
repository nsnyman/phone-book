package com.nicholas.phonebook.translator;

import com.nicholas.phonebook.entity.EntryEntity;
import com.nicholas.phonebook.model.EntryType;
import org.springframework.stereotype.Component;

@Component
public class EntryConverter implements Converter<EntryType, EntryEntity> {


    @Override
    public EntryEntity convertType(EntryType type) {
        EntryEntity entryEntity = null;
        if(type != null){
            entryEntity = new EntryEntity();
            entryEntity.setName(type.getName());
            entryEntity.setPhoneNumber(type.getPhoneNumber());
        }
        return entryEntity;
    }

    @Override
    public EntryType convertEntity(EntryEntity entity) {
        EntryType entryType = null;
        if(entity != null){
            entryType = new EntryType();
            entryType.setName(entity.getName());
            entryType.setPhoneNumber(entity.getPhoneNumber());
        }
        return entryType;
    }
}
