package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookService {
    Map<String,AddressBook> addressBookMap=new HashMap<>();
    Scanner sc= new Scanner(System.in);

    public void addAddressBook()
    {
        System.out.println("Enter address book name");
        String addressBookName=sc.next();
        if(addressBookMap.get(addressBookName)!=null)
        {
            System.out.println("Address book already exist");
        }
        addressBookMap.put(addressBookName,new AddressBook());
    }

    public AddressBook findAddressBook(String adBookName)
    {
        for (Map.Entry<String,AddressBook> entry:addressBookMap.entrySet()) {
            if(adBookName.equalsIgnoreCase(entry.getKey()))
            {
               return entry.getValue();
            }

        }
        return null;
    }

    public void addContact()
    {
        Contact c= new Contact();
        System.out.println("Enter address book name in which you want to add contact");
        String adName=sc.next();
        AddressBook adBook=findAddressBook(adName);

        if(adBook==null)
        {
            System.out.println("invalid address book");
            return;
        }

        if (adBook.duplicateContact()==false)
        {
            System.out.println("contact already present");
        }
        else
        {
            adBook.addContact();
        }
    }


    public void displayContact()
    {
        System.out.println("Enter address book name");
        String adName=sc.next();
        AddressBook adBook=findAddressBook(adName);
        if(adBook==null)
        {
            System.out.println("Address book not present");
        }
        adBook.displayContact();
    }

    public void editAddressBook()
    {
        System.out.println("Enter address book name");
        String adName=sc.next();
        AddressBook adBook=findAddressBook(adName);
        if(adBook==null)
        {
            System.out.println("Address book not present");
        }
        adBook.editContacts();
    }

    public void deleteAddressBook()
    {
        System.out.println("Enter address book name");
        String adName=sc.next();
        AddressBook adBook=findAddressBook(adName);
        if(adBook==null)
        {
            System.out.println("Address book not present");
        }
        adBook.deleteContact();
    }

    public void viewByCityOrState(){
        System.out.print(" Enter to view by city or state(city/state): ");
        String viewChoice = sc.next();

        System.out.print(" Enter the location: ");
        String viewLocation = sc.next();

        viewCityState(viewLocation, viewChoice);
    }
    public void viewCityState(String location, String choice) {
        for (AddressBook adBook : addressBookMap.values()) {
            adBook.contactList.stream().filter(contact -> {

                        if (choice.equalsIgnoreCase("city"))
                            return contact.getCity().equalsIgnoreCase(location);
                        else
                            return contact.getState().equalsIgnoreCase(location);
                    })
                    .forEach(contact -> System.out.println(contact));
        }

    }
    public void countByContacts(){
        System.out.print(" Enter to count by city or state(city/state): ");
        String countChoice = sc.next();

        System.out.print(" Enter the location: ");
        String countLocation = sc.next();

        countContact(countLocation, countChoice);
    }
    public void countContact(String location, String choice) {

        int finalCount = 0;

        for (AddressBook addBook : addressBookMap.values()) {

            finalCount += addBook.contactList.stream()
                    .filter(contact -> {
                        if (choice.equalsIgnoreCase("city"))
                            return contact.getCity().equalsIgnoreCase(location);
                        else
                            return contact.getState().equalsIgnoreCase(location);
                    })
                    .count();
        }

        System.out.println(" Total count: " + finalCount);
    }
    public void sortByName()
    {
        for (AddressBook adBook : addressBookMap.values()) {
            adBook.contactList.stream().sorted((n1,n2)->n1.getFirstName().compareTo(n2.getFirstName())).forEach(System.out::println);
        }
    }

}
