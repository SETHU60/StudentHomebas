package za.ac.cput.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Mpumzi Mbula
 * 219053324
 * 24/04/2024
 * Student.java
 */
@Entity
public class Student extends User {

    @OneToMany
    private List<Document> documents;
    @OneToOne
    private AcademicDetails academicDetails;
    public Student() {
    }

    private Student(StudentBuilder builder) {

        this.userId = builder.userId;
        this.name = builder.name;
        this.documents = builder.documents;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.password = builder.password;
        this.academicDetails = builder.academicDetails;
        this.contact = builder.contact;


    }


    public AcademicDetails getAcademicDetails() {
        return academicDetails;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(academicDetails, student.academicDetails) && Objects.equals(documents, student.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academicDetails, documents);
    }

    @Override
    public String toString() {
        return "Student{" +
                ", userId=" + userId +
                "academicDetails=" + academicDetails +
                ", documents=" + documents +
                ", name=" + name +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class StudentBuilder {
        private Long userId;
        private AcademicDetails academicDetails;

        private List<Document> documents;

        private Name name;
        private String gender;
        private LocalDate dateOfBirth;
        private String password;

        private Contact contact;

        public StudentBuilder() {
        }

        public StudentBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public StudentBuilder setAcademicDetails(AcademicDetails academicDetails) {
            this.academicDetails = academicDetails;
            return this;
        }

        public StudentBuilder setDocuments(List<Document> documents) {
            this.documents = documents;
            return this;
        }

        public StudentBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public StudentBuilder copy(Student student) {
            this.userId = student.userId;
            this.name = student.name;
            this.documents = student.documents;
            this.gender = student.gender;
            this.dateOfBirth = student.dateOfBirth;
            this.password = student.password;
            this.academicDetails = student.academicDetails;
            this.contact = student.contact;

            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }


}
