package za.ac.cput.util;

import za.ac.cput.domain.Name;

public class UserHelper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidGender(String gender) {
        return gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("other"));
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 10;
    }

    public static boolean isObjectEmpty(Name name) {
        return name == null || isNullOrEmpty(name.getFirstName()) || isNullOrEmpty(name.getLastName());
    }
}
