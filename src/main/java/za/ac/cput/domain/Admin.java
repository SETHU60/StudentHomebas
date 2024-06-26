package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;

    public Admin() {
    }

    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        this.contact = builder.contact;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        if (!super.equals(o)) return false;
        return adminId == admin.adminId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adminId);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private String lastName;
        private String firstName;
        private String gender;
        private LocalDate dateOfBirth;
        private String password;
        private Contact contact;
        private long adminId;

        public Builder() {}

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
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

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setAdminId(long adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder copy(Admin admin) {
            this.firstName = admin.firstName;
            this.lastName = admin.lastName;
            this.gender = admin.gender;
            this.dateOfBirth = admin.dateOfBirth;
            this.password = admin.password;
            this.contact = admin.contact;
            this.adminId = admin.adminId;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
