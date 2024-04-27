package za.ac.cput.util;

public class UserHelper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidGender(String gender) {
        return gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("other"));
    }

    public static boolean isValidPassword(String password) {


        return password != null && password.length() >= 8;
    }
}
