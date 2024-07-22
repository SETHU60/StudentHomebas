package za.ac.cput.service.AcademicDetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.AcademicDetailsFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AcademicDetailsServiceTest {
    @Autowired
    private AcademicDetailsService service;

    private AcademicDetails testAcademicDetails1;
    private AcademicDetails testAcademicDetails2;
    private Student student1;

    @BeforeEach
    void setUp() {
        testAcademicDetails1 = AcademicDetailsFactory.buildAcademicDetails("ACD01", "Cape Peninsula University of Technology", "Diploma in ICT", 3);
        testAcademicDetails2 = AcademicDetailsFactory.buildAcademicDetails("ACD02", "Cape Peninsula University of Technology", "Diploma in ICT", 4);

    }

    @Order(1)
    @Test
    void create() {
        testAcademicDetails1 = service.create(testAcademicDetails1);
        assertNotNull(testAcademicDetails1);
        System.out.println("Saved: " + testAcademicDetails1);

        testAcademicDetails2 = service.create(testAcademicDetails2);
        assertNotNull(testAcademicDetails2);
        System.out.println("Saved: " +testAcademicDetails2);
    }

    @Test
    @Order(2)
    void read() {
        AcademicDetails read= service.read(testAcademicDetails1.getAcademicDetailsID());
        assertNotNull(read);
        System.out.println("Read: " + read);


    }

    @Test
    @Order(3)
    void update() {

        AcademicDetails update = new AcademicDetails.Builder().copy(testAcademicDetails2)
                .setYearOfStudy(5)
                .build();

        AcademicDetails updated = service.update(update);
        assertNotNull(testAcademicDetails2);
        System.out.println("Updated: " + updated);
    }


    @Test
    @Order(4)
    void delete() {
        Boolean deleted = service.delete(testAcademicDetails1.getAcademicDetailsID());
        assertEquals(true, deleted);
    }

    @Test
    @Order(5)
    void getAll() {
        List<AcademicDetails> all = service.getAll();
        System.out.println("All: " + all);
    }
}