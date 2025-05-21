package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        List<AddressBookData> dataList = addressBookService.getAllContacts();
        ResponseDTO response = new ResponseDTO("Get All Contacts Success", dataList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        AddressBookData data = addressBookService.getContactById(id);
        ResponseDTO response = new ResponseDTO("Get Contact by ID Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody Map<String, String> payload) {
        int newId = addressBookService.getAllContacts().size() + 1;
        AddressBookData data = new AddressBookData(newId, payload.get("name"), payload.get("address"));
        AddressBookData savedData = addressBookService.createContact(data);
        ResponseDTO response = new ResponseDTO("Created Contact Successfully", savedData);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,
                                                     @RequestBody Map<String, String> payload) {
        AddressBookData newData = new AddressBookData(id, payload.get("name"), payload.get("address"));
        AddressBookData updatedData = addressBookService.updateContact(id, newData);
        ResponseDTO response = new ResponseDTO("Updated Contact Successfully", updatedData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        addressBookService.deleteContact(id);
        ResponseDTO response = new ResponseDTO("Deleted Contact with ID: " + id, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
