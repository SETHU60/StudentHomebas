package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.AdminHelper;

import java.time.LocalDate;

public class AdminFactory {

    public static Admin buildAdmin(String adminId, String firstName, String lastName, String gender, LocalDate dateOfBirth, String password, Contact contact) {
        if (AdminHelper.isNullOrEmpty(lastName) ||
                AdminHelper.isNullOrEmpty(firstName) ||
                AdminHelper.isNullOrEmpty(gender) ||
                AdminHelper.isNullOrEmpty(password) ||
                !AdminHelper.isValidDate(dateOfBirth)|| AdminHelper.isContactNull(contact));


        return new Admin.AdminBuilder()
                .setAdminId(adminId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .setPassword(password).setContact(contact).buildAdmin();
    }
}
