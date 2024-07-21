package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Document;
import za.ac.cput.factory.DocumentFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DocumentServiceTest {
    @Autowired
    private  DocumentService documentService;
    private static Document document1;
    private static Document document2;
    private static Document document3;
    private static byte[] file;
    private static byte[]file2;



    @BeforeAll
    static void setUp() {

        System.out.println("========================================SETUP================================================");
        file=new byte[0];

        document1 = DocumentFactory.buildDocument(1L,"MpumziMbulaDocument.pdf", file, LocalDateTime.of(LocalDate.of(2024,03,24), LocalTime.of(14,22)));
        System.out.println(document1);
        document2 = DocumentFactory.buildDocument(2L,"AcademicRecord", file, LocalDateTime.of(LocalDate.of(2024,04,11), LocalTime.of(11,14)));
        System.out.println(document2);
        document3 = DocumentFactory.buildDocument(3L,"KeituMetse.pdf", file, LocalDateTime.of(LocalDate.of(2022,01,16), LocalTime.of(12,16)));
        System.out.println(document3);
    }
    @Test
    @Order(1)
    void save() {
        System.out.println("========================================SAVE================================================");
        Document createdDocument1=documentService.save(document1);
        assertNotNull(createdDocument1);
        System.out.println(createdDocument1);

        Document createdDocument2=documentService.save(document2);
        assertNotNull(createdDocument2);
        System.out.println(createdDocument2);

        Document createdDocument3=documentService.save(document3);
        assertNotNull(createdDocument3);
        System.out.println(createdDocument3);


    }

    @Test
    @Order(2)
    void read() {
        System.out.println("========================================READ================================================");
        Document readDocument=documentService.read(2L);
        assertNotNull(readDocument);
        System.out.println(readDocument);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("========================================UPDATE================================================");
        file2=new byte[1];
        file2[0]=1;
        Document documentToUpdate=new Document.Builder().copy(document2).setFileContents(file2).setDateTimeUploaded(LocalDateTime.now()).build();

        Document updatedDocument=documentService.update(documentToUpdate);
        assertNotNull(updatedDocument);
        System.out.println(updatedDocument);
    }

    @Test
    @Order(4)
    void deleteById() {
        System.out.println("========================================DELETE================================================");
        boolean isDeleted=documentService.deleteById(3L);
        assertTrue(isDeleted);
        System.out.println("Cart with cartId:"+document3.getDocumentId()+" is deleted Successfully");
    }

    @Test
    @Order(5)
    void getall() {
        System.out.println("========================================GETALL================================================");
        List<Document>documents=documentService.getall();
        assertNotNull(documents);
        System.out.println(documents);
    }
}