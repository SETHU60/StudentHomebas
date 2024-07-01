package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    private Admin admin1;
    private Admin admin2;
    private Admin admin3;

    @BeforeEach
    void setUp() {
        Address address = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        Contact contact = ContactFactory.createContact("123456789", "leago@example.com", address);

        admin1 = AdminFactory.buildAdmin(567, "Boitumelo", "Michael", "Modise",
                "Female", LocalDate.of(1990, 5, 15), "password123", contact);

        admin2 = AdminFactory.buildAdmin(6578, "", "", "Moloi", "Female",
                LocalDate.of(1995, 12, 5), "password456", contact);

        admin3 = admin1;
    }

    @Test
    void checkIfNotNull() {
        assertNotNull(admin1);
        System.out.println(admin1);
    }

    @Test
    void equalityTest() {
        assertNotEquals(admin1, admin2);
        System.out.println("Not equal");
    }

    @Test
    void identityTest() {
        assertSame(admin1, admin3);
        System.out.println("IDENTICAL");
    }

    @Test
    void checkIfNull() {
        assertNull(admin2);
        System.out.println(admin2);
    }
}
