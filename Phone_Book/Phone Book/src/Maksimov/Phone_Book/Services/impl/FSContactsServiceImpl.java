package Maksimov.Phone_Book.Services.impl;

import Maksimov.Phone_Book.DB.ContactsDB;
import Maksimov.Phone_Book.Model.Contacts;
import Maksimov.Phone_Book.Services.ContactsService;

import javafx.collections.FXCollections;
import javafx.collections.List;

public class FSContactsServiceImpl implements ContactsService {


    private final ContactsDB contactsDB;

    List<Contacts> list = FXCollections.ArrayList();
    private java.lang.Object contactList;

    public FSContactsServiceImpl(ContactsDB contactsDB){
            this.contactsDB = contactsDB;
    }

    public void createContact(Contacts contact) {
        ContactsDB.saveContact(contact);
    }

    public void deleteContact(long id) {
        ContactsDB.deleteContact(id);
    }

    public List<Contacts> showContacts() {
        return ContactsDB.showContacts();

    }

        public void editContact(Contacts contact){
            ContactsDB.editContact(contact);
    }

    public void editContact(String name, String newName, int newPhone) {
		Contacts contact = this.contactList.get(name);
		contact.setName(newName);
		contact.setPhone(newPhone);
    }

}