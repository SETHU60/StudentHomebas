package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Document;
import za.ac.cput.domain.Landlord;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.DocumentFactory;
import za.ac.cput.factory.LandlordFactory;
import za.ac.cput.repository.LandlordRepository;
import za.ac.cput.service.landlordService.LandlordService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LandlordControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final String BASE_URL = "http://localhost:8080/StudentHomeBas/landlord";

    @Autowired
    private LandlordRepository landlordRepository;
    static private Landlord landlord1;
    static private Landlord landlord2;
    static List<Document> documentList = new ArrayList<>();
    static List<Document> documentList2 = new ArrayList<>();
    private static byte[] file;

    @BeforeAll
    static void setUp() {
        file=new byte[0];
        Document document1 = DocumentFactory.buildDocument(1L,"MikeSeptemeberCopyOfID",file, LocalDateTime.of(LocalDate.of(2024,03,24), LocalTime.of(14,22)));
        Document document2 = DocumentFactory.buildDocument(2L, "MpumziMbulaDocument.pdf", file, LocalDateTime.of(LocalDate.of(2024, 03, 24), LocalTime.of(14, 22)));
        System.out.println(document1);
        documentList.add(document1);
        documentList2.add(document2);

        Address address1= AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        Contact contact = ContactFactory.createContact("0786549009", "mikeseptember@gmail.com", address1);
        landlord1 = LandlordFactory.buildLandlordWithMiddleName( "Mike", "Matic", "September", "Male", LocalDate.of(1986,8,13), 3, "Mike130886",contact,documentList);

        Address address2 = AddressFactory.buildAddress("19 Lower Street", "Mowbray", "Cape Town", "5100");
        Contact contact2 = ContactFactory.createContact("0786548790", "nickseptember@gmail.com", address2);
        landlord2 = LandlordFactory.buildLandlordWithMiddleName("Nick", "Leon", "September", "Male", LocalDate.of(1986,8,14), 2, "Nick130886",contact2,documentList2);


    }

    @Test
    @Order(1)
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Landlord> postResponse = testRestTemplate.postForEntity(url, landlord1, Landlord.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Landlord saved:");
        System.out.println(postResponse.getBody());

        ResponseEntity<Landlord> postResponse2 = testRestTemplate.postForEntity(url, landlord2, Landlord.class);
        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());
        System.out.println("Landlord2 saved:");
        System.out.println(postResponse2.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + landlord1.getUserId();
        System.out.println(url);
        ResponseEntity<Landlord> response = testRestTemplate.getForEntity(url, Landlord.class);

        assertNotNull(response);

        assertNotNull(response.getBody());
        assertEquals(response.getBody().getUserId(), landlord1.getUserId());
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Landlord newLandlord = new Landlord.LandlordBuilder().copy(landlord1).setPassword("Matic45678").buildLandlord();
        ResponseEntity<Landlord> postResponse = testRestTemplate.postForEntity(url, newLandlord, Landlord.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(newLandlord.getUserId(), postResponse.getBody().getUserId());
        System.out.println(postResponse.getBody());
    }

    @Test
    @Order(4)
    void delete() {
        String url = BASE_URL + "/delete/" + landlord1.getUserId();
        testRestTemplate.delete(url);
        System.out.println("Landlord Deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("All Landlords:");
        System.out.println(response.getBody());
    }
    @Test
    @Order(6)
    void loginSuccess() {
        // Assuming landlord1 has been saved and has valid credentials
        String url = BASE_URL + "/login/" + landlord1.getContact().getEmail() + "/" + "Mike130886";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login successful", response.getBody());
        System.out.println("Login successful for landlord1");
    }

    @Test
    @Order(7)
    void loginInvalidEmail() {
        String url = BASE_URL + "/login/invalidEmail@gmail.com/Mike130886";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid email or password", response.getBody());
        System.out.println("Login failed for invalid email");
    }

    @Test
    @Order(8)
    void loginInvalidPassword() {
        String url = BASE_URL + "/login/" + landlord1.getContact().getEmail() + "/wrongPassword";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid email or password", response.getBody());
        System.out.println("Login failed for incorrect password");
    }

    @Test
    @Order(9)
    void loginNullEmail() {
        String url = BASE_URL + "/login//Mike130886"; // Passing an empty email
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("email is null"));
        System.out.println("Login failed for null email");
    }

}