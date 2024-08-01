package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {
    @Autowired
    private ContactService contactService;

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @BeforeEach
    void setUp() {
        Address address1 = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        Address address2 = AddressFactory.buildAddress("15 Upper Road", "Gardens", "Cape Town", "8001");
        Address address3 = AddressFactory.buildAddress("22 Main Street", "Claremont", "Cape Town", "7700");

        contact1 = ContactFactory.createContact("083456789", "leao@gmail.com", address1);
        contact2 = ContactFactory.createContact("076654321", "rahel@gmail.com", address2);
        contact3 = ContactFactory.createContact("065666777", "jon@gmail.com", address3);
    }

    @Test
    @Order(1)
    void save() {
        Contact saved1 = contactService.save(contact1);
        Contact saved2 = contactService.save(contact2);
        Contact saved3 = contactService.save(contact3);

        assertNotNull(saved1);
        assertNotNull(saved2);
        assertNotNull(saved3);

        System.out.println("Saved contact 1: " + saved1);
        System.out.println("Saved contact 2: " + saved2);
        System.out.println("Saved contact 3: " + saved3);
    }

    @Test
    @Order(2)
    void read() {
        Contact saved1 = contactService.save(contact1);
        Contact saved2 = contactService.save(contact2);
        Contact saved3 = contactService.save(contact3);

        Contact read1 = contactService.read(saved1.getEmail());
        Contact read2 = contactService.read(saved2.getEmail());
        Contact read3 = contactService.read(saved3.getEmail());

        assertNotNull(read1);
        assertNotNull(read2);
        assertNotNull(read3);

        System.out.println("Read contact 1: " + read1);
        System.out.println("Read contact 2: " + read2);
        System.out.println("Read contact 3: " + read3);
    }

    @Test
    @Order(3)
    void update() {
        Contact saved1 = contactService.save(contact1);

        Contact newContact1 = new Contact.Builder()
                .copy(saved1)
                .setPhoneNumber("0873636972")
                .build();
        Contact updated1 = contactService.update(newContact1);
        assertNotNull(updated1);
        assertEquals("0873636972", updated1.getPhoneNumber());

        System.out.println("Updated contact 1: " + updated1);
    }

    @Test
    @Order(4)
    void deleteById() {
        Contact saved1 = contactService.save(contact1);

        boolean deleted = contactService.deleteById(saved1.getEmail());
        assertTrue(deleted);

        Contact deletedContact = contactService.read(saved1.getEmail());
        assertNull(deletedContact);

        System.out.println("Deleted contact with email: " + saved1.getEmail());
    }

    @Test
    @Order(5)
    void getAll() {
        contactService.save(contact1);
        contactService.save(contact2);
        contactService.save(contact3);

        List<Contact> contacts = contactService.getAll();
        assertNotNull(contacts);
        assertFalse(contacts.isEmpty());

        System.out.println("All contacts: " + contacts);
    }
}
