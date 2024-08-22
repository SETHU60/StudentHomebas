package za.ac.cput.service.PropertyService;

import org.junit.jupiter.api.*;
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
    static BufferedImage accomodation1;
    static ByteArrayOutputStream out1;
    static BufferedImage bedroom1;
    static ByteArrayOutputStream out2;
    static BufferedImage view1;
    static ByteArrayOutputStream out3;
    static BufferedImage kitchen1 ;
    static ByteArrayOutputStream out4;

    static BufferedImage accomodation2;
    static ByteArrayOutputStream out5;
    static BufferedImage bedroom2;
    static ByteArrayOutputStream out6;
    static BufferedImage view2;
    static ByteArrayOutputStream out7;
    static BufferedImage kitchen2 ;
    static ByteArrayOutputStream out8;

    List<Document> documentList = new ArrayList<>();
    List<Document> pictures = new ArrayList<>();

    Document document1;
    Document document2;
    Document document3;
    Document document4;

    @BeforeEach
    void setUp() {



        try {
            accomodation1= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\accomodation1.jpg"));
            out1 = new ByteArrayOutputStream();
            ImageIO.write(accomodation1, "jpeg", out1);

            view1= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\view1.jpg"));
            out2 = new ByteArrayOutputStream();
            ImageIO.write(view1, "jpeg", out2);

            kitchen1= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\kitchen1.jpg"));
            out3 = new ByteArrayOutputStream();
            ImageIO.write(kitchen1, "jpeg", out3);

            bedroom1= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\bedroom1.jpg"));
            out4 = new ByteArrayOutputStream();
            ImageIO.write(bedroom1, "jpeg", out4);

            accomodation2= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\accomodation2.jpg"));
            out5 = new ByteArrayOutputStream();
            ImageIO.write(accomodation2, "jpeg", out5);

            view2= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\view2.jpg"));
            out6 = new ByteArrayOutputStream();
            ImageIO.write(view2, "jpeg", out6);

            kitchen2= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\kitchen2.jpg"));
            out7 = new ByteArrayOutputStream();
            ImageIO.write(kitchen2, "jpeg", out7);

            bedroom2= ImageIO.read(new File("C:\\Users\\User\\Documents\\IntelliJ Projects 2024\\StudentHomebas\\images\\bedroom2.jpg"));
            out8 = new ByteArrayOutputStream();
            ImageIO.write(bedroom2, "jpeg", out8);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        document1 = DocumentFactory.buildDocument(001L,"OutSidePhoto1", out1.toByteArray(), LocalDateTime.of(LocalDate.of(2024,04,11), LocalTime.of(11,14)));
        System.out.println(document1);
        document2= DocumentFactory.buildDocument(002L,"view", out2.toByteArray(), LocalDateTime.of(LocalDate.of(2024,05,1), LocalTime.of(11,14)));
        System.out.println(document2);
        document3= DocumentFactory.buildDocument(003L,"kitchen", out3.toByteArray(), LocalDateTime.of(LocalDate.of(2024,03,17), LocalTime.of(11,14)));
        System.out.println(document3);
        document4= DocumentFactory.buildDocument(004L,"bedroom", out4.toByteArray(), LocalDateTime.of(LocalDate.of(2024,04,23), LocalTime.of(11,14)));
        System.out.println(document4);

        documentList.add(document1);

        documentList.add(document2);

        documentList.add(document3);

        documentList.add(document4);


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
    @Disabled
    void read() {
        Property read = service.read(property1.getPropertyID());
        assertNotNull(read);
        System.out.println("Read Property: " + read);
    }

    @Test
   @Disabled
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
    @Disabled
    void delete() {
        Boolean deleted = service.deleteById(property1.getPropertyID());
        assertEquals(true, deleted);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}