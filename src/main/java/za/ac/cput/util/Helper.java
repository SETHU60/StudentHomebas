package za.ac.cput.util;

import za.ac.cput.domain.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if (s == null || s.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean invalidLong(Long l){
        if (l == null || l == 0){
            return true;
        }
        return false;
    }
    public static boolean invalidDouble(Double d){
        if (d == null || d == 0){
            return true;
        }
        return false;
    }
    public static boolean isListNullorEmpty(List list){
        if(list.isEmpty() || list == null){
            return true;
        }
        return  false;
    }
    public static boolean isObjectNull(Object o){
        if (o.equals(null) || o == null){

            return true;
        }
        return false;

    }
    public static boolean isInvalidDate(LocalDate date) {
        if (date == null) {
            return true;
        }

        LocalDate today = LocalDate.now();
        if (date.isAfter(today)) {
            return true;
        }

        return  false;

    }
    public static boolean isInvalidDateTime(LocalDateTime dateTime) {

        if (dateTime == null) {
            return true;
        }

        LocalDateTime today = LocalDateTime.now();
        if (dateTime.isAfter(today)) {
            return true;
        }

        return  false;

    }
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    public static boolean isAddressNullOrEmpty(Address address) {
        if (address == null || isNullOrEmpty(address.toString())) {
            return true;
        }
        return false;
    }
    public static boolean isByteArrayNull(byte[] file){
        if(file==null){
            return true;
        }
        return false;
    }

}
