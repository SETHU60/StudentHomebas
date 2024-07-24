package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.factory.AcademicDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AcademicDetailsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    final String BASE_URL = "http://localhost:8080/StudentHomeBas/AcademicDetails";

    private AcademicDetails testAcademicDetails1;
    private AcademicDetails testAcademicDetails2;

    @BeforeEach
    void setUp() {
        testAcademicDetails1 = AcademicDetailsFactory.buildAcademicDetails("ACD01", "Cape Peninsula University of Technology", "Diploma in ICT", 3);
        testAcademicDetails2 = AcademicDetailsFactory.buildAcademicDetails("ACD02", "Cape Peninsula University of Technology", "Diploma in ICT", 4);

    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<AcademicDetails> response = restTemplate.postForEntity(url, testAcademicDetails1, AcademicDetails.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Saved Academic details: " + response.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + testAcademicDetails1.getAcademicDetailsID();

        ResponseEntity<AcademicDetails> response = restTemplate.getForEntity(url, AcademicDetails.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            assertNotNull(response.getBody());
            AcademicDetails academicDetails = response.getBody();

            System.out.println("Read Academic Details: " + academicDetails);
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            System.out.println("Academic Details not found.");
        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            System.out.println("Bad request. Invalid ID provided.");
        } else {
            System.out.println("Unexpected error: " + response.getStatusCode());
        }
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        AcademicDetails update = new AcademicDetails.Builder().copy(testAcademicDetails2)
                .setYearOfStudy(5)
                .build();

        ResponseEntity<AcademicDetails> response= restTemplate.postForEntity(url, update, AcademicDetails.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            AcademicDetails academicDetails = response.getBody();
            System.out.println("Updated Academic Details: " + academicDetails);
            assertEquals(academicDetails.getAcademicDetailsID(), update.getAcademicDetailsID());
        }else{
            System.out.println("Error updating Academic Details.");
        }

    }

    @Test
    @Order(4)
    void delete() {
        String url = BASE_URL + "/delete/" + testAcademicDetails1.getAcademicDetailsID();
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getAll";


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        System.out.println("All Academic Details:");
        System.out.println(response);
        System.out.println(response.getBody());


    }
}