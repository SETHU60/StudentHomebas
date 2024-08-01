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
    private Admin admin4;

    @BeforeEach
    void setUp() {
        Address address1 = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        Address address2 = AddressFactory.buildAddress("15 Upper Road", "Gardens", "Cape Town", "8001");
        Address address3 = AddressFactory.buildAddress("22 Main Street", "Claremont", "Cape Town", "7700");

        Contact contact1 = ContactFactory.createContact("083456789", "leago@gmail.com", address1);
        Contact contact2 = ContactFactory.createContact("076654321", "rachel@gmail.com", address2);
        Contact contact3 = ContactFactory.createContact("065666777", "john@gmail.com", address3);

        admin1 = AdminFactory.buildAdmin(567, "Leago", "Michael", "Modise",
                "Female", LocalDate.of(1990, 5, 15), "leagod123", contact1);

        admin2 = AdminFactory.buildAdmin(6578, "", "", "Moloi", "Female",
                LocalDate.of(1995, 12, 5), "femeo156", contact2);

        admin3 = AdminFactory.buildAdmin(3664, "John", "Bonele", "Mona", "Male",
                LocalDate.of(1982, 2, 13), "Mona@1982", contact3);


        admin4 = admin1;
    }

    @Test
    void checkIfNotNull() {
        assertNotNull(admin1);
        assertNotNull(admin3);
        System.out.println(admin1);
        System.out.println(admin3);
    }

    @Test
    void equalityTest() {
        assertNotEquals(admin1, admin2);
        System.out.println("Not equal");
    }

    @Test
    void identityTest() {
        assertSame(admin1, admin4);
        System.out.println("IDENTICAL");
    }

    @Test
    void checkIfNull() {
        assertNull(admin2);
        System.out.println(admin2);
    }
}
