package Maksimov.Phone_Book;

import Maksimov.Phone_Book.DB.ContactsDB;
import Maksimov.Phone_Book.DB.impl.DBContactsDB;
import Maksimov.Phone_Book.Services.ContactsService;
import Maksimov.Phone_Book.Services.impl.FSContactsServiceImpl;
import Maksimov.Phone_Book.view.CmdLineService;
import Maksimov.Phone_Book.view.imlp.CmdLineServiceImpl;

import java.io.IOException;

public class Application {


    public static void main(String[] args) throws IOException {

        ContactsDB contactsDB = new DBContactsDB();

        ContactsService contactsService = new FSContactsServiceImpl(contactsDB);

        CmdLineService cmd = new CmdLineServiceImpl(contactsService);

        cmd.runMenu();
    }
}
