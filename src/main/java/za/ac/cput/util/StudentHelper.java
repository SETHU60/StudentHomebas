package za.ac.cput.util;

import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Contact;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentHelper {

    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;

        }
        return false;
    }

    public static boolean isAcademicDetailsNull(AcademicDetails academicDetails){
        if(academicDetails==null){
            return true;
        }
        return false;
    }

     public static boolean isContactNull(Contact contact){
        if(contact==null){
            return true;
        }
        return false;
     }
     public static boolean isValidDate(LocalDate localDate){
         String dateFormat = "yyyy/MM/dd";
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
         String formattedDate = localDate.format(formatter);
         return formattedDate.matches(dateFormat);
     }
}
