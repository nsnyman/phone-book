package com.nicholas.phonebook.controller;

import com.nicholas.phonebook.model.EntryType;
import com.nicholas.phonebook.model.PhoneBookType;
import com.nicholas.phonebook.model.ResponseType;
import com.nicholas.phonebook.service.PhoneBookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "v1/phone-book")
public class PhoneBookController {


    @Autowired
    private PhoneBookService phoneBookService;

    /**
     * Get all phone-book entries
     * <p>
     * if name param supplied then it does a search and returns a list of entries that contain the same letters of the name
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/entries",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get all phone book entries", response = PhoneBookType.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved phone book entries",
                    response = PhoneBookType.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request", response = ResponseType.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ResponseType.class)})
    public ResponseEntity<PhoneBookType> getAllPhoneNumberEntries(
            @RequestParam(defaultValue = "", required = false) String name) {
        return new ResponseEntity<>(phoneBookService.getAllEntries(name), HttpStatus.OK);
    }


    /**
     * Creates a phone-book entry
     *
     * @param entryType
     * @return
     */
    @RequestMapping(value = "/entries",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Add phone book entry", response = EntryType.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created phone book entry", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad request", response = ResponseType.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ResponseType.class)})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntryType> getAllPhoneNumberEntries(@Valid @RequestBody EntryType entryType) {
        return new ResponseEntity<>(phoneBookService.addEntry(entryType), HttpStatus.CREATED);
    }

}
