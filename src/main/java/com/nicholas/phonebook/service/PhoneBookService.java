package com.nicholas.phonebook.service;

import com.nicholas.phonebook.model.EntryType;
import com.nicholas.phonebook.model.PhoneBookType;

public interface PhoneBookService {
    PhoneBookType getAllEntries(String name);
    EntryType addEntry(EntryType entryType);
}
