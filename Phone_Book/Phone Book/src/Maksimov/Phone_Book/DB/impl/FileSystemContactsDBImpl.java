package Maksimov.Phone_Book.DB.impl;

import Maksimov.Phone_Book.DB.ContactsDB;
import Maksimov.Phone_Book.Model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSystemContactsDBImpl implements ContactsDB {

    private static final File FILE = new File("data");

    public FileSystemContactsDBImpl() {
    }

    @Override
    public void saveContact(Contacts contacts) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(FILE)))) {
            writer.println(contacts);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact() {
    }

    @Override
    public List<Contacts> showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
