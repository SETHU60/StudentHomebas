package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Property;

import static org.junit.jupiter.api.Assertions.*;

class PropertyFactoryTest {
    private  Property property1;
    private  Property property2;

    @BeforeEach
    void setUp() {
         property1 = PropertyFactory.buildProperty("PR01", "South Point", 10,
                143, "Dorset St", "Woodstock", "Cape Town");

        property2= PropertyFactory.buildProperty("PR02", null, 10,
                10, "Dorset St", "Woodstock", "Cape Town");


    }

    @Test
    void buildAcademicDetails() {
        assertNotNull(property1);

    }

    @Test
    void buildAcademicDetailsWithNullValues() {
        //Test should pass because object with any null value will return null
        assertNull(property2);

    }
}
