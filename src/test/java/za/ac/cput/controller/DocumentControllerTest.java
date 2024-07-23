package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Document;
import za.ac.cput.factory.DocumentFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
//
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DocumentControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private static final String BASE_URL = "http://localhost:8080/StudentHomeBas/document";
    private static Document document1;
    private static Document document2;
    private static byte[] file;
    private static byte[] file2;


    @BeforeAll
    static void setUp() {

        System.out.println("========================================SETUP================================================");
        file = new byte[0];
        file2 = new byte[0];

        document1 = DocumentFactory.buildDocument(1L, "MpumziMbulaDocument.pdf", file, LocalDateTime.of(LocalDate.of(2024, 03, 24), LocalTime.of(14, 22)));
        System.out.println(document1);
        document2 = DocumentFactory.buildDocument(2L, "AcademicRecord", file2, LocalDateTime.of(LocalDate.of(2024, 04, 11), LocalTime.of(11, 14)));
        System.out.println(document2);

    }

    @Test
    @Order(1)
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Document> postResponse1 = testRestTemplate.postForEntity(url, document1, Document.class);
        assertNotNull(postResponse1);
        assertNotNull(postResponse1.getBody());
        System.out.println("Saved Document:");
        System.out.println(postResponse1.getBody());

        ResponseEntity<Document> postResponse2 = testRestTemplate.postForEntity(url, document2, Document.class);
        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());
        System.out.println("Saved Document:");
        System.out.println(postResponse2.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + document1.getDocumentId();
        ResponseEntity<Document> response = testRestTemplate.getForEntity(url, Document.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getDocumentId(), document1.getDocumentId());
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Document newDocument = new Document.Builder().copy(document1).setDateTimeUploaded(LocalDateTime.now()).build();
        ResponseEntity<Document> postResponse = testRestTemplate.postForEntity(url, newDocument, Document.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(newDocument.getDocumentId(), postResponse.getBody().getDocumentId());
        System.out.println(postResponse.getBody());
    }

    @Test
    @Order(4)
    void delete() {
        String url = BASE_URL + "/delete/" + document2.getDocumentId();
        testRestTemplate.delete(url);
        System.out.println("Document Deleted successfully");
    }

    @Test
    @Order(5)
    void getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("All Documents:");
        System.out.println(response.getBody());
    }
}