package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")

public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;
    @Embedded
    protected Name name;
    protected String gender;
    protected LocalDate dateOfBirth;
    protected String password;
    @OneToOne
    protected Contact contact;

    public Long getUserId() {
        return userId;
    }

    public Contact getContact() {
        return contact;
    }

    public Name getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }
}
