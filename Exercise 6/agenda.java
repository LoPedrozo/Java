import java.util.ArrayList;

public class agenda {
    public static void printlnn(String a) {
        System.out.println(a);
    }

    private ArrayList<contact> contacts;

    public agenda() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String number) {
        contacts.add(new contact(name, number));
        printlnn("Contact added successfully.");
    }

    public void removeContact(String name, String number) {
        boolean removed = contacts.removeIf(contact ->
                contact.getName().equalsIgnoreCase(name) && contact.getNumber().equals(number)
        );

        if (removed) {
            printlnn("Contact deleted successfully.");
        } else {
            printlnn("Contact not found. No changes made.");
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        printlnn("Searching for contact...");

        for (contact contacto : contacts) {
            if (contacto.getName().equalsIgnoreCase(name)) {
                System.out.println(contacto);
                found = true;
            }
        }

        if (!found) {
            printlnn("Contact does not exist.");
        }
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            printlnn("Contact list is empty.");
        } else {
            for (contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

