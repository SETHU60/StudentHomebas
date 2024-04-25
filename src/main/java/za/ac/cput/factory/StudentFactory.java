package za.ac.cput.factory;

import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Student;
import za.ac.cput.util.StudentHelper;

import java.time.LocalDate;

public class StudentFactory {

    public static Student buildStudent(String firstname, String lastName, String gender, LocalDate dateOfBirth, String password, AcademicDetails academicDetails, Contact contact){
        if(StudentHelper.isNullOrEmpty(firstname)||
                StudentHelper.isNullOrEmpty(lastName)||
                StudentHelper.isNullOrEmpty(gender)||
                StudentHelper.isValidDate(dateOfBirth)||
                StudentHelper.isNullOrEmpty(password)||
                StudentHelper.isAcademicDetailsNull(academicDetails)||
                StudentHelper.isContactNull(contact)){
            return null;
        }
        return new Student.Builder().setFirstName(firstname).
                setLastName(lastName).
                setGender(gender).
                setDateOfBirth(dateOfBirth).
                setPassword(password).
                setAcademicDetails(academicDetails).
                setContact(contact).build();

    }
}
