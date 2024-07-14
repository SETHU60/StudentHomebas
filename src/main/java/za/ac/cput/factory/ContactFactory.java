package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.ContactHelper;
import za.ac.cput.util.Helper;

public class ContactFactory {

    public static Contact createContact(String phoneNumber, String email, Address address) {
        if (Helper.isNullOrEmpty(phoneNumber) || !Helper.isValidEmail(email) || Helper.isAddressNullOrEmpty(address))
            return null;

        return new Contact.Builder()
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address)
                .build();
    }
}


