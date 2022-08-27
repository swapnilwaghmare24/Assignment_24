package com.bridgelabz.addressbookmain;

import com.bridgelabz.addressbook.AddressBookService;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to address book program");
        Scanner sc = new Scanner(System.in);
        AddressBookService addressBookService=new AddressBookService();
        boolean again=true;
        while(again) {
            System.out.println("enter 1-add contact \n 2-edit contact \n 3-delete contact \n 4-Add Address Book " +
                    "\n 5-Display contact \n 6-view by city or state " +
                    "\n 7-count contact person by city or state \n 8-sort by Name \n 9-sort by city");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    addressBookService.addContact();
                    break;
                case '2':
                    addressBookService.editAddressBook();
                    break;
                case '3':
                    addressBookService.deleteAddressBook();
                    break;
                case '4':
                    addressBookService.addAddressBook();
                    break;
                case '5':
                    addressBookService.displayContact();
                    break;
                case '6':
                    addressBookService.viewByCityOrState();
                    break;

                case '7':
                    addressBookService.countByContacts();
                    break;

                case '8':
                    addressBookService.sortByName();
                    break;

                case '9':
                    addressBookService.sortByCity();
                    break;

                default:
                    System.out.println("invalid choice");

            }
            System.out.println("do you wish to perform operations again then type y");
            char userChoice=sc.next().charAt(0);
            if(userChoice=='y'|| userChoice=='Y')
                again=true;
            else
                again=false;

        }
    }
}
