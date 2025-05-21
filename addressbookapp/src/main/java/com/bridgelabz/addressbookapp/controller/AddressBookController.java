package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        AddressBookData data = new AddressBookData(1, "Aaditya", "Pune");
        ResponseDTO response = new ResponseDTO("Get All Contacts Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        AddressBookData data = new AddressBookData(id, "Aaditya", "Pune");
        ResponseDTO response = new ResponseDTO("Get Contact by ID Success", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody Map<String, String> payload) {
        AddressBookData data = new AddressBookData(1, payload.get("name"), payload.get("address"));
        ResponseDTO response = new ResponseDTO("Created Contact Successfully", data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,
                                                     @RequestBody Map<String, String> payload) {
        AddressBookData data = new AddressBookData(id, payload.get("name"), payload.get("address"));
        ResponseDTO response = new ResponseDTO("Updated Contact Successfully", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        ResponseDTO response = new ResponseDTO("Deleted Contact with ID: " + id, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
