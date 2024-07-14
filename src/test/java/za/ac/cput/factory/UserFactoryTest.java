package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserFactoryTest {

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        Name name1 = new Name("John", "Doe");
        Contact contact1 = new Contact("123-456-7890", "john.doe@example.com");

        user1 = UserFactory.buildUser(name1, "Male", "securepassword", LocalDate.of(1990, 1, 1))
                .setContact(contact1)
                .build();

        Name name2 = new Name("", "Doe");
        Contact contact2 = new Contact("123-456-7890", "jane.doe@example.com");

        user2 = UserFactory.buildUser(name2, "Female", "securepassword", LocalDate.of(1992, 2, 2))
                .setContact(contact2)
                .build();

        Name name3 = new Name("Jane", "Doe");
        Contact contact3 = new Contact("123-456-7890", "jane.doe@example.com");

        user3 = UserFactory.buildUser(name3, "Female", "", LocalDate.of(1992, 2, 2))
                .setContact(contact3)
                .build();
    }

    @Test
    void buildUserWithValidDetails() {
        assertNotNull(user1);
        System.out.println(user1);
    }

    @Test
    void buildUserWithInvalidNameMustFail() {
        assertNull(user2);
        System.out.println(user2);
    }

    @Test
    void buildUserWithInvalidPasswordMustFail() {
        assertNull(user3);
        System.out.println(user3);
    }
}
