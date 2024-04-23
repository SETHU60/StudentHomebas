package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String lastName;
    private String firstName;
   private String gender;
   private LocalDate dateOfBirth;
    private String password;
   private Contact contact;

   protected User(UserBuilder userBuilder){}

    public User(String lastName, String firstName, String gender, LocalDate dateOfBirth, String password, Contact contact) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.contact = contact;
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

    public static class UserBuilder{
        private String lastName;
        private String firstName;
        private String gender;
        private LocalDate dateOfBirth;
        private String password;
        private Contact contact;

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

        public UserBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }
        public User buildUser(){return new User(this);}
    }


}
