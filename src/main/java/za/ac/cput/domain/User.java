package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    protected String lastName;
    protected String firstName;
   protected String gender;
   protected LocalDate dateOfBirth;
    protected String password;
   protected Contact contact;

   protected User(){}


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
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
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return lastName == user.lastName && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName) && Objects.equals(gender, user.gender) && Objects.equals(dateOfBirth, user.dateOfBirth)&& Objects.equals(password, user.password)&& Objects.equals(contact, user.contact);
    }
    public int hashCode() {
        return Objects.hash(lastName, firstName, gender, dateOfBirth,password,contact);
    }




}
