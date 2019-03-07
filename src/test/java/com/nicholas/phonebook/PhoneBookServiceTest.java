package com.nicholas.phonebook;

import com.nicholas.phonebook.model.EntryType;
import com.nicholas.phonebook.model.PhoneBookType;
import com.nicholas.phonebook.service.PhoneBookService;
import com.nicholas.phonebook.service.PhoneBookServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PhoneBookServiceTest {

	private PhoneBookService phoneBookService = Mockito.mock(PhoneBookServiceImpl.class);

	@Test
	public void testAddEntry() {
		//arrange
		final EntryType entryType = new EntryType("test", "1234567891");
		when(phoneBookService.addEntry(entryType)).thenReturn(entryType);
		//act
		EntryType result = phoneBookService.addEntry(entryType);

		//assert
		Assert.assertTrue(result.getName().equals("test"));
		Assert.assertTrue(result.getPhoneNumber().equals("1234567891"));
	}

	@Test
	public void testGetEntryByName() {
		//arrange
		final List<EntryType> entries = new ArrayList<>();
		entries.add(new EntryType("test", "1234567891"));
		final PhoneBookType phoneBook = new PhoneBookType("Test phone book", entries);
		when(phoneBookService.getAllEntries("t")).thenReturn(phoneBook);
		//act
		PhoneBookType result = phoneBookService.getAllEntries("t");

		//assert
		Assert.assertTrue(result.getName().equals("Test phone book"));
		Assert.assertNotNull(result.getEntries());
		Assert.assertTrue(result.getEntries().size() == 1);
		Assert.assertTrue(result.getEntries().get(0).getName().equals("test"));
		Assert.assertTrue(result.getEntries().get(0).getPhoneNumber().equals("1234567891"));
	}

}
