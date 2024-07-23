package za.ac.cput.service.PropertyService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.DocumentRepository;
import za.ac.cput.repository.LandlordRepository;
import za.ac.cput.service.AcademicDetails.AcademicDetailsService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PropertyServiceTest {
    @Autowired
    private PropertyService service;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LandlordRepository landlordRepository;

    private Property property1;
    private  Property property2;
    private Landlord landlord1;
    List<Document> documentList = new ArrayList<>();
    List<Document> pictures = new ArrayList<>();
    static BufferedImage image;
    static ByteArrayOutputStream out;
    Document document1;

    @BeforeEach
    void setUp() {
        String url = "download.jpeg";

        //String certificate  = "C:\\Users\\ASUS\\Documents\\3rd-Year\\ADP3\\StudentHomebas\\LinkedIn Learning Certificate.pdf";
        try {

            image = ImageIO.read(new File(url));
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", out);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        byte[] photoData = out.toByteArray();

         document1 = DocumentFactory.buildDocument(001L,"MikeSeptemeberCopyOfID", photoData, LocalDateTime.of(LocalDate.of(2024,04,11), LocalTime.of(11,14)));
        System.out.println(document1);
        documentList.add(document1);

        Address address1= AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
        Contact contact = ContactFactory.createContact("0786549009", "mikes@gmail.com", address1);
        landlord1 = LandlordFactory.buildLandlordWithMiddleName(88987L, "Mike", "Matic",
                "September", "Male", LocalDate.of(1986,8,13), 3,
                "Mike130886",contact,documentList);

        property1 = PropertyFactory.buildProperty("PR01", "South Point", 10,5000,
                "143", "Dorset St", "Woodstock", "Cape Town", landlord1, documentList);

        property2 = PropertyFactory.buildProperty("PR02", "South Point", 10,3500,
                "10", "Sir Lowry Rd", "GoodWood", "Cape Town", landlord1, documentList);

    }


    @Test
    void create() {
        documentRepository.save(document1);
        landlordRepository.save(landlord1);

        Property saved1 = service.save(property1);
        assertNotNull(saved1);
        System.out.println("Saved Property: " + saved1);

        Property saved2 = service.save(property2);
        assertNotNull(saved2);
        System.out.println("Saved Property: " + saved2);

    }

    @Test
    void read() {
        Property read = service.read(property1.getPropertyID());
        assertNotNull(read);
        System.out.println("Read Property: " + read);
    }

    @Test
    void update() {
            Property update = new Property.Builder()
                    .copy(property2)
                    .setPropertyName("Rise")
                    .build();

            Property updated = service.update(update);
            assertNotNull(updated);
            System.out.println("Updated Property: " + updated);
    }

    @Test
    void delete() {
        Boolean deleted = service.deleteById(property1.getPropertyID());
        assertEquals(true, deleted);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}