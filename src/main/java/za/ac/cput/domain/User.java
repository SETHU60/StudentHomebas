package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String lastName;
    private String firstName;
    private String gender;
private LocalDate dateOfBirth;
private String password;

    public User(UserBuilder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName,firstName,gender,dateOfBirth,password);
    }
    public static class UserBuilder{
        private String lastName;
        private String firstName;
        private String gender;
        private LocalDate dateOfBirth;
        private String password;

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
