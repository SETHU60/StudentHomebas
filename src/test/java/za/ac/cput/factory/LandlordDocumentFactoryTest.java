package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Landlord;
import za.ac.cput.domain.LandlordDocument;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LandlordDocumentFactoryTest {

    @Test
    void checkIfTestFails() {
        Address address2 = new Address.AddressBuilder()
                .setStreetNumber(13)
                .setStreetName("Willow Street")
                .setCity("Cape Town")
                .buildAddress();

        Contact contact2 = ContactFactory.createContact("", "invalid_email", address2);

        assertNull(contact2);
        System.out.println(contact2);
    }

    @Test
    void checkIfNotNull() {
        Address address1 = new Address.AddressBuilder()
                .setStreetNumber(9)
                .setStreetName("Lower Street")
                .setSuburb("Mowbray")
                .setCity("Cape Town")
                .buildAddress();

        Contact contact1 = ContactFactory.createContact("123456789", "leago@example.com", address1);

        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void equalityTest() {
        Address address1 = new Address.AddressBuilder()
                .setStreetNumber(9)
                .setStreetName("Lower Street")
                .setSuburb("Mowbray")
                .setCity("Cape Town")
                .buildAddress();

        Address address2 = new Address.AddressBuilder()
                .setStreetNumber(13)
                .setStreetName("Willow Street")
                .setCity("Cape Town")
                .buildAddress();

        Contact contact1 = ContactFactory.createContact("123456789", "test@example.com", address1);
        Contact contact2 = ContactFactory.createContact("", "invalid_email", address2);

        assertNotEquals(contact1, contact2);
        System.out.println("NOT EQUAL");
    }

    @Test
    void identityTest() {
        Address address1 = new Address.AddressBuilder()
                .setStreetNumber(9)
                .setStreetName("Lower Street")
                .setSuburb("Mowbray")
                .setCity("Cape Town")
                .buildAddress();

        Contact contact1 = ContactFactory.createContact("123456789", "test@example.com", address1);
        Contact contact3 = contact1;

        assertSame(contact1, contact3);
    }

    @Test
    void identityTestForLandlordDocument() {
        Address address= new Address.AddressBuilder().setStreetNumber(789).setStreetName("Village Avenue").setSuburb( "District 6").setCity("Cape Town").buildAddress();
        Landlord landlord = new Landlord.LandlordBuilder()
                .setFirstName("Charlie")
                .setLastName("Brown")
                .setGender("Male")
                .setDateOfBirth(LocalDate.of(1985, 10, 25))
                .setPassword("pass456") .buildLandlord();
Contact contact= ContactFactory.createContact("111222333", "charlie@example.com",address);
        LocalDateTime dateTimeUploaded = LocalDateTime.now();

        LandlordDocument document1 = LandlordDocumentFactory.buildLandlordDocument("doc1", landlord, dateTimeUploaded);
        LandlordDocument document3 = document1;

        assertSame(document1, document3);
        System.out.println("IDENTICAL");
    }
}
