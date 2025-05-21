package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAllContacts();
    AddressBookData getContactById(int id);
    AddressBookData createContact(AddressBookData data);
    AddressBookData updateContact(int id, AddressBookData data);
    void deleteContact(int id);
}
