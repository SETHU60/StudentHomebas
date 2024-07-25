package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressId;
import za.ac.cput.domain.Document;
import za.ac.cput.factory.AddressFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private static final String BASE_URL = "http://localhost:8080/StudentHomeBas/Address";
    static Address address1;
    static Address address2;
    static Address address3;

    @BeforeEach
    void setUp() {
        address1 = AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        address2 = AddressFactory.buildAddress("30 Willow Street", "Hazeldone", "Cape Town", "5099");
        address3 =AddressFactory.buildAddress("Ny 6 No 106", "Guguletu", "Cape Town", "7750");
    }

    @Test
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(url, address1, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Address saved:");
        System.out.println(postResponse.getBody());
    }

    @Test
    void read() {
        AddressId addressId = new AddressId(address1.getStreet(), address1.getPostalCode());
        String url = BASE_URL + "/read/" + addressId;
        ResponseEntity<Address> response = testRestTemplate.getForEntity(url, Address.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getStreet(), address1.getStreet());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        String url = BASE_URL + "/update";
        Address newAddress = new Address.AddressBuilder().copy(address1).setSuburb("Observatory").buildAddress();
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(url, newAddress, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(newAddress.getPostalCode(), postResponse.getBody().getPostalCode());
        System.out.println(postResponse.getBody());
    }

    @Test
    void delete() {
        AddressId addressId = new AddressId(address1.getStreet(), address1.getPostalCode());
        String url = BASE_URL + "/delete/" + addressId;
        testRestTemplate.delete(url);
        System.out.println("Address Deleted successfully");
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("All Addresses:");
        System.out.println(response.getBody());
    }
}