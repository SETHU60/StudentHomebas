package za.ac.cput.util;

import za.ac.cput.domain.Landlord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class LandlordDocumentHelper {

    public static boolean isNullOrEmpty(String a) {
        if (a == null || a.isEmpty()) {
            return true;
        }
        return false;
    }
    public static boolean isLandlordNull(Landlord landlord) {
        if ( landlord == null) {
            return true;
        }
        return false;
    }

    public static boolean isValidDate(LocalDateTime localDateTime){
        String dateFormat = "yyyy/MM/dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        String formattedDate = localDateTime.format(formatter);
        return formattedDate.equals(dateFormat);
    }
}
