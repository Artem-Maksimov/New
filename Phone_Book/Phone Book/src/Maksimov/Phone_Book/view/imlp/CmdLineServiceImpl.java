package Maksimov.Phone_Book.view.imlp;

import Maksimov.Phone_Book.Services.ContactsService;
import Maksimov.Phone_Book.Utilities.ValidationUtilities;
import Maksimov.Phone_Book.view.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {


    private final ContactsService contactsService;
    private final BufferedReader br;

    public CmdLineServiceImpl(ContactsService contactsService) {
        this.contactsService = contactsService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void runMenu() throws IOException {
        boolean exit = true;
        while (exit) {
            showMenu();
            String line = br.readLine();
            switch (line) {
                case "1": {
                    createContact();
                    break;
                }
                case "2": {
                    deleteContact();
                    break;
                }
                case "3": {
                    showContacts();
                    break;
                }
                case "4": {
                    editContact();
                    break;
                }
                case "0": {
                    exit = false;
                    break;
                }
                default:
                    System.out.println("Repeat");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Create Contacts");
        System.out.println("2. Delete Contacts");
        System.out.println("3. Show Contacts");
        System.out.println("4. Edit Contacts");
        System.out.println("0. Exit");
    }

    private void createContact() throws IOException {

        System.out.println("Enter name");
        String name = br.readLine();

        System.out.println("Enter phone");
        int phone = readInt();
        contactsService.createContact(name, phone);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter contact name for remove");
        String name = br.readLine();

        contactsService.deleteContact(name);
    }

    private void showContacts() {
        contactsService.showContacts();
    }

    private void editContact() throws IOException {

        System.out.println("Enter name of modified contact");
        String name = br.readLine();

        System.out.println("Enter new name");
        String newName = br.readLine();

        System.out.println("Enter new phone");
        int newPhone = readInt();

        this.contactsService.editContact(name, newName, newPhone);
    }

    private int readInt() throws IOException {
        try {
            String line = br.readLine();
            return ValidationUtilities.checkNumber(line);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong Input! You must input number");
            return readInt();
        }
    }
}