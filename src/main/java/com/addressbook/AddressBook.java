package com.addressbook;

public class AddressBook {
    private ContactPerson contact;

    public ContactPerson getContact() {
        return contact;
    }

    public void addContact(ContactPerson contact) {
        this.contact = contact;
    }
}

