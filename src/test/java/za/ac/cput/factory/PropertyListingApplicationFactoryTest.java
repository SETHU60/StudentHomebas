//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Address;
//import za.ac.cput.domain.Application;
//import za.ac.cput.domain.PropertyListingApplication;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PropertyListingApplicationFactoryTest {
//
//    Address address1 = new Address.AddressBuilder().setStreetNumber(47).setStreetName("Lucy Drive")
//            .setSuburb("Parow").setCity("Cape Town").buildAddress();
//
//    Address address2 = new Address.AddressBuilder().setStreetNumber(11).setStreetName("Olympia Crescent")
//            .setSuburb("Delville Park").setCity("George").buildAddress();
//    LocalDate appliedDate = LocalDate.of(2019,6,04);
//    LocalDate appliedDate2 = LocalDate.of(2022,1,29);
//
//    PropertyListingApplication propertyApp1 = new PropertyListingApplication.Builder()
//            .setAppNo("655").setDate(appliedDate).setStatus(Application.Status.Accepted)
//            .setPropertyID("263").setLandlordID("148257").setRentalPrice(2989.99)
//            .setLocation("Parow").setAddress(address1).build();
//
//    PropertyListingApplication propertyApp2 = new PropertyListingApplication.Builder()
//            .setAppNo("988").setDate(appliedDate2).setStatus(Application.Status.Rejected)
//            .setPropertyID("449").setLandlordID("148257").setRentalPrice(2989.99)
//            .setLocation("Delville Park").setAddress(address2).build();
//
//    PropertyListingApplication propertyApp3 = propertyApp1;
//    @Test
//    void createPropertyListingApplication(){
//        assertNotNull(propertyApp1);
//        System.out.println("Applied Successfully:");
//        System.out.println(propertyApp1);
//    }
//
//    @Test
//    void propertyEqualityFailTest(){
//        System.out.println(propertyApp3);
//        System.out.println("------------------------------");
//        System.out.println(propertyApp2);
//        assertEquals(propertyApp3, propertyApp2);
//
//    }
//
//    @Test
//    void propertyEqualityPassTest(){
//        assertEquals(propertyApp1, propertyApp3);
//        System.out.println("Equality Test Passed");
//    }
//
//}