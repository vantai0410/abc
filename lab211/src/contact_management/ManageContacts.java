package contact_management;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageContacts {
    private static List<String> menu = Arrays.asList(
            "CONTACT MANAGEMENT SYSTEM",
            "1. Add a Contact",
            "2. Display all Contacts",
            "3. Delete a Contact",
            "4. Exit"
    );

    private static Scanner sc = new Scanner(System.in);
    private static int currentId = 4;

    public static int getChoices() {
        menu.forEach(System.out::println);
        System.out.print("Please enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > 4) {
            System.out.println("Invalid choice, please enter again.");
            return -1;
        }
        return choice;
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();  // Sử dụng ContactList để quản lý liên hệ
        contactList.addContact(new Contact(1, "Iker", "Casillas", "Star", "Spain", "1234567890"));
        contactList.addContact(new Contact(2, "John", "Terry", "Star", "England", "1234567890"));
        contactList.addContact(new Contact(3, "Raul", "Gonzalez", "Star", "Spain", "1234567890"));

        int choice;
        do {
            choice = getChoices();
            switch (choice) {
                case 1:
                    addContact(contactList);
                    break;
                case 2:
                    contactList.displayContacts();
                    break;
                case 3:
                    deleteContact(contactList);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Unexpected error.");
            }
        } while (choice != 4);
    }

    public static void addContact(ContactList contactList) {
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter group: ");
        String group = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        String phone;
        do {
            System.out.println("Enter Phone (Valid formats are:");
            System.out.println(" - 1234567890");
            System.out.println(" - 123-456-7890");
            System.out.println(" - 123-456-7890 x1234");
            System.out.println(" - 123-456-7890 ext1234");
            System.out.println(" - 123.456.7890");
            System.out.println(" - 123 456 7890");
            System.out.print("Enter Phone: ");
            phone = sc.nextLine();

            if (!contactList.isValidPhone(phone)) {
                System.out.println("Invalid phone number format. Please try again.");
            }
        } while (!contactList.isValidPhone(phone));

        Contact contact = new Contact(currentId, firstName, lastName, group, address, phone);
        contactList.addContact(contact);
        currentId++;
        System.out.println("Contact added successfully.");
    }

    public static void deleteContact(ContactList contactList) {
        System.out.print("Enter contact id: ");
        int contactId = sc.nextInt();
        if (contactList.deleteContact(contactId)) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
