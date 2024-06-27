package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @BeforeEach
    void setup() {
        Address address = new Address();
        contact1 = ContactFactory.createContact("123456789", "leago@example.com", address);
        contact2 = ContactFactory.createContact("", "invalid_email", address);
        contact3 = contact1;
    }

    @Test
    void checkIfNull() {
        assertNull(contact2);
        System.out.println(contact2);
    }

    @Test
    void checkIfNotNull() {
        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void equalityTest() {
        assertNotEquals(contact1, contact2);
        System.out.println("NOT EQUAL");
    }

    @Test
    void identityTest() {
        assertSame(contact1, contact3);
        System.out.println("IDENTICAL");
    }
}
