package za.ac.cput.service.PropertyListingApplicationService;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.propertyListingApplication.PropertyListingApplicationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PropertyListingApplicationServiceTest {

    @Autowired
    PropertyListingApplicationService service;

    PropertyListingApplication propertyApp1, propertyApp2;
    Address address1, address2;
    byte[] photo;
    Document document1;
    List<Document> photoList;
    Name landLordName1, landLordName2;
    Contact contact1, contact2;
    Landlord landlordA, landlordB;
    Property property1, property2;
    LocalDate appliedDate, appliedDate2;

    @BeforeEach
    void setUp() {

        photo = new byte[0];
        document1 =DocumentFactory.buildDocument(79L
                ,"ID",photo
                , LocalDateTime.of(LocalDate.of(2024,03,24)
                        , LocalTime.of(14,22)));
        photoList = new ArrayList<>();
        photoList.add(document1);

        address1 = AddressFactory.buildAddress("47 Lucy Drive","Parow"
                ,"Cape Town","7490");

        address2 = AddressFactory.buildAddress("11 Olympia Crescent"
                ,"Delville Park","George","6529");


        landLordName1 = new Name.NameBuilder().setFirstName("Mihlai").setLastName("Tukuza").build();
        landLordName2 = new Name.NameBuilder().setFirstName("Emily").setLastName("Thorne").build();

        contact1 = ContactFactory.createContact("0786549009", "mizot24@gmail.com", address1);
        contact2 = ContactFactory.createContact("0715468926", "emily6410@gmail.com", address2);

        landlordA = LandlordFactory.buildLandlord(45673L,"Mihlai"
                ,"Tukuza", 3, "Male"
                , LocalDate.of(1986,8,13), "hsfs2637!"
                ,contact1, photoList);

        landlordB = LandlordFactory.buildLandlord(45696L,"Emily",
                "Thorne", 5, "Female"
                , LocalDate.of(1994,3,16), "Emily145Tho!!"
                ,contact2, photoList);

        property1 = PropertyFactory.buildProperty("132","1st Village"
                , 3, 3750.50, "47 Lucy Drive","Parow"
                ,"Cape Town","7490",landlordA, photoList);

        property2 = PropertyFactory.buildProperty("133","More Takers"
                , 2, 4000.50, "11 Olympia Crescent"
                ,"Delville Park","George","6529",landlordB, photoList);


        appliedDate = LocalDate.of(2019, 6, 4);
        appliedDate2 = LocalDate.of(2022, 1, 29);

        propertyApp1 = PropertyListingApplicationFactory.propertyApp(appliedDate
                , Application.Status.Accepted.toString(), property1, landlordA, property1.getPrice()
                , property1.getAddress().getSuburb());

        propertyApp2 = PropertyListingApplicationFactory.propertyApp(appliedDate2
                , Application.Status.Pending.toString(), property2, landlordB, property2.getPrice()
                , property2.getAddress().getSuburb());

    }

    @Test
    @Order(1)
    void save() {
        PropertyListingApplication savedApp1 = service.save(propertyApp1);
        PropertyListingApplication savedApp2 = service.save(propertyApp2);
        assertNotNull(savedApp1);
        assertNotNull(savedApp2);
    }

    @Test
    @Order(2)
    void read() {
        PropertyListingApplication readApp1 = service.read(propertyApp1.getAppNo());
        PropertyListingApplication readApp2 = service.read(propertyApp2.getAppNo());
        assertNotNull(readApp1);
        assertNotNull(readApp2);
    }

    @Test
    @Order(3)
    void update() {
        PropertyListingApplication statusUpdate = new PropertyListingApplication
                .Builder().copy(propertyApp2).setStatus(Application.Status.Accepted.toString())
                .build();
        PropertyListingApplication update = service.update(statusUpdate);
        assertNotNull(update);
    }

    @Test
    @Order(4)
    void deleteById() {
        boolean delete = service.deleteById(propertyApp1.getAppNo());
        assertTrue(delete);
    }

    @Test
    @Order(5)
    void getAll() {
        List<PropertyListingApplication> allRecords = service.getAll();
        System.out.println(allRecords.toString());
        assertNotNull(allRecords);
    }
}