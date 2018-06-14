package Maksimov.Phone_Book.DB.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Maksimov.Phone_Book.DB.ContactsDB;
import Maksimov.Phone_Book.Model.Contacts;

public class DBContactsDB implements ContactsDB {

	private static final String DB_URL = "jdbc:h2:tcp://localhost/~/Program";
	private static final String USER = "PB";
	private static final String PASSWORD = "";

	public DBContactsDB() {
		try {
			Class.forName("org.h2.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Can't connect to DB");
		}
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement st = connection.createStatement()) {
			st.execute("CREATE TABLE IF NOT  EXISTS CLIENT(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), PHONE INT);");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveContact(Contacts contacts) {
		try (Connection connection = DriverManager
				.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENT(NAME, PHONE) VALUES(?, ?);")) {

			st.setString(1, contacts.getName());
			st.setInt(2, contacts.getPhone());

			st.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeContact() {

	}

	@Override
	public List<Contacts> showAll() {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement st = connection.createStatement()) {
			List<Contacts> clients = new ArrayList<>();
			try (ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT;")) {
				while (resultSet.next()) {
					String name = resultSet.getString("name");
					int phone = resultSet.getInt("phone");
					clients.add(new Contacts(name, phone));
				}
			}
			return clients;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}