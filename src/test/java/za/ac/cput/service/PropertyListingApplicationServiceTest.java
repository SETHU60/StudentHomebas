package za.ac.cput.service;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 July 2024
 * */

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.DocumentFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class PropertyListingApplicationServiceTest {

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
        document1 = DocumentFactory.buildDocument(79L
                ,"ID",photo
                , LocalDateTime.of(LocalDate.of(2024,03,24)
                        , LocalTime.of(14,22)));
        photoList = new ArrayList<>();
        photoList.add(document1);

        address1 = new Address.AddressBuilder().setStreet("47 Lucy Drive")
                .setSuburb("Parow").setCity("Cape Town").setPostalCode("7490").buildAddress();
        address2 = new Address.AddressBuilder().setStreet("11 Olympia Crescent")
                .setSuburb("Delville Park").setCity("George").setPostalCode("6529").buildAddress();

        landLordName1 = new Name.NameBuilder().setFirstName("Mihlai").setLastName("Tukuza").build();
        landLordName2 = new Name.NameBuilder().setFirstName("Emily").setLastName("Thorne").build();

        contact1 = ContactFactory.createContact("0786549009", "mizot24@gmail.com", address1);
        contact2 = ContactFactory.createContact("0715468926", "emily6410@gmail.com", address2);

        landlordA = new Landlord.LandlordBuilder().setName(landLordName1).setUserId(45673L)
                .setDateOfBirth(LocalDate.of(1986,8,13)).setNumOfPropertiesOwned(3)
                .setGender("Male").setPassword("hsfs2637!").setDocuments(photoList)
                .setContact(contact1).buildLandlord();

        landlordB = new Landlord.LandlordBuilder().setName(landLordName2).setUserId(45696L)
                .setDateOfBirth(LocalDate.of(1994,3,16)).setNumOfPropertiesOwned(5)
                .setGender("Female").setPassword("Emily145Tho!!").setDocuments(photoList)
                .setContact(contact2).buildLandlord();

        property1 =new Property.Builder().setPropertyID("132")
                .setPropertyName("1st Village").setAddress(address1).setLandlord(landlordA)
                .setPictures(photoList).setNumberOfRooms(3).build();

        property2 = new Property.Builder().setPropertyID("133")
                .setPropertyName("More Takers").setAddress(address1).setLandlord(landlordB)
                .setPictures(photoList).setNumberOfRooms(2).build();

        appliedDate = LocalDate.of(2019, 6, 4);
        appliedDate2 = LocalDate.of(2022, 1, 29);


        propertyApp1 = new PropertyListingApplication.Builder()
                .setDate(appliedDate).setStatus(Application.Status.Accepted)
                .setProperty(property1).setLandlord(landlordA).setRentalPrice(2989.99)
                .setLocation(property1.getAddress().getSuburb()).setAddress(address1).build();

        propertyApp2 = new PropertyListingApplication.Builder()
                .setDate(appliedDate2).setStatus(Application.Status.Pending)
                .setProperty(property2).setLandlord(landlordB).setRentalPrice(2989.99)
                .setLocation(property2.getAddress().getSuburb()).setAddress(address2).build();
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
                .Builder().copy(propertyApp2).setStatus(Application.Status.Accepted)
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