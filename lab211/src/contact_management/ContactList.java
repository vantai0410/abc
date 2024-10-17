package contact_management;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    private List<Contact> contacts = new ArrayList<>();

    public boolean addContact(Contact contact) {
        contacts.add(contact);
        return true;
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found");
        } else {
            System.out.println("ID    Name                 First Name      Last Name       Group      Address         Phone");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public boolean deleteContact(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    public boolean isValidPhone(String phone) {
        String phoneFormat = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4} x\\d{4}|\\d{3}-\\d{3}-\\d{4} ext\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3} \\d{3} \\d{4})$";
        return phone.matches(phoneFormat);
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
