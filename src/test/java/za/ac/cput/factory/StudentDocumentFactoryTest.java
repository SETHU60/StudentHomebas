package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StudentDocumentFactoryTest {

    Student student1;
    Student student2;
    Address address1;
    Address address2;
    Contact contact1;
    Contact contact2;
    AcademicDetails academicDetails1;
    AcademicDetails academicDetails2;

    Document document1;
    Document document2;
    StudentDocument studentDocument1;
    StudentDocument studentDocument2;
    StudentDocument getStudentDocument3;
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

        student2=StudentFactory.buildStudent("Kailey","Mansoon","Female", LocalDate.of(2002,05,17),"Mpu@2022!!",academicDetails2,contact2);

        //Document1
        document1=DocumentFactory.buildDocument("MpumziMbulaDocument",new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\src\\main\\java\\za\\ac\\cput\\MpumziMbulaDocument.txt"));

       //Document 2
        document2=DocumentFactory.buildDocument("KaileyMansoonCopyOfID",new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\src\\main\\java\\za\\ac\\cput\\MpumziMbulaDocument.txt"));

        //studentDocument1
        studentDocument1=StudentDocumentFactory.buildStudentDocument(student1,document1, LocalDateTime.now());
        System.out.println(studentDocument1);

        //studentDocument2
        studentDocument2=StudentDocumentFactory.buildStudentDocument(student2,document2,LocalDateTime.now());
        System.out.println(studentDocument2);
    getStudentDocument3=studentDocument1;
    }
    @Test
    void checkIfNotNull(){
        assertNotNull(studentDocument1);
        System.out.println(studentDocument1);
        assertNotNull(student2);
        System.out.println(studentDocument1);
    }

    @Test
    void equalityFailTest(){
        assertEquals(studentDocument1,studentDocument2);
        System.out.println("Not Equal");

    }
    @Test
    void identityTest(){
        assertSame(getStudentDocument3,studentDocument1);
        System.out.println("Identical");
    }
}