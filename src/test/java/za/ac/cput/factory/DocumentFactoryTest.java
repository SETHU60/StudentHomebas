package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Document;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DocumentFactoryTest {
Document document1;
Document document2;
Document document3;
    @BeforeEach
    void setUp() {
        //Document1
        document1=DocumentFactory.buildDocument("MpumziMbulaDocument",new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\src\\main\\java\\za\\ac\\cput\\MpumziMbulaDocument.txt"));

        //Document 2
        document2=DocumentFactory.buildDocument("KaileyMansoonCopyOfID",new File(""));
        document3=document1;
    }
    @Test
    void checkIfNull(){
        assertNull(document2);
        System.out.println(document2);
    }
    @Test
    void checkIfNotNull(){
        assertNotNull(document1);
        System.out.println(document1);
    }
    @Test
    void equalityTest(){
        assertEquals(document2,document1);
        System.out.println("Not Equals");
    }
    @Test
    void identityTest(){
        assertSame(document3,document1);
        System.out.println("Identical");
    }
}