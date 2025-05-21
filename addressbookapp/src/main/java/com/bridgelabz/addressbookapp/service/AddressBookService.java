package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> addressBookList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<AddressBookData> getAllContacts() {
        return addressBookList;
    }

    @Override
    public AddressBookData getContactById(int id) {
        Optional<AddressBookData> contact = addressBookList.stream()
                .filter(data -> data.getId() == id)
                .findFirst();
        return contact.orElse(null);
    }

    @Override
    public AddressBookData createContact(AddressBookData contact) {
        contact.setId(idCounter++);
        addressBookList.add(contact);
        return contact;
    }

    @Override
    public AddressBookData updateContact(int id, AddressBookData updatedContact) {
        AddressBookData existingContact = getContactById(id);
        if (existingContact != null) {
            existingContact.setName(updatedContact.getName());
            existingContact.setAddress(updatedContact.getAddress());
            return existingContact;
        }
        return null;
    }

    @Override
    public void deleteContact(int id) {
        addressBookList.removeIf(contact -> contact.getId() == id);
    }
}
