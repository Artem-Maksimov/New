package Maksimov.Phone_Book.view.controllers;


import Maksimov.Phone_Book.DB.impl.DBContactsDB;
import Maksimov.Phone_Book.Model.Contacts;
import Maksimov.Phone_Book.Services.ContactsService;
import Maksimov.Phone_Book.Services.impl.FSContactsServiceImpl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

	private ContactsService contactsService;

	public MainController() {
		this.contactsService = new FSContactsServiceImpl(new DBContactsDB());
	}

	@FXML
	private TextField inputName;

	@FXML
	private TextField inputPhone;

	@FXML
	private Button createButton;

	@FXML
	private TableView<Contacts> table;

	@FXML
	private TableColumn<Contacts, String> nameColumn;

	@FXML
	private TableColumn<Contacts, Integer> phoneColumn;

	public void createContact(){
		String name = inputName.getText();
		String phone = inputPhone.getText();
		contactsService.createContact(name, new Integer(phone));
	}

	@FXML
	public void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

		table.setItems(contactsService.showContacts());
	}
}
