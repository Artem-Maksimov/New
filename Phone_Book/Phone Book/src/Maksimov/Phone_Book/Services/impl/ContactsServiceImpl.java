package Maksimov.Phone_Book.Services.impl;

import Maksimov.Phone_Book.Model.Contacts;
import Maksimov.Phone_Book.Services.ContactsService;

import javafx.collections.FXCollections;
import javafx.collections.List;

public abstract class ContactsServiceImpl implements ContactsService {


    private final List<Contacts> contactList;
    private Contacts newContact;
    private int idContact;


    public ContactsServiceImpl() {
        this.contactList = FXCollections.ArrayList();
    }


    public void createContact(Contacts contact) {
        idContact++;
        contactList.put(idContact, new Contacts(idContact, newContact.getName(), newContact.getPhone()));


        public void deleteContact(long id) {
            contactList.remove(id);
        }


    public List<Contacts> showContact() {
        return contactList;
    }


        public void editContact(Contacts newContact){
            for (Contacts contact : contactList.values()) {
                if (contact.getId() == newContact.getId()){
                    newContact.setName();
                    contact.setPhone(newContact.getPhone());
                    return;
                }
            }
        }