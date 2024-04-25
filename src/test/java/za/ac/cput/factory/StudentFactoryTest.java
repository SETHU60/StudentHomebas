package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
     Student student1;
     Student student2;
     Student student3;
     Address address1;
     Address address2;
     Contact contact1;
     Contact contact2;
     AcademicDetails academicDetails1;
     AcademicDetails academicDetails2;


    @BeforeEach
    void setUp() {
        //Student 1
        address1= AddressFactory.buildAddress(106,"Gasela","Gugulethu","Cape Town");
        contact1=new Contact.Builder().setAddress(address1).setEmail("mphumzimbula@gmail.com").setPhoneNumber("0658436358").build();
        academicDetails1=new AcademicDetails.Builder().setAcademicDetailsID("1").setStudentNo("219053324").setInstituteName("CPUT").setYearOfStudy(3).setProgramOfStudy("DICT:Application Development").build();

        student1=StudentFactory.buildStudent("Mpumzi","Mbula","Male", LocalDate.of(2000,06,20),"219053324",academicDetails1,contact1);

    //Student 2
        address2= AddressFactory.buildAddress(7556,"Jan Smarts","BrackenFell","Cape Town");
        contact2=new Contact.Builder().setAddress(address2).setEmail("kaileymansoon@gmail.com").setPhoneNumber("0756355778").build();
        academicDetails2=new AcademicDetails.Builder().setAcademicDetailsID("2").setStudentNo("222058829").setInstituteName("CPUT").setYearOfStudy(3).setProgramOfStudy("DICT:Application Development").build();

        student2=StudentFactory.buildStudent("Kailey","Mansoon","", LocalDate.of(2002,05,17),"Mpu@2022!!",academicDetails2,contact2);

    student3=student1;
    }

    @Test
    void checkIfNull(){
        assertNull(student2);
        System.out.println(student2);
    }
    @Test
    void checkIfNotNull(){
        assertNotNull(student1);
        System.out.println(student1);;
    }
    @Test
    void equalityTest(){
        assertEquals(student1,student2);
        System.out.println("Not Equal");

    }
    @Test
    void identityTest(){
        assertSame(student1,student3);
        System.out.println("Identical");
    }
}