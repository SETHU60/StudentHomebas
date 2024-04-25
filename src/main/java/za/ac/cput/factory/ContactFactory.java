package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.ContactHelper;

public class ContactFactory {

    public static Contact createContact(String phoneNumber, String email, Address address) {
        if (ContactHelper.isNullOrEmpty(phoneNumber) || !ContactHelper.isValidEmail(email) || address == null)
            return null;

        return new Contact.Builder()
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address)
                .build();
    }
}

