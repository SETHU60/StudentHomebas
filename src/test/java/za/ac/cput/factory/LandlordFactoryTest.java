//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Address;
//import za.ac.cput.domain.Contact;
//import za.ac.cput.domain.Document;
//import za.ac.cput.domain.Landlord;
//
//import java.io.File;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LandlordFactoryTest {
//    private Landlord landlord1;
//    private Landlord landlord2;
//    List<Document> documentList = new ArrayList<>();
//    @BeforeEach
//    void setUp() {
//        Document document1 =DocumentFactory.buildDocument("MikeSeptemeberCopyOfID",new File("C:\\Users\\Mbasa Cabane\\Documents\\mbasa"));
//        System.out.println(document1);
//        documentList.add(document1);
//
//        Address address1= AddressFactory.buildAddress("9 Lower Street", "Mowbray", "Cape Town", "5100");
//        Contact contact = ContactFactory.createContact("0786549009", "mikes@gmail.com", address1);
//        landlord1 = LandlordFactory.buildLandlordWithMiddleName(88987L, "Mike", "Matic", "September", "Male", LocalDate.of(1986,8,13), 3, "Mike130886",contact,documentList);
//
//
//    }
//
//    @Test
//    void buildLandlord() {
//        assertNotNull(landlord1);
//        System.out.println(landlord1);
//    }
//}