package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertyListingApplicationFactoryTest {

    PropertyListingApplication propertyApp1, propertyApp2, propertyApp3;
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

    property1 =new Property.Builder()
            .setPropertyName("1st Village").setAddress(address1).setLandlord(landlordA)
            .setPictures(photoList).setNumberOfRooms(3).setPrice(2989.99).build();

    property2 = new Property.Builder()
            .setPropertyName("More Takers").setAddress(address1).setLandlord(landlordB)
            .setPictures(photoList).setNumberOfRooms(2).setPrice(3455.90).build();

    appliedDate = LocalDate.of(2019, 6, 4);
    appliedDate2 = LocalDate.of(2022, 1, 29);

    propertyApp1 = PropertyListingApplicationFactory.propertyApp(appliedDate
            , Application.Status.Accepted.toString(), property1, landlordA, property1.getPrice()
            , property1.getAddress().getSuburb(), address1);

    propertyApp2 = PropertyListingApplicationFactory.propertyApp(appliedDate2
            , Application.Status.Pending.toString(), property2, landlordB, property2.getPrice()
            , property2.getAddress().getSuburb(), address2);

    propertyApp3 = propertyApp1;
    }

    @Test
    void createPropertyListingApplication(){
        assertNotNull(propertyApp1);
        System.out.println("Applied Successfully:");
        System.out.println(propertyApp1);
    }

    @Test
    void propertyEqualityFailTest(){
        System.out.println(propertyApp3);
        System.out.println("------------------------------");
        System.out.println(propertyApp2);
        assertEquals(propertyApp3, propertyApp2);

    }

    @Test
    void propertyEqualityPassTest(){
        assertEquals(propertyApp1, propertyApp3);
        System.out.println("Equality Test Passed");
    }

}