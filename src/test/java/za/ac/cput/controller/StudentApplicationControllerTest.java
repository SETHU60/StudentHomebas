
package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentApplicationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    String BASE_URL = "http://localhost:8080/StudentHomeBas/StudentApplication";

    Address address1, address2;
    byte[] photo;
    Document document1;
    List<Document> photoList;
    Name landLordName1, landLordName2, studentName1, studentName2;
    Contact contact1, contact2;
    Landlord landlordA, landlordB;
    Property property1, property2;
    Student student1, student2;
    LocalDate dateApplied;
    AcademicDetails records1, records2;
    StudentApplication studentApplication1, studentApplication2;


    @BeforeEach
    void setUp() {
        dateApplied = LocalDate.of(2023,8,23);

        photo = new byte[0];
        document1 =DocumentFactory.buildDocument(79L,"ID",photo
                , LocalDateTime.of(LocalDate.of(2024,03,24)
                        , LocalTime.of(14,22)));
        photoList = new ArrayList<>();
        photoList.add(document1);

        address1 = AddressFactory.buildAddress("47 Lucy Drive","Parow"
                ,"Cape Town","7490");

        address2 = AddressFactory.buildAddress("11 Olympia Crescent"
                ,"Delville Park","George","6529");


        studentName1 = new Name.NameBuilder().setFirstName("Mila").setLastName("Juices").build();
        studentName2 = new Name.NameBuilder().setFirstName("Sandy").setLastName("Downing").build();

        contact1 = ContactFactory.createContact("0786549009", "mizot24@gmail.com", address1);
        contact2 = ContactFactory.createContact("0715468926", "emily6410@gmail.com", address2);

        records1 = AcademicDetailsFactory.buildAcademicDetails("234"
                ,"UWC","Computer Sciences",2023);
        records2 = AcademicDetailsFactory.buildAcademicDetails("1689"
                ,"CPUT","Information Technology",2021);

        landlordA = LandlordFactory.buildLandlord(45673L,"Mihlai"
                ,"Tukuza", 3, "Male"
                , LocalDate.of(1986,8,13), "hsfs2637!"
                ,contact1, photoList);

        landlordB = LandlordFactory.buildLandlord(45696L,"Emily",
                "Thorne", 5, "Female"
                , LocalDate.of(1994,3,16), "Emily145Tho!!"
                ,contact2, photoList);

        property1 = PropertyFactory.buildProperty("1st Village", 3, 3750.50
                , "47 Lucy Drive", "Parow", "Cape Town", "7490", landlordA, photoList);

        property2 = PropertyFactory.buildProperty("More Takers",2,4000.50
                ,"11 Olympia Crescent","Delville Park","George","6529",landlordB,photoList);

        student1 = StudentFactory.buildStudent(377L, "Mila","Juices"
                ,"Male", LocalDate.of(2000,11,4), "kjrgj6523./"
                , records1,contact1, photoList);

        student2 = StudentFactory.buildStudent(378L, "Sandy","Downing"
                ,"Female", LocalDate.of(2003,9,25), "kgtugkjd123!"
                , records2,contact2, photoList);


        studentApplication1 = StudentApplicationFactory.studentApplication(LocalDate.now(),
                Application.Status.Pending.toString(), student1, property1, property1.getPrice());

        studentApplication2 = StudentApplicationFactory.studentApplication(dateApplied,
                Application.Status.Accepted.toString(), student2, property2, property2.getPrice());
    }

    @Test
    @Order(1)
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<StudentApplication> saveApp1 = restTemplate.postForEntity(url, studentApplication1, StudentApplication.class);
        ResponseEntity <StudentApplication> saveApp2 = restTemplate.postForEntity(url, studentApplication2, StudentApplication.class);
        assertNotNull(saveApp1);
        assertNotNull(saveApp2);
        System.out.println("Application saved" + saveApp1.getBody());
        System.out.println("----------------------------------------------------");
        System.out.println("Application saved" + saveApp2.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + studentApplication1.getAppNo();
        ResponseEntity <StudentApplication> readApp = restTemplate.getForEntity(url, StudentApplication.class);
        assertNotNull(readApp);
        System.out.println("received Application: " + readApp.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        StudentApplication statusUpdate = new StudentApplication.Builder().copy(studentApplication1)
                .setStatus(Application.Status.Accepted.toString()).build();
        ResponseEntity <StudentApplication> update = restTemplate.postForEntity(url, statusUpdate, StudentApplication.class);
        assertNotNull(update);
        System.out.println("Application updated: " + update.getBody());
    }

    @Test
    @Order(4)
    void deleteById() {
        String url = BASE_URL + "/read/" + studentApplication2.getAppNo();
        restTemplate.delete(url);
        System.out.println("Application deleted successfully:" + studentApplication2.getAppNo());
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        System.out.println("Received Applications:");
        System.out.println(response.getBody());
    }
}

