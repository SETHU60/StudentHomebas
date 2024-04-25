package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import za.ac.cput.domain.AcademicDetails;

import static org.junit.jupiter.api.Assertions.*;

class AcademicDetailsFactoryTest {
    private AcademicDetails testAcademicDetails1;
    private AcademicDetails testAcademicDetails2;

    @BeforeEach
    void setUp() {
        testAcademicDetails1 = AcademicDetailsFactory.buildAcademicDetails("ACD01",
                "221164014", "Cape Peninsula University of Technology", "Diploma in ICT", 3);

        testAcademicDetails2 = AcademicDetailsFactory.buildAcademicDetails("ACD01",
                null, "Cape Peninsula University of Technology", "Diploma in ICT", 3);

    }

    @Test
    void buildAcademicDetails() {
        assertNotNull(testAcademicDetails1);

    }

    @Test
    void buildAcademicDetailsWithNullValues() {
    //Test should pass because object with any null value will return null
    assertNull(testAcademicDetails2);

    }



    }

