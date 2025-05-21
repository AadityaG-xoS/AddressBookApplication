package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private List<AddressBookData> contactList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAllContacts() {
        return contactList;
    }

    @Override
    public AddressBookData getContactById(int id) {
        return contactList.stream()
                .filter(data -> data.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData createContact(AddressBookData data) {
        contactList.add(data);
        return data;
    }

    @Override
    public AddressBookData updateContact(int id, AddressBookData newData) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getId() == id) {
                AddressBookData updated = new AddressBookData(id, newData.getName(), newData.getAddress());
                contactList.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    @Override
    public void deleteContact(int id) {
        contactList.removeIf(data -> data.getId() == id);
    }
}
