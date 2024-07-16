//package za.ac.cput.factory;
//
//
//import za.ac.cput.domain.Application;
//import za.ac.cput.domain.StudentApplication;
//import za.ac.cput.util.ApplicationHelper;
//
//import java.time.LocalDate;
//
///*
// * Author : Sabelo Kama (219149364)
// * Date : 22 April 2024
// * */
//public class StudentApplicationFactory {
//    public static StudentApplication studentApplication(String appNo, LocalDate date,
//                                                        String status, String studentID,
//                                                        String propertyID, double price){
//        if(ApplicationHelper.isNullOrEmpty(appNo) ||
//           ApplicationHelper.dateIsNull(date) ||
//           ApplicationHelper.isNullOrEmpty(status) ||
//           ApplicationHelper.isNullOrEmpty(studentID) ||
//           ApplicationHelper.isNullOrEmpty(propertyID) ||
//           ApplicationHelper.amountValid(price))
//            return null;
//
//        return new StudentApplication.Builder().setAppNo(appNo)
//                .setDate(date)
//                .setStatus(Application.Status.valueOf(status))
//                .setStudentID(studentID)
//                .setPropertyID(propertyID)
//                .setPrice(price)
//                .build();
//    }
//
//}
