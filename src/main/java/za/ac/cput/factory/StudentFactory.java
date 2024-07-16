package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StudentHelper;

import java.time.LocalDate;
import java.util.List;

public class StudentFactory {

    public static Student buildStudent(Long studentId, String firstname, String lastName, String gender, LocalDate dateOfBirth, String password, AcademicDetails academicDetails, Contact contact, List<Document> studentDocuments) {
        if (studentId <= 0 || Helper.isNullOrEmpty(firstname) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(gender) ||
                Helper.isInvalidDate(dateOfBirth) ||
                Helper.isNullOrEmpty(password) ||
                Helper.isObjectNull(academicDetails) ||
                Helper.isObjectNull(contact) ||
                Helper.isListNullorEmpty(studentDocuments)) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstname)
                .setLastName(lastName)
                .build();

        return new Student.StudentBuilder()
                .setUserId(studentId)
                .setName(name)
                .setDocuments(studentDocuments)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .setPassword(password)
                .setAcademicDetails(academicDetails)
                .setContact(contact)
                .build();
    }

    public static Student buildStudent(Long studentId, String firstname, String middleName,String lastName, String gender, LocalDate dateOfBirth, String password, AcademicDetails academicDetails, Contact contact, List<Document> studentDocuments) {
        if (studentId <= 0 || Helper.isNullOrEmpty(firstname) ||
                Helper.isNullOrEmpty(middleName)||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(gender) ||
                Helper.isInvalidDate(dateOfBirth) ||
                Helper.isNullOrEmpty(password) ||
                Helper.isObjectNull(academicDetails) ||
                Helper.isObjectNull(contact) ||
                Helper.isListNullorEmpty(studentDocuments)) {
            return null;
        }
        Name name = new Name.NameBuilder()
                .setFirstName(firstname)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();

        return new Student.StudentBuilder()
                .setUserId(studentId)
                .setName(name)
                .setDocuments(studentDocuments)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .setPassword(password)
                .setAcademicDetails(academicDetails)
                .setContact(contact)
                .build();
    }


}
