package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Application;
import za.ac.cput.domain.StudentApplication;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentApplicationFactoryTest {

    LocalDate dateApplied = LocalDate.of(2023,8,23);

    StudentApplication studentApplication1 = new StudentApplication
            .Builder().setAppNo("12").setDate(LocalDate.now())
            .setStatus(Application.Status.Pending).setStudentID("219149364")
            .setPropertyID("263").setPrice(3750.50).build();

    StudentApplication studentApplication2 = new StudentApplication
            .Builder().setAppNo("16").setDate(dateApplied)
            .setStatus(Application.Status.Accepted).setStudentID("224384995")
            .setPropertyID("261").setPrice(4000.50).build();

    StudentApplication studentApplication3 = studentApplication1;
    @Test
    void createStudentApplication(){
        assertNotNull(studentApplication1);
        System.out.println("Applied Successfully:");
        System.out.println(studentApplication1);
    }

    @Test
    void studentApplicationEqualityFailTest(){
        System.out.println(studentApplication1);
        System.out.println("------------------------------");
        System.out.println(studentApplication2);
        assertEquals(studentApplication1, studentApplication2);

    }

    @Test
    void studentApplicationEqualityPassTest(){
        assertEquals(studentApplication1, studentApplication3);
        System.out.println("Equality Test Passed");
    }

}