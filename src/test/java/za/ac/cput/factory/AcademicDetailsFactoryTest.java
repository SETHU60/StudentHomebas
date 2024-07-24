package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class AcademicDetailsFactoryTest {
    private AcademicDetails testAcademicDetails1;
    private AcademicDetails testAcademicDetails2;
    private Student student1;
    @BeforeEach
    void setUp() {
        testAcademicDetails1 = AcademicDetailsFactory.buildAcademicDetails("ACD01", "Cape Peninsula University of Technology", "Diploma in ICT", 3);
        testAcademicDetails2 = AcademicDetailsFactory.buildAcademicDetails("ACD02", "Cape Peninsula University of Technology", "Diploma in ICT", 0);

    }

    @Test
    void buildAcademicDetails() {
        assertNotNull(testAcademicDetails1);

    }

    @Test
    void buildAcademicDetailsWithNullValues() {
    assertNull(testAcademicDetails2);

    }



    }

