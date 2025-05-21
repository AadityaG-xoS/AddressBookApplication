package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @GetMapping("/")
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("GET All Contacts Success");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getContactById(@PathVariable("id") int id) {
        return ResponseEntity.ok("GET Contact with ID: " + id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContact(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok("POST Created Contact: " + payload.toString());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable("id") int id,
                                                @RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok("PUT Updated Contact ID " + id + " with: " + payload.toString());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") int id) {
        return ResponseEntity.ok("DELETE Removed Contact ID: " + id);
    }
}
