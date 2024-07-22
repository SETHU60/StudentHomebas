package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Document;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.AddressFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceTest {
    @Autowired
    private AddressService service;
    Address address1;
    Address address2;
    Address address3;

    @BeforeEach
    void setUp() {
        address1 = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        address2 = AddressFactory.buildAddress("30 Willow Street", "", "Cape Town", "5099");
        address3 = address1;
    }

    @Test
    void save() {
        System.out.println("========================================SAVE================================================");
        Address savedAddress = service.save(address1);
        assertNotNull(savedAddress);
        System.out.println(savedAddress);
    }

    @Test
    void read() {
        Address readAddress = service.read(address1.getStreet() + address1.getPostalCode());
        assertNotNull(readAddress);
        System.out.println(readAddress);
    }

    @Test
    void update() {
        System.out.println("========================================SAVE================================================");
        Address updatedAddress = new Address.AddressBuilder().copy(address1)
                .setSuburb("Observatory")
                .buildAddress();
        Address savedAddress = service.save(updatedAddress);
        assertNotNull(savedAddress);
        System.out.println(savedAddress);
    }

    @Test
    void deleteById() {
        boolean deleted = service.deleteById(address1.getStreet() + address1.getPostalCode());
        assertTrue(deleted);
        System.out.println("Address deleted");
    }

    @Test
    void getall() {
        List<Address> addressList = service.getall();
        assertNotNull(addressList);
        System.out.println(addressList);
    }
}