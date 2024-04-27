package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void checkIfTestFailsWithInvalidEmail() {
        Address address = new Address.AddressBuilder()
                .setStreetNumber(123)
                .setStreetName("Mandela Street")
                .setCity("Johannesburg")
                .buildAddress();

        Contact contact = ContactFactory.createContact("0123456789", "invalid_email", address);
        Admin admin = AdminFactory.buildAdmin("T123", "Boitumelo", "Modise", "Female",
                LocalDate.of(1990, 5, 15), "password123", contact);

        assertNull(admin);
        System.out.println(admin);
    }

    @Test
    void checkIfNotNull() {
        Address address = new Address.AddressBuilder()
                .setStreetNumber(123)
                .setStreetName("Mandela Street")
                .setCity("Johannesburg")
                .buildAddress();


        Contact contact = ContactFactory.createContact("0123456789", "valid_email@example.com", address);
        Admin admin = AdminFactory.buildAdmin("T123", "Boitumelo", "Modise", "Female",
                LocalDate.of(1990, 5, 15), "password123", contact);
        assertNotNull(admin);
        System.out.println(admin);
    }

    @Test
    void equalityTest() {
        Address address1 = new Address.AddressBuilder()
                .setStreetNumber(789)
                .setStreetName("Madiba Street")
                .setCity("Soweto")
                .buildAddress();

        Address address2 = new Address.AddressBuilder()
                .setStreetNumber(321)
                .setStreetName("Freedom Street")
                .setCity("Pretoria")
                .buildAddress();

        Contact contact1 = ContactFactory.createContact("4561237890", "test@example.com", address1);
        Contact contact2 = ContactFactory.createContact("7894561230", "example@test.com", address2);

        Admin admin1 = AdminFactory.buildAdmin("T456", "Kabelo", "Mokoena", "Male",
                LocalDate.of(1988, 9, 15), "password123", contact1);
        Admin admin2 = AdminFactory.buildAdmin("T789", "Naledi", "Moloi", "Female",
                LocalDate.of(1995, 12, 5), "password456", contact2);

        assertNotEquals(admin1, admin2);
        System.out.println("Not equal");
    }

    @Test
    void identityTest() {
        Address address = new Address.AddressBuilder()
                .setStreetNumber(321)
                .setStreetName("Freedom Street")
                .setCity("Pretoria")
                .buildAddress();

        Contact contact = ContactFactory.createContact("7894561230", "example@test.com", address);
        Admin admin1 = AdminFactory.buildAdmin("T789", "Naledi", "Moloi", "Female",
                LocalDate.of(1995, 12, 5), "password123", contact);
        Admin admin2 = admin1;
        assertSame(admin1, admin2);
        System.out.println("IDENTICAL");
    }
}
