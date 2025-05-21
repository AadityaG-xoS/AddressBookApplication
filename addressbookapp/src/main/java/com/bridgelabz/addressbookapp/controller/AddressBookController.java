package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        List<AddressBookData> data = addressBookService.getAllContacts();
        ResponseDTO response = new ResponseDTO("Get All Contacts Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        AddressBookData data = addressBookService.getContactById(id);
        if (data != null) {
            ResponseDTO response = new ResponseDTO("Get Contact by ID Success", data);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseDTO response = new ResponseDTO("Contact Not Found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody AddressBookData contact) {
        AddressBookData data = addressBookService.createContact(contact);
        ResponseDTO response = new ResponseDTO("Created Contact Successfully", data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id, @RequestBody AddressBookData contact) {
        AddressBookData data = addressBookService.updateContact(id, contact);
        if (data != null) {
            ResponseDTO response = new ResponseDTO("Updated Contact Successfully", data);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseDTO response = new ResponseDTO("Contact Not Found", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        addressBookService.deleteContact(id);
        ResponseDTO response = new ResponseDTO("Deleted Contact with ID: " + id, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
