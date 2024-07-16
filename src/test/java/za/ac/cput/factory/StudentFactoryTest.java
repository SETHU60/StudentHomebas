package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    private static Student student1;
    private static Student student2;

    private static Address address1;
    private static Address address2;
    private static Contact contact1;
    private static   Contact contact2;
    private static  AcademicDetails academicDetails1;
    private static AcademicDetails academicDetails2;
    private static byte[]file1;
    private static byte []file2;
    private static Document document1;
    private static Document document2;
    private static List<Document>studentDocuments1;
    private static List<Document>studentDocuments2;



    @BeforeAll
    static void setUp() {

        file1=new byte[0];
        file2=new byte[1];

        document1 = DocumentFactory.buildDocument(1L,"MpumziMbulaDocument.pdf", file1, LocalDateTime.of(LocalDate.of(2024,03,24), LocalTime.of(14,22)));
        document2 = DocumentFactory.buildDocument(2L,"Transcript.pdf", file2, LocalDateTime.of(LocalDate.of(2024,04,11), LocalTime.of(11,14)));

        studentDocuments1=new ArrayList<>();
        studentDocuments1.add(document1);

        studentDocuments2=new ArrayList<>();
        studentDocuments2.add(document2);

        //Student 1
        address1= AddressFactory.buildAddress("Ny 6 No 106","Gugulethu","Cape Town","Cape Town");
        contact1=new Contact.Builder().setAddress(address1).setEmail("mphumzimbula@gmail.com").setPhoneNumber("0658436358").build();
        academicDetails1=new AcademicDetails.Builder().setAcademicDetailsID("1").setInstituteName("CPUT").setYearOfStudy(3).setProgramOfStudy("DICT:Application Development").build();

        student1=StudentFactory.buildStudent(1L,"Mpumzi","Mbula","Male", LocalDate.of(2000,06,20),"20Mphmbu16!",academicDetails1,contact1,studentDocuments1);

    //Student 2
        address2= AddressFactory.buildAddress("7556 Jan Smart","BrackenFell","Cape Town","7750");
        contact2=new Contact.Builder().setAddress(address2).setEmail("kaileymansoon@gmail.com").setPhoneNumber("0756355778").build();
        academicDetails2=new AcademicDetails.Builder().setAcademicDetailsID("2").setInstituteName("CPUT").setYearOfStudy(3).setProgramOfStudy("DICT:Application Development").build();

        student2=StudentFactory.buildStudent(2L,"Kailey","Mansoon","Zhubhear","Male", LocalDate.of(2027,05,17),"Mpu@2022!!",academicDetails2,contact2,studentDocuments2);


    }

    @Test
    void buildStudent(){
        assertNotNull(student1);
        System.out.println(student1);
    }
    @Test
    void buildStudentWithFutureDateOfBirthMustBeNull(){
        assertNull(student2);
        System.out.println(student2);;
    }


}