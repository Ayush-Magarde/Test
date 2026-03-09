package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook();
        try (Scanner scanner = new Scanner(System.in)) {
            String firstName = promptNonEmpty(scanner, "Enter First Name: ");
            String lastName = promptNonEmpty(scanner, "Enter Last Name: ");
            String address = promptNonEmpty(scanner, "Enter Address: ");
            String city = promptNonEmpty(scanner, "Enter City: ");
            String state = promptNonEmpty(scanner, "Enter State: ");
            String zip = promptNonEmpty(scanner, "Enter Zip: ");
            String phoneNumber = promptNonEmpty(scanner, "Enter Phone Number: ");
            String email = promptNonEmpty(scanner, "Enter Email: ");

            ContactPerson contact = new ContactPerson(
                    firstName,
                    lastName,
                    address,
                    city,
                    state,
                    zip,
                    phoneNumber,
                    email
            );

            addressBook.addContact(contact);
            System.out.println("Contact added successfully.");
            System.out.println(addressBook.getContact());
        }
    }

    private static String promptNonEmpty(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            if (value != null && !value.trim().isEmpty()) {
                return value.trim();
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}

