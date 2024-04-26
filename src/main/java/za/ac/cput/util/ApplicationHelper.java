package za.ac.cput.util;

import za.ac.cput.domain.Address;

import java.time.LocalDate;

public class ApplicationHelper {

    public static boolean isNullOrEmpty(String s){
        return s == null || s.isEmpty();
    }
    public static boolean dateIsNull(LocalDate date){
        return date == null;
    }
    public static boolean addressIsNullorEmpty(Address address){
        return address == null;
    }
    public static boolean amountValid(double amount){
        return amount > 0;
    }
}
