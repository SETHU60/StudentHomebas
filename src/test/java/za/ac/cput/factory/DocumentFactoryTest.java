package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Document;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DocumentFactoryTest {
    private static Document document1;
    private static Document document2;
    private static Document document3;
    private static byte[] file;

    @BeforeAll
    static void setUp() {
        file=new byte[0];

        document1 = DocumentFactory.buildDocument(1L,"MpumziMbulaDocument.pdf", file, LocalDateTime.of(LocalDate.of(2024,03,24), LocalTime.of(14,22)));
        document2 = DocumentFactory.buildDocument(2L,"", file, LocalDateTime.of(LocalDate.of(2024,04,11), LocalTime.of(11,14)));
        document3 = DocumentFactory.buildDocument(3L,"KeituMetse.pdf", file, LocalDateTime.of(LocalDate.of(2025,01,16), LocalTime.of(12,16)));
    }

    @Test
    void buildDocument() {
        assertNotNull(document1);
        System.out.println(document1);
    }

    @Test
    void buildDocumentWithEmptyNameMustBeNull() {
        assertNull(document2);
        System.out.println(document2);
    }

    @Test
    void buildDocumentWithFutureUpdatedDateMustBeNull() {
        assertNull(document3);
        System.out.println(document3);
    }


}