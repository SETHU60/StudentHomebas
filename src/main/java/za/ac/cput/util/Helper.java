package za.ac.cput.util;

import java.time.LocalDate;
import java.util.List;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if (s == null || s.isEmpty()){
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

}
