package com.addressbook;

import java.util.Scanner;

public class AddressBook {
    private ContactPerson contact;

    public ContactPerson getContact() {
        return contact;
    }

    public void addContact(ContactPerson contact) {
        this.contact = contact;
    }

    public boolean editContact(String firstName, String lastName, Scanner scanner) {
        if (contact == null) {
            System.out.println("No contact exists in address book.");
            return false;
        }

        if (!matchesName(contact, firstName, lastName)) {
            System.out.println("Contact not found.");
            return false;
        }

        contact.setFirstName(promptUpdate(scanner, "Enter First Name", contact.getFirstName()));
        contact.setLastName(promptUpdate(scanner, "Enter Last Name", contact.getLastName()));
        contact.setAddress(promptUpdate(scanner, "Enter Address", contact.getAddress()));
        contact.setCity(promptUpdate(scanner, "Enter City", contact.getCity()));
        contact.setState(promptUpdate(scanner, "Enter State", contact.getState()));
        contact.setZip(promptUpdate(scanner, "Enter Zip", contact.getZip()));
        contact.setPhoneNumber(promptUpdate(scanner, "Enter Phone Number", contact.getPhoneNumber()));
        contact.setEmail(promptUpdate(scanner, "Enter Email", contact.getEmail()));

        System.out.println("Contact updated successfully.");
        return true;
    }

    public boolean deleteContact(String firstName, String lastName) {
        if (contact == null) {
            System.out.println("No contact exists in address book.");
            return false;
        }

        if (!matchesName(contact, firstName, lastName)) {
            System.out.println("Contact not found.");
            return false;
        }

        contact = null;
        System.out.println("Contact deleted successfully.");
        return true;
    }

    private static boolean matchesName(ContactPerson contact, String firstName, String lastName) {
        return safeEqualsIgnoreCase(contact.getFirstName(), firstName)
                && safeEqualsIgnoreCase(contact.getLastName(), lastName);
    }

    private static boolean safeEqualsIgnoreCase(String a, String b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equalsIgnoreCase(b);
    }

    private static String promptUpdate(Scanner scanner, String label, String currentValue) {
        System.out.print(label + " (leave blank to keep '" + currentValue + "'): ");
        String input = scanner.nextLine();
        if (input == null) {
            return currentValue;
        }
        String trimmed = input.trim();
        return trimmed.isEmpty() ? currentValue : trimmed;
    }
}

