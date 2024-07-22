package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Admin extends User {

    public Admin() {
    }

    private Admin(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        this.contact = builder.contact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userId=" + userId +
                ", name=" + name +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private Name name;
        private String gender;
        private LocalDate dateOfBirth;
        private String password;
        private Contact contact;
        private long userId;

        public Builder() {}

        public Builder setName(Name name) {
            this.name = name;
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

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(Admin admin) {
            this.userId = admin.userId;
            this.name = admin.name;
            this.gender = admin.gender;
            this.dateOfBirth = admin.dateOfBirth;
            this.password = admin.password;
            this.contact = admin.contact;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}