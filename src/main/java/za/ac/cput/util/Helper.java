package za.ac.cput.util;

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
}
