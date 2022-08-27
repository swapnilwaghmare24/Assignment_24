package com.bridgelabz.addressbook;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contact> contactList = new LinkedList<>();

    Scanner sc = new Scanner(System.in);

    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter first name");
        String firstName = sc.next();
        contact.setFirstName(firstName);
        System.out.println("Enter last name");
        String lastName = sc.next();
        contact.setLastName(lastName);
        System.out.println("Enter address");
        String address = sc.next();
        contact.setAddress(address);
        System.out.println("Enter your city");
        String city = sc.next();
        contact.setCity(city);
        System.out.println("Enter your state");
        String state = sc.next();
        contact.setState(state);
        System.out.println("Enter zip");
        String zip = sc.next();
        contact.setZip(zip);
        System.out.println("Enter phone number");
        String phone = sc.next();
        contact.setPhone(phone);
        System.out.println("Enter email");
        String email = sc.next();
        contact.setEmail(email);
        contactList.add(contact);
        System.out.println(contactList);
    }

    public void editContacts() {
        boolean flag = false;
        String fName;
        System.out.println("Enter first name of contact to edit");
        fName = sc.next();
        for (Contact contact : contactList) {
            if (fName.equals(contact.getFirstName())) {
                contact.editContact();
                flag = true;
                System.out.println("contact with name " + fName + " edited in address book");
                System.out.println(contactList);
                break;
            }
        }
        if (flag == false) {
            System.out.println("contact not found");
        }
    }

    public void deleteContact() {
        System.out.println("Enter first name of contact which you want to delete");
        String fName = sc.next();
        for (Contact c : contactList) {
            if (fName.equals(c.getFirstName())) {
                contactList.remove(c);
                System.out.println("contact with name " + fName + " deleted from address book");
                System.out.println(contactList);
            }

        }
    }

    public boolean duplicateContact()
    {
        System.out.println("enter first name to check for duplicate contact");
        String fName = sc.next();
        for (Contact c : contactList)
        {
            if (fName.equalsIgnoreCase(c.getFirstName()))
            {
                return false;
            }

        }
        return true;
    }

        public void displayContact()
        {
            for (Contact c : contactList)
            {
                System.out.println(c);
            }
        }

}

