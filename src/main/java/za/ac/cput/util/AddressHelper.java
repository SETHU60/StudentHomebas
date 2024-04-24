package za.ac.cput.util;

public class AddressHelper {
    public static boolean isIntEmpty(Integer n){
        if(n == 0)
            return true;
        return false;

    }
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }
}
