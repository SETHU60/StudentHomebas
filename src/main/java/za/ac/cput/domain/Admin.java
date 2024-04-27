package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Admin  extends User{
    private String adminId;

    public Admin(AdminBuilder builder){

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        this.contact = builder.contact;
        this.adminId = builder.adminId;

    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(adminId, admin.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), adminId);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class AdminBuilder{
        private String firstName;
        private String lastName;
        private String gender;
        private LocalDate dateOfBirth;
        private String password;
        private Contact contact;


        private String adminId;
        public Admin.AdminBuilder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }
        public Admin.AdminBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Admin.AdminBuilder setGender(String gender){
            this.gender = gender;
            return this;
        }
        public Admin.AdminBuilder setDateOfBirth(LocalDate dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Admin.AdminBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Admin.AdminBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Admin.AdminBuilder setContact(Contact contact){
            this.contact = contact;
            return this;
        }
        public Admin buildAdmin(){return new Admin(this);}
    }
}

