//package za.ac.cput.factory;
//
//
//import za.ac.cput.domain.Address;
//import za.ac.cput.domain.Application;
//import za.ac.cput.domain.PropertyListingApplication;
//import za.ac.cput.util.ApplicationHelper;
//
//import java.time.LocalDate;
//
///*
// * Author : Sabelo Kama (219149364)
// * Date : 22 April 2024
// * */
//public class PropertyListingApplicationFactory {
//
//    public static PropertyListingApplication propertyApp(String appNo, LocalDate date,
//                                                         String status, String propertyID,
//                                                         String landlordID, double rentalPrice,
//                                                         String location, Address address){
//        if (ApplicationHelper.isNullOrEmpty(appNo) ||
//            ApplicationHelper.dateIsNull(date) ||
//            ApplicationHelper.isNullOrEmpty(status) ||
//            ApplicationHelper.isNullOrEmpty(propertyID) ||
//            ApplicationHelper.isNullOrEmpty(landlordID) ||
//            ApplicationHelper.amountValid(rentalPrice) ||
//            ApplicationHelper.isNullOrEmpty(location) ||
//            ApplicationHelper.addressIsNullorEmpty(address))
//            return null;
//
//        return new PropertyListingApplication.Builder()
//                .setAppNo(appNo)
//                .setDate(date)
//                .setStatus(Application.Status.valueOf(status))
//                .setPropertyID(propertyID)
//                .setLandlordID(landlordID)
//                .setRentalPrice(rentalPrice)
//                .setLocation(location)
//                .setAddress(address)
//                .build();
//    }
//}
