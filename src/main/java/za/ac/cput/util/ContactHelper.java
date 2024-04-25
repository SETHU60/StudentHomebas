package za.ac.cput.util;


import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import za.ac.cput.domain.Address;

import java.util.regex.Pattern;

public class ContactHelper {

    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isAddressNullOrEmpty(Address address) {
        if (address == null || isNullOrEmpty(address.toString())) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}

