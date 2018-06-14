package Maksimov.Phone_Book.DB;

import java.util.List;

import Maksimov.Phone_Book.Model.Contacts;

public interface ContactsDB {

	static void saveContact (Contacts contact);

	static void deleteContact (long id);

	List<Contacts> selectAllContact();

	static void editContact (Contacts contact);

    static void showContacts (Contacts contact);

}
