package za.ac.cput.util;

import za.ac.cput.domain.Contact;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

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
    public static long generateUniqueID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    }
    public static boolean isValidDate(LocalDate dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = dateOfBirth.format(formatter);
        return formattedDate.equals(dateOfBirth.toString());
    }
}
