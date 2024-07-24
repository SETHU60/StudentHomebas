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

    private Contact contact;

    @BeforeEach
    void a_setUp() {
        Address address = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        contact = ContactFactory.createContact("123456789", "leago@example.com", address);
    }

    @Test
    @Order(1)
    void save() {
        Contact saved = contactService.save(contact);
        assertNotNull(saved);
        System.out.println("Saved contact: " + saved);
    }

    @Test
    @Order(2)
    void read() {
        Contact read = contactService.read(contact.getEmail());
        assertNotNull(read);
        System.out.println("Read contact: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Contact newContact = new Contact.Builder()
                .copy(contact)
                .setPhoneNumber("0873636972")
                .build();
        Contact updated = contactService.update(newContact);
        assertNotNull(updated);
        assertEquals("0873636972", updated.getPhoneNumber());
        System.out.println("Updated contact: " + updated);
    }

    @Test
    @Order(4)
    void deleteById() {
        boolean deleted = contactService.deleteById(contact.getEmail());
        assertTrue(deleted);
        System.out.println("Deleted contact with email: " + contact.getEmail());
    }

    @Test
    @Order(5)
    void getAll() {
        List<Contact> contacts = contactService.getAll();
        assertNotNull(contacts);
        System.out.println("All contacts: " + contacts);
    }
}