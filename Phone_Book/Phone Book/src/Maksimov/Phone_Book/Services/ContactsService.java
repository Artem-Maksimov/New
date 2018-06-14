package Maksimov.Phone_Book.Services;

import Maksimov.Phone_Book.Model.Contacts;

import javafx.collections.List;

public interface ContactsService {

	void createContact(Contacts contact);

	void deleteContact(long id);

	List<Contacts> showContacts();

	void editContact(Contacts contact);

}