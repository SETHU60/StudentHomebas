package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.DocumentFactory;
import za.ac.cput.factory.StudentFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/student";
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    void setUp() {
        byte[] file1 = new byte[0];
        byte[] file2 = new byte[0];
        byte[] file3 = new byte[0];

        Document document1 = DocumentFactory.buildDocument(1L, "Student1Doc.pdf", file1, LocalDateTime.of(LocalDate.of(2024, 03, 24), LocalTime.of(14, 22)));
        Document document2 = DocumentFactory.buildDocument(2L, "Student2Doc.pdf", file2, LocalDateTime.of(LocalDate.of(2024, 04, 11), LocalTime.of(11, 14)));
        Document document3 = DocumentFactory.buildDocument(3L, "Student3Doc.pdf", file2, LocalDateTime.of(LocalDate.of(2024, 05, 19), LocalTime.of(22, 00)));

        List<Document> studentDocs1 = new ArrayList<>();
        studentDocs1.add(document1);

        List<Document> studentDocs2 = new ArrayList<>();
        studentDocs2.add(document2);

        List<Document> studentDocs3 = new ArrayList<>();
        studentDocs3.add(document3);

        Address address1 = AddressFactory.buildAddress("10 First Street", "City1", "Cape Town", "1000");
        Address address2 = AddressFactory.buildAddress("20 Second Street", "City2", "Cape Town", "2000");
        Address address3 = AddressFactory.buildAddress("30 Third Street", "City3", "Cape Town", "3000");

        Contact contact1 = new Contact.Builder().setAddress(address1).setEmail("student1@example.com").setPhoneNumber("123456789").build();
        Contact contact2 = new Contact.Builder().setAddress(address2).setEmail("student2@example.com").setPhoneNumber("987654321").build();
        Contact contact3 = new Contact.Builder().setAddress(address3).setEmail("student3@example.com").setPhoneNumber("456789123").build();

        AcademicDetails academicDetails1 = new AcademicDetails.Builder().setAcademicDetailsID("1").setInstituteName("CPUT").setYearOfStudy(3).setProgramOfStudy("DICT").build();
        AcademicDetails academicDetails2 = new AcademicDetails.Builder().setAcademicDetailsID("2").setInstituteName("UCT").setYearOfStudy(2).setProgramOfStudy("Software Engineering").build();
        AcademicDetails academicDetails3 = new AcademicDetails.Builder().setAcademicDetailsID("3").setInstituteName("UWC").setYearOfStudy(1).setProgramOfStudy("Information Systems").build();

        student1 = StudentFactory.buildStudent(1L, "John", "Doe", "Male", LocalDate.of(2000, 1, 1), "Password1", academicDetails1, contact1, studentDocs1);
        student2 = StudentFactory.buildStudent(2L, "Jane", "Smith", "Female", LocalDate.of(2001, 2, 2), "Password2", academicDetails2, contact2, studentDocs2);
        student3 = StudentFactory.buildStudent(3L, "Jack", "Johnson", "Male", LocalDate.of(2002, 3, 3), "Password3", academicDetails3, contact3, studentDocs3);
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/save";
        ResponseEntity<Student> response1 = restTemplate.postForEntity(url, student1, Student.class);
        assertNotNull(response1.getBody());
        System.out.println("Saved Student: " + response1.getBody());

        ResponseEntity<Student> response2 = restTemplate.postForEntity(url, student2, Student.class);
        assertNotNull(response2.getBody());
        System.out.println("Saved Student: " + response2.getBody());

        ResponseEntity<Student> response3 = restTemplate.postForEntity(url, student3, Student.class);
        assertNotNull(response3.getBody());
        System.out.println("Saved Student: " + response3.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + student1.getUserId();
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        assertNotNull(response.getBody());
        assertEquals(student1.getUserId(), response.getBody().getUserId());
        System.out.println("Read Student: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Student updatedStudent = new Student.StudentBuilder()
                .copy(student2)
                .setPassword("newPassword123")
                .build();
        ResponseEntity<Student> response = restTemplate.postForEntity(url, updatedStudent, Student.class);
        assertNotNull(response.getBody());
        assertEquals(student2.getUserId(), response.getBody().getUserId());
        System.out.println("Updated Student: " + response.getBody());
    }

    @Test
    @Order(4)
    void delete() {
        String url = BASE_URL + "/delete/" + student3.getUserId();
        restTemplate.delete(url);
        System.out.println("Deleted Student: " + student3);
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        assertNotNull(response.getBody());
        System.out.println("Students found: " + response.getBody());
    }
}
