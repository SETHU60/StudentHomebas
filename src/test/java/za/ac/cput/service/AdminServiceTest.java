package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.ContactFactory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
@Rollback
class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    private Admin admin1;
    private Admin admin2;

    @BeforeEach
    void setUp() {
        Address address = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        Contact contact1 = ContactFactory.createContact("123456789", "keitudimpe@gmail.com", address);
        Contact contact2 = ContactFactory.createContact("0879873342", "racheldimpe@example.com", address);

        admin1 = AdminFactory.buildAdmin(567, "Boitumelo", "Michael", "Masemola",
                "Female", LocalDate.of(1990, 5, 15), "password123", contact1);
        admin2 = AdminFactory.buildAdmin(56867, "Leago", "Tidi", "Modise",
                "Female", LocalDate.of(1990, 5, 15), "password123", contact2);
    }

    @Test
    @Order(1)
    void save() {
        Admin saved1 = adminService.save(admin1);
        Admin saved2 = adminService.save(admin2);
        assertNotNull(saved1);
        assertNotNull(saved2);
        System.out.println("Saved admin: " + saved1);
        System.out.println("Saved admin: " + saved2);
    }

    @Test
    @Order(2)
    void read() {
        Admin saved1 = adminService.save(admin1);
        Admin saved2 = adminService.save(admin2);

        Admin read1 = adminService.read(saved1.getUserId());
        Admin read2 = adminService.read(saved2.getUserId());
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read admin: " + read1);
        System.out.println("Read admin: " + read2);
    }

    @Test
    @Order(3)
    void update() {
        Admin saved1 = adminService.save(admin1);

        Admin updatedAdmin = new Admin.Builder()
                .copy(saved1)
                .setPassword("newPassword123")
                .build();
        Admin updated = adminService.update(updatedAdmin);
        assertNotNull(updated);
        assertEquals("newPassword123", updated.getPassword());
        System.out.println("Updated admin: " + updated);

        Admin verifyUpdate = adminService.read(updated.getUserId());
        assertNotNull(verifyUpdate);
        assertEquals("newPassword123", verifyUpdate.getPassword());
    }

    @Test
    @Order(4)
    void deleteById() {

        Long adminId = admin1.getUserId();
        boolean deleted = adminService.deleteById(adminId);
        assertTrue(deleted);
        Admin deletedAdmin = adminService.read(adminId);
        assertNull(deletedAdmin);
        System.out.println("Deleted admin with ID: " + adminId);
    }

    @Test
    @Order(5)
    void getAll() {
        adminService.save(admin1);
        adminService.save(admin2);

        List<Admin> all = adminService.getAll();
        assertNotNull(all);
        assertFalse(all.isEmpty());
        System.out.println("All admins: " + all);
    }
}
