package com.nicholas.phonebook.service;

import com.nicholas.phonebook.model.EntryType;
import com.nicholas.phonebook.model.PhoneBookType;
import com.nicholas.phonebook.repository.EntryRepository;
import com.nicholas.phonebook.translator.EntryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {


    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private EntryConverter entryConverter;


    /**
     * Retrieve all entries
     *
     * optional retrieve all entries by name
     *
     * @param name
     * @return PhoneBookType
     */
    @Override
    public PhoneBookType getAllEntries(String name) {
        if (name != null) {
            return new PhoneBookType("Personal Phone book", searchEntries(name));
        }
        return new PhoneBookType("Personal Phone book", entryConverter.convertEntities(entryRepository.findAll()));
    }

    /**
     * Add phone-book entry
     *
     * @param entryType
     * @return EntryType
     */
    @Override
    public EntryType addEntry(EntryType entryType) {
        return entryConverter.convertEntity(entryRepository.save(entryConverter.convertType(entryType)));
    }


    /**
     *
     * Get all entries which contains name
     *
     *
     * @param name
     * @return
     */
    private List<EntryType> searchEntries(String name) {
        return entryConverter.convertEntities(entryRepository.findByNameContainingIgnoreCase(name));
    }

}
