package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.StudentFavouriteProperty;

import static org.junit.jupiter.api.Assertions.*;

class StudentFavPropertyFactoryTest {

    StudentFavouriteProperty stdFavProperty1;
    Long studentId, propertyId;
    @BeforeEach
    void setUp() {
        stdFavProperty1 = StudentFavPropertyFactory.buildStudentFavProperty(1467L,64873L);
    }

    @Test
    void buildStudentFavProperty() {
        assertNotNull(stdFavProperty1);
        System.out.println(stdFavProperty1);
    }
}