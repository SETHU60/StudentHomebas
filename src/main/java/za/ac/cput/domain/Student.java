package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Mpumzi Mbula
 * 219053324
 * 24/04/2024
 * Student.java
 *
 */
public class Student extends User {
    private AcademicDetails academicDetails;

    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        this.academicDetails = builder.academicDetails;
        this.contact = builder.contact;

    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public Contact getContact() {
        return super.getContact();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    public AcademicDetails getAcademicDetails() {
        return academicDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(academicDetails, student.academicDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), academicDetails);
    }

    @Override
    public String toString() {
        return "Student{" +
                "academicDetails=" + academicDetails +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public class Builder {
        private String firstName;
        private String lastName;

        private String gender;
        private LocalDate dateOfBirth;
        private AcademicDetails academicDetails;
        private String password;
        private Contact contact;


        public Builder() {

        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setAcademicDetails(AcademicDetails academicDetails) {
            this.academicDetails = academicDetails;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Student student) {
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.gender = student.gender;
            this.dateOfBirth = student.dateOfBirth;
            this.contact = student.contact;
            this.academicDetails = student.academicDetails;
            this.password = student.password;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}





