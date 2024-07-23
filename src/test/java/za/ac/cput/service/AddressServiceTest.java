package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressId;
import za.ac.cput.domain.Document;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.AddressFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    void save() {
        System.out.println("========================================SAVE================================================");
        Address savedAddress = service.save(address1);
        assertNotNull(savedAddress);
        System.out.println(savedAddress);
    }

    @Test
    @Order(2)
    void read() {
        AddressId addressId = new AddressId(address1.getStreet(), address1.getPostalCode());
        Address readAddress = service.read(addressId);
        assertNotNull(readAddress);
        System.out.println(readAddress);
    }

    @Test
    @Order(3)
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
    @Order(4)
    void deleteById() {
        AddressId addressId = new AddressId(address1.getStreet(), address1.getPostalCode());
        boolean deleted = service.deleteById(addressId);
        assertTrue(deleted);
        System.out.println("Address deleted");
    }

    @Test
    @Order(5)
    void getall() {
        List<Address> addressList = service.getall();
        assertNotNull(addressList);
        System.out.println(addressList);
    }
}