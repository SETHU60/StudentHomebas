package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    @Embedded
    protected Name name;
    protected String gender;
    protected LocalDate dateOfBirth;
    protected String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    protected Contact contact;

    protected User() {
    }

    public Long getUserId() {
        return userId;
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

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(name, user.name) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(password, user.password) &&
                Objects.equals(contact, user.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, gender, dateOfBirth, password, contact);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name=" + name +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }


}
