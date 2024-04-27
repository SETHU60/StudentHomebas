package za.ac.cput.util;

import za.ac.cput.domain.Contact;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdminHelper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
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
    public static boolean isValidDate(LocalDate dateOfBirth) {
        // Assuming the date format is yyyy/MM/dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = dateOfBirth.format(formatter);
        return formattedDate.equals(dateOfBirth.toString());
    }
}
